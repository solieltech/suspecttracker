package com.example.suspectservice.firebase.config;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.

public class FirebaseConfig {
	
	
	public static void main(String[] args) throws Exception{
		FirebaseConfig fc =new FirebaseConfig();
		fc.firebaseInit();
	}

	public void firebaseInit() throws Exception{
	FileInputStream serviceAccount =
			  new FileInputStream("D:\\Kiran_work\\Suspect-Tracker\\suspecttracker-f43b5-firebase-adminsdk-yf2dt-14d05d3e32.json");

			FirebaseOptions options = new FirebaseOptions.Builder()
			  .setCredentials(GoogleCredentials.fromStream(serviceAccount))
			  .setDatabaseUrl("https://suspecttracker-f43b5.firebaseio.com")
			  .build();

			FirebaseApp.initializeApp(options);
		
			
			
			final FirebaseDatabase database = FirebaseDatabase.getInstance();
			DatabaseReference ref = database.getReference();
			
			
			

				/*DatabaseReference usersRef = ref.getRoot();

				Map<String, User> users = new HashMap<>();
				users.put("alanisawesome", new User("June 23, 1912", "Alan Turing"));
				users.put("gracehop", new User("December 9, 1906", "Grace Hopper"));

				usersRef.setValueAsync(users);
				usersRef.push();*/
			
			//Firestore store - new FirebaseConfig();
			
			
			// Create a Map to store the data we want to set
			Map<String, Object> docData = new HashMap<>();
			docData.put("name", "Los Angeles");
			docData.put("state", "CA");
			docData.put("country", "USA");
			docData.put("regions", Arrays.asList("west_coast", "socal"));
			// Add a new document (asynchronously) in collection "cities" with id "LA"
			//ApiFuture<WriteResult> future = database.collection("cities").document("LA").set(docData);
			// ...
			// future.get() blocks on response
			//System.out.println("Update time : " + future.get().getUpdateTime());
			
	}
	
}

class User {

	  public String date_of_birth;
	  public String full_name;
	  public String nickname;

	  public User(String dateOfBirth, String fullName) {
	    // ...
	  }

	  public User(String dateOfBirth, String fullName, String nickname) {
	    // ...
	  }

	}
