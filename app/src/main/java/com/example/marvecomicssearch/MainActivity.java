package com.example.marvecomicssearch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        menu();
    }
    void menu() {
        setContentView(R.layout.activity_main);
        ImageView back = findViewById(R.id.background);
        back.setImageResource(R.drawable.background);

        /** make the search button */
        Button searchButton = (Button) findViewById(R.id.search);
        searchButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                toSearch();
            }
        });
    }
    void toSearch() {
        setContentView(R.layout.result);
        Button searchButton = (Button) findViewById(R.id.backToMain);
        searchButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                menu();
            }
        });
    }
}
