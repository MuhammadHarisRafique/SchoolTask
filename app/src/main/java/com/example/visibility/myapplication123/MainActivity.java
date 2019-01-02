package com.example.visibility.myapplication123;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.ServerAddress;
import com.mongodb.MongoCredential;
import com.mongodb.MongoClientOptions;
import com.mongodb.client.MongoDatabase;

import com.mongodb.client.MongoCollection;

import static com.mongodb.client.model.Filters.*;
import com.mongodb.client.model.CreateCollectionOptions;
import com.mongodb.client.model.ValidationOptions;


import org.bson.Document;

import java.net.URL;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    MongoClient mongoClient;
    MongoDatabase mongoDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.connect);
        btn.setOnClickListener(MainActivity.this);
      //  DownloadFilesTask task=new DownloadFilesTask();
       // task.execute();


         mongoClient = new MongoClient(new MongoClientURI("mongodb://192.168.88.193:27017"));
        mongoDatabase = mongoClient.getDatabase("SchoolManagement");



    }

     class DownloadFilesTask extends AsyncTask<Void, Void, Void> {


        @Override
        protected Void doInBackground(Void... voids) {
             mongoClient = new MongoClient(new MongoClientURI("mongodb://192.168.88.193:27017"));
             mongoDatabase = mongoClient.getDatabase("SchoolManagement");

            if (mongoDatabase != null){
                MongoCollection<Document> coll = mongoDatabase.getCollection("Userdata");
                coll.drop();
            }
            return null;
        }

    }



    @Override
    public void onClick(View view) {

        String name = "Loading";
        Toast.makeText(this,name,Toast.LENGTH_SHORT).show();
//        DownloadFilesTask task=new DownloadFilesTask();
//        task.execute();

        if (mongoDatabase != null){
            MongoCollection<Document> coll = mongoDatabase.getCollection("Userdata");
            coll.drop();
        }

    }
}
