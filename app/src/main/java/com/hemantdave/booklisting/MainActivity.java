package com.hemantdave.booklisting;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText query, limitQuery;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        query = (EditText) findViewById(R.id.keyWord);
        limitQuery = (EditText) findViewById(R.id.limitQuery);


    }

    public void searchQuery(View v) {
        if (query.getText() == null | (query.getText().toString().trim()).matches("")) {
            Toast.makeText(MainActivity.this, "Plz Enter the query", Toast.LENGTH_SHORT).show();

        } else {

            Intent i = new Intent(MainActivity.this, details.class);
            i.putExtra("Query", query.getText().toString());
            if ((limitQuery.getText().toString().trim()).matches("") | (limitQuery.getText().toString().trim()) == null) {
                i.putExtra("limiter", "5");

            } else {
                if (Integer.parseInt(limitQuery.getText().toString().trim()) > 0) {
                    Toast.makeText(MainActivity.this, "" + limitQuery.getText().toString().trim(), Toast.LENGTH_SHORT).show();
                    i.putExtra("Limiter", limitQuery.getText().toString().trim());
                }
            }

            startActivity(i);
        }
    }
}
