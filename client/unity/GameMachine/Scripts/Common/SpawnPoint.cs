﻿using UnityEngine;
using System.Collections;
using System.Collections.Generic;

namespace GameMachine {
    namespace Common {
        public class SpawnPoint : MonoBehaviour {

            public List<GameObject> defaultSpawnPoints = new List<GameObject>();
            public float heightOffset = 3f;
            public bool forceLocal = false;
            public bool spawned = false;

            public static SpawnPoint Instance() {
                return GameObject.FindObjectOfType<SpawnPoint>() as SpawnPoint;
            }

            void Start() {
                InvokeRepeating("SaveLocal", 1f, 5f);
            }

            public void SaveLocal() {
                if (!spawned) {
                    return;
                }

                Transform t = GamePlayer.Instance().playerTransform;
                if (t == null) {
                    return;
                }

                Vector3 position = t.position;
                PlayerPrefs.SetFloat("spawnx", position.x);
                PlayerPrefs.SetFloat("spawny", position.y);
                PlayerPrefs.SetFloat("spawnz", position.z);
            }

            public Vector3 GetSavedLocal() {
                float x = PlayerPrefs.GetFloat("spawnx");
                float y = PlayerPrefs.GetFloat("spawny");
                float z = PlayerPrefs.GetFloat("spawnz");
                return new Vector3(x, y, z);
            }

            public Vector3 SpawnpointExact() {
                IGameEntity player = GameEntityManager.GetPlayerEntity();
                if (player != null) {
                    if (player.GetSpawnPoint() != Vector3.zero) {
                        spawned = true;
                        Debug.Log("Spawning from network spawnpoint");
                        return player.GetSpawnPoint();
                    }
                }

                Vector3 saved = GetSavedLocal();
                if (saved != Vector3.zero) {
                    spawned = true;
                    Debug.Log("Spawning from local save spawnpoint");
                    return new Vector3(saved.x, saved.y, saved.z);
                }

                GameObject spawnPoint = GameObject.Find("spawnpoint");
                if (spawnPoint == null) {
                    Debug.Log("Unable to find spawnpoint, giving up");
                    return Vector3.zero;
                }

                Vector3 groundedPosition = GroundedPosition(spawnPoint.transform.position, heightOffset);
                if (groundedPosition != Vector3.zero) {
                    spawned = true;
                    return groundedPosition;
                } else {
                    Debug.Log("Unable to find grounded position from spawnpoint, giving up");
                    return Vector3.zero;
                }
            }

            public Vector3 SpawnpointOnTerrain() {
                Vector3 groundedPosition;
                Vector3 saved = GetSavedLocal();
                if (saved != Vector3.zero) {
                    groundedPosition = GroundedPosition(saved, heightOffset);
                    if (groundedPosition != Vector3.zero) {
                        spawned = true;
                        return groundedPosition;
                    } else {
                        Debug.Log("Unable to find grounded position from last save point");
                    }
                }

                GameObject spawnPoint = GameObject.Find("spawnpoint");
                if (spawnPoint == null) {
                    Debug.Log("Unable to find spawnpoint, giving up");
                    return Vector3.zero;
                }

                groundedPosition = GroundedPosition(spawnPoint.transform.position, heightOffset);
                if (groundedPosition != Vector3.zero) {
                    spawned = true;
                    return groundedPosition;
                } else {
                    Debug.Log("Unable to find grounded position from spawnpoint, giving up");
                    return Vector3.zero;
                }
            }

            public Vector3 GetClosest(Vector3 position) {
                float max = 100000f;
                GameObject best = null;
                foreach (GameObject spawnPoint in defaultSpawnPoints) {
                    float dist = Vector3.Distance(spawnPoint.transform.position, position);
                    if (dist < max) {
                        max = dist;
                        best = spawnPoint;
                    }
                }
                return GroundedPosition(best.transform.position, heightOffset);
            }

            public Vector3 GroundedPosition(Vector3 position) {
                return GroundedPosition(position, heightOffset);
            }

            public Vector3 GroundedPosition(Vector3 position, float offset) {
                Vector3 start = new Vector3(position.x, 900f, position.z);
                RaycastHit[] hits;
                hits = Physics.RaycastAll(start, Vector3.down, 1000f);
                foreach (RaycastHit hit in hits) {
                    if (hit.collider != null && (hit.collider.gameObject.name.StartsWith("Terrain") || hit.collider.gameObject.tag == "gm_placed_block")) {
                        return new Vector3(position.x, hit.point.y + offset, position.z);
                    }
                }
                return Vector3.zero;
            }
        }
    }
}
