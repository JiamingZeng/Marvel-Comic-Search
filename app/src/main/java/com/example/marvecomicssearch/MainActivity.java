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
        menu();
    }

    void menu() {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
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
                gsonResults.setCharacters(igot);
                String test = gsonResults.getCharactersList().get(1).getImageUrlL();
                System.out.println(test);
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

    void menuUUUUUUUU() {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
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
                gsonResults.setCharacters(igot);
                if (gsonResults.getCharactersList().size() == 10) {
                    String nameC1 = gsonResults.getCharactersList().get(0).getName();
                    String Image1 = gsonResults.getCharactersList().get(0).getImageUrlM();

                    String nameC2 = gsonResults.getCharactersList().get(1).getName();
                    String Image2 = gsonResults.getCharactersList().get(1).getImageUrlM();

                    String nameC3 = gsonResults.getCharactersList().get(2).getName();
                    String Image3 = gsonResults.getCharactersList().get(2).getImageUrlM();

                    String nameC4 = gsonResults.getCharactersList().get(3).getName();
                    String Image4 = gsonResults.getCharactersList().get(3).getImageUrlM();

                    String nameC5 = gsonResults.getCharactersList().get(4).getName();
                    String Image5 = gsonResults.getCharactersList().get(4).getImageUrlM();

                    String nameC6 = gsonResults.getCharactersList().get(5).getName();
                    String Image6 = gsonResults.getCharactersList().get(5).getImageUrlM();

                    String nameC7 = gsonResults.getCharactersList().get(6).getName();
                    String Image7 = gsonResults.getCharactersList().get(6).getImageUrlM();
                    
                    String nameC8 = gsonResults.getCharactersList().get(7).getName();
                    String Image8 = gsonResults.getCharactersList().get(7).getImageUrlM();

                    String nameC9 = gsonResults.getCharactersList().get(8).getName();
                    String Image9 = gsonResults.getCharactersList().get(8).getImageUrlM();

                    String nameC10 = gsonResults.getCharactersList().get(9).getName();
                    String Image10 = gsonResults.getCharactersList().get(9).getImageUrlM();
                }
                toSearch();
            }
        });
    }




}
