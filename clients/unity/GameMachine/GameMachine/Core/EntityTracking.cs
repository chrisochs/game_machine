﻿using GameMachine;
using System.Collections.Generic;
using System.IO;
using System.Reflection;
using System;
using System.Runtime.Serialization.Formatters.Binary;
using Entity = GameMachine.Messages.Entity;
using TrackEntity = GameMachine.Messages.TrackEntity;
using Vector3 = GameMachine.Messages.Vector3;
using Neighbors = GameMachine.Messages.Neighbors;
using Neighbor = GameMachine.Messages.Neighbor;
using TrackData = GameMachine.Messages.TrackData;

namespace GameMachine.Core
{
    public class EntityTracking : UntypedActor
    {
        
        public Trackable trackable;

        public delegate void UpdateReceived (List<TrackingUpdate> updates);
        private UpdateReceived updateReceived;


        public static void Register (Trackable component)
        {
            EntityTracking entityTracking = ActorSystem.Instance.Find ("EntityTracking") as EntityTracking;
            entityTracking.trackable = component;
            ActorSystem.Instance.InvokeRepeating (entityTracking, "UpdateTracking");
        }

        public void OnUpdateReceived (UpdateReceived callback)
        {
            updateReceived = callback;
        }

        public void UpdateTracking ()
        {
            TrackData trackData = trackable.UpdateTracking ();
            Update (trackData);
        }

        public void Update (TrackData trackData)
        {
            if (trackData == null) {
                return;
            }

            trackData.id = GameMachine.Core.User.Instance.username;
            trackData.entityType = TrackData.EntityType.PLAYER;
            trackData.getNeighbors = 1;

            Entity entity = new Entity ();
            entity.id = "0";
            entity.trackData = trackData;

            // stay on the fastpath server side (no crossing language boundaries)
            entity.fastpath = true;

            // Always regional
            ActorSystem.Instance.FindRegional ("default").Tell (entity);
        }
        public override void OnReceive (object message)
        {
            Entity entity = message as Entity;

            List<TrackingUpdate> updates = new List<TrackingUpdate> ();
            int i = 0;
            foreach (TrackData trackData in entity.neighbors.trackData) {
                TrackingUpdate update = new TrackingUpdate (trackData.id, trackData.x, trackData.y, trackData.z);
                update.trackData = trackData;
                updates.Add (update);
                i++;
            }

            if (trackable != null) {
                trackable.TrackDataReceived (entity.neighbors.trackData);
            }

            if (updateReceived != null) {
                updateReceived (updates);
			
            }
        }
    }
}