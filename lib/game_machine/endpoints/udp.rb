module GameMachine
  module Endpoints
    class Udp < Actor::Base
      GAME_HANDLER = Settings.game_handler

      def post_init(*args)
        @clients = {}
        @socket = nil
      end

      def preStart
        mgr = JavaLib::Udp.get(getContext.system).getManager
        inet = JavaLib::InetSocketAddress.new(
          Application.config.udp.host,
          Application.config.udp.port
        )
        mgr.tell( JavaLib::UdpMessage.bind(getSelf,inet), getSelf)
      end

      def on_receive(message)
        if message.kind_of?(JavaLib::Udp::Bound)
          @socket = getSender
        elsif message.is_a?(ClientMessage)
          handle_outgoing(message)
        elsif message.kind_of?(JavaLib::Udp::Received)
          handle_incoming(message)
        elsif message == JavaLib::UdpMessage::unbind
          @socket.tell(message, get_self)
        elsif message.kind_of?(JavaLib::Udp::Unbound)
          get_context.stop(get_self)
        else
          unhandled(message)
        end
      end

      private

      def handle_outgoing(message)
        sender = @clients.fetch(message.client_connection.id)
        byte_string = JavaLib::ByteString.from_array(message.to_byte_array)
        udp_message = JavaLib::UdpMessage.send(byte_string, sender)
        @socket.tell(udp_message, get_self)
      rescue Exception => e
        GameMachine.logger.error "#{self.class.name} #{e.to_s}"
      end

      def handle_incoming(message)
        @clients[message.sender.to_s] = message.sender
        client_message = create_client_message(
          message.data.to_array,message.sender.to_s
        )
        Actor::Base.find(GAME_HANDLER).send_message(
          client_message, :sender => get_self
        )
      rescue Exception => e
        GameMachine.logger.error "#{self.class.name} #{e.to_s}"
      end

      def create_client_message(data,client_id)
        ClientMessage.parse_from(data).set_client_connection(
          ClientConnection.new.set_id(client_id).set_gateway(self.class.name).
          set_server(Application.config.name)
        )
      end

      def echo(message)
        byte_string = JavaLib::ByteString.from_array(message.data.to_array)
        udp_message = JavaLib::UdpMessage.send(byte_string, message.sender)
        @socket.tell(udp_message,get_self)
      end

    end
  end
end
