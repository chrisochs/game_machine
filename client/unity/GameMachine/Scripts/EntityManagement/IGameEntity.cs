﻿using UnityEngine;
using System.Collections;
using TrackData = io.gamemachine.messages.TrackData;

namespace GameMachine {
    namespace Common {
        public interface IGameEntity {

            bool IsPlayer();
            bool IsNpc();
            bool IsOtherPlayer();
            GameEntityType GetGameEntityType();
            Vector3 GetServerLocation();
            IGameEntityController GetGameEntityController();
            string GetEntityId();
            string GetCharacterId();
            Transform GetTransform();
            TrackData GetTrackData();
            void ResetTrackData();
            void UpdateFromTrackData(TrackData trackData, bool hasDelta);
            void Remove();
            NetworkFields GetNetworkFields();
            void SetMovementState(int state);
            void FreezeMovement(float duration);
            Vector3 GetSpawnPoint();
        }
    }
}
