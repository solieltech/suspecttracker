package com.example.suspectservice.firebase.config;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Copyright 2017 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */



import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.DocumentReference;
// [START fs_include_dependencies]
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
// [END fs_include_dependencies]
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.common.collect.ImmutableMap;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

/**
 * A simple Quick start application demonstrating how to connect to Firestore
 * and add and query documents.
 */
public class QuickStart {

  private Firestore db;

  /**
   * Initialize Firestore using default project ID.
   */
  public QuickStart() {
    // [START fs_initialize]
    Firestore db = FirestoreOptions.getDefaultInstance().getService();
    // [END fs_initialize]
    this.db = db;
  }

  public QuickStart(String projectId) {
	  
	  
	/*// Use a service account
	  InputStream serviceAccount = new FileInputStream("path/to/serviceAccount.json");
	  GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount);
	  FirebaseOptions options = new FirebaseOptions.Builder()
	      .setCredentials(credentials)
	      .build();
	  FirebaseApp.initializeApp(options);

	  Firestore db = FirestoreClient.getFirestore();*/
	  
	  
	  
	  try{
  // [START fs_initialize_project_id]
	  FileInputStream serviceAccount =
			  new FileInputStream("D:\\Kiran_work\\Suspect-Tracker\\suspecttracker-f43b5-firebase-adminsdk-yf2dt-14d05d3e32.json");
    FirestoreOptions firestoreOptions = FirestoreOptions.getDefaultInstance().toBuilder()
    		.setCredentials(GoogleCredentials.fromStream(serviceAccount))
    		.setHost("https://suspecttracker-f43b5.firebaseio.com")
    		.setProjectId(projectId).build();
    Firestore db = firestoreOptions.getService();
    
    
db.getCollections().forEach((ref)->{
    	
    	System.out.println("doc id ::: "+ref.getId());
    });
    //System.out.println("db name :: " );
    
    this.db = db;
	  }catch(Exception ex){
		  ex.printStackTrace();
	  }
    // [END fs_initialize_project_id]
    
    
    //FirestoreOptions.g
  
	  /*try{
		  FileInputStream serviceAccount =
				  new FileInputStream("D:\\Kiran_work\\Suspect-Tracker\\suspecttracker-f43b5-firebase-adminsdk-yf2dt-14d05d3e32.json");

			FirebaseOptions options = new FirebaseOptions.Builder()
			  .setCredentials(GoogleCredentials.fromStream(serviceAccount))
			  .setDatabaseUrl("https://suspecttracker-f43b5.firebaseio.com")
			  .build();

			FirebaseApp.initializeApp(options);
			
			FirestoreOptions.
			
			Firestore db = options.getService();
	  
	  this.db = db;
	  
	  }catch(Exception ex){
		  ex.printStackTrace();
	  }*/
  }

  Firestore getDb() {
    return db;
  }

  /**
   * Add named test documents with fields first, last, middle (optional), born.
   *
   * @param docName document name
   */
  void addDocument(String docName) throws Exception {
    switch (docName) {
      case "alovelace": {
        // [START fs_add_data_1]
        DocumentReference docRef = db.collection("users").document("alovelace");
        // Add document data  with id "alovelace" using a hashmap
        Map<String, Object> data = new HashMap<>();
        data.put("first", "Ada");
        data.put("last", "Lovelace");
        data.put("born", 1815);
        //asynchronously write data
        ApiFuture<WriteResult> result = docRef.set(data);
        // ...
        // result.get() blocks on response
        System.out.println("Update time : " + result.get().getUpdateTime());
        // [END fs_add_data_1]
        break;
      }
      case "aturing": {
        // [START fs_add_data_2]
        DocumentReference docRef = db.collection("users").document("aturing");
        // Add document data with an additional field ("middle")
        Map<String, Object> data = new HashMap<>();
        data.put("first", "Alan");
        data.put("middle", "Mathison");
        data.put("last", "Turing");
        data.put("born", 1912);

        ApiFuture<WriteResult> result = docRef.set(data);
        System.out.println("Update time : " + result.get().getUpdateTime());
        // [END fs_add_data_2]
        break;
      }
      case "cbabbage": {
        DocumentReference docRef = db.collection("users").document("cbabbage");
        Map<String, Object> data =
            new ImmutableMap.Builder<String, Object>()
                .put("first", "Charles")
                .put("last", "Babbage")
                .put("born", 1791)
                .build();
        ApiFuture<WriteResult> result = docRef.set(data);
        System.out.println("Update time : " + result.get().getUpdateTime());
        break;
      }
      default:
    }
  }

  void runAQuery() throws Exception {
    // [START fs_add_query]
    // asynchronously query for all users born before 1900
    ApiFuture<QuerySnapshot> query =
        db.collection("users").whereLessThan("born", 1900).get();
    // ...
    // query.get() blocks on response
    QuerySnapshot querySnapshot = query.get();
    List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
    for (QueryDocumentSnapshot document : documents) {
      System.out.println("User: " + document.getId());
      System.out.println("First: " + document.getString("first"));
      if (document.contains("middle")) {
        System.out.println("Middle: " + document.getString("middle"));
      }
      System.out.println("Last: " + document.getString("last"));
      System.out.println("Born: " + document.getLong("born"));
    }
    // [END fs_add_query]
  }

  void retrieveAllDocuments() throws Exception {
    // [START fs_get_all]
    // asynchronously retrieve all users
    ApiFuture<QuerySnapshot> query = db.collection("users").get();
    // ...
    // query.get() blocks on response
    QuerySnapshot querySnapshot = query.get();
    List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
    for (QueryDocumentSnapshot document : documents) {
      System.out.println("User: " + document.getId());
      System.out.println("First: " + document.getString("first"));
      if (document.contains("middle")) {
        System.out.println("Middle: " + document.getString("middle"));
      }
      System.out.println("Last: " + document.getString("last"));
      System.out.println("Born: " + document.getLong("born"));
    }
    // [END fs_get_all]
  }

  void run() throws Exception {
    String[] docNames = {"alovelace", "aturing", "cbabbage"};

    // Adding document 1
    System.out.println("########## Adding document 1 ##########");
    addDocument(docNames[0]);

    // Adding document 2
    System.out.println("########## Adding document 2 ##########");
    addDocument(docNames[1]);

    // Adding document 3
    System.out.println("########## Adding document 3 ##########");
    addDocument(docNames[2]);

    // retrieve all users born before 1900
    System.out.println("########## users born before 1900 ##########");
    runAQuery();

    // retrieve all users
    System.out.println("########## All users ##########");
    retrieveAllDocuments();
    System.out.println("###################################");
  }

  /**
   * A quick start application to get started with Firestore.
   *
   * @param args firestore-project-id (optional)
   */
  public static void main(String[] args) throws Exception {
    // default project is will be used if project-id argument is not available
    //String projectId = (args.length == 0) ? null : args[0];
    String projectId = "suspecttracker-f43b5";
    QuickStart quickStart = (projectId != null) ? new QuickStart(projectId) : new QuickStart();
    quickStart.run();
  }
}
