package com.hemantdave.booklisting;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

public class details extends AppCompatActivity {

    String keyword;
    String result;
    private final String URL_PRESET = "https://www.googleapis.com/books/v1/volumes?q=";

    String ExtraQueryPart = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Intent intent = getIntent();
        if (intent.getStringExtra("limiter") != null) {
            ExtraQueryPart = "&maxResults=" + intent.getStringExtra("limiter");
        }

        keyword = intent.getStringExtra("Query");

        DetailsAsyncTask downloaddata = new DetailsAsyncTask();
        String finalURL = URL_PRESET + keyword + ExtraQueryPart;
        Log.i("URL", finalURL);
        try {
            result = downloaddata.execute(finalURL).get();
            if (result == "Error") {
                Toast.makeText(details.this, "Something went wrong !", Toast.LENGTH_SHORT).show();
                finish();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        ListView view = (ListView) findViewById(R.id.detailsListItem);
        view.setAdapter(new listViewCustomAdapter(result, this));

    }
}