package com.example.marvecomicssearch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        menu();
    }

    void menu() {
        setContentView(R.layout.activity_main);
        ImageView back = findViewById(R.id.background);
        back.setImageResource(R.drawable.background);
        final GetResponse getRes = new GetResponse();

        /** make the search button */
        Button searchButton = (Button) findViewById(R.id.search);
        searchButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                EditText input = findViewById(R.id.toSearch);
                String igot = getRes.getResponse(input.getText().toString());
                System.out.println(igot);
                GsonResults gsonResults = new GsonResults();
                toSearch();
            }
        });
    }

    void toSearch() {
        setContentView(R.layout.result);
        ImageView back = findViewById(R.id.background2);
        back.setImageResource(R.drawable.resultbackground);
        Button searchButton = (Button) findViewById(R.id.backToMain);
        searchButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                menu();
            }
        });
    }

    void toInfo() {
        setContentView(R.layout.details);
        ImageView back = findViewById(R.id.background3);
        back.setImageResource(R.drawable.background3);
    }

}
