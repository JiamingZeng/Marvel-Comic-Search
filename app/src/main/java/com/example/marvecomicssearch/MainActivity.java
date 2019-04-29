package com.example.marvecomicssearch;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import com.squareup.picasso.Picasso;


import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        menu();
    }
    private List<MarvelCharacters> list;
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
                GsonResults gsonResults = new GsonResults();
                gsonResults.setCharacters(igot);
                List<MarvelCharacters> myList = gsonResults.getCharactersList();
                list = myList;
                toSearch(myList);
            }
        });
    }

    void toSearch(List<MarvelCharacters> myList) {
        setContentView(R.layout.result);
        ImageView back = findViewById(R.id.background2);
        back.setImageResource(R.drawable.resultbackground);
        for (int i = 1; i < myList.size() + 1; i++) {
            String text = "button" + i;
            Button button = findViewById(getResources().getIdentifier(text, "id", getPackageName()));
            button.setText(myList.get(i - 1).getName());
            final int finalI = i - 1;
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    toDetails(finalI);
                }
            });
            System.out.println(myList.get(i - 1).getImageUrlM());
            String imageText = "imageView" + i;
            ImageView imageView = findViewById(getResources().getIdentifier(imageText, "id", getPackageName()));
            imageView.setImageResource(R.drawable.background);
            Picasso.with(this).load(myList.get(i - 1).getImageUrlM())
                    .into(imageView);
        }

        Button searchButton = (Button) findViewById(R.id.backToMain);
        searchButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                menu();
            }
        });
    }

    void toDetails(int number) {
        setContentView(R.layout.details);
        TextView specificName = findViewById(R.id.specificName);
        specificName.setText(list.get(number).getName());
        TextView specificBackground = findViewById(R.id.specificBackground);
        specificBackground.setText(list.get(number).getBackground());
        ImageView back = findViewById(R.id.background3);
        back.setImageResource(R.drawable.background3);
        TextView comicsInformation = findViewById(R.id.infomation);
        comicsInformation.setText(GsonResults.ComicSeriesGenerator(list.get(number).getComics()));
        ImageView setBigImage = findViewById(R.id.pic);
        Picasso.with(this).load(list.get(number).getImageUrlL()).resize(380,380)
                .into(setBigImage);
        Button pre = (Button) findViewById(R.id.previous);

        pre.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                menu();
            }
        });

    }


}
