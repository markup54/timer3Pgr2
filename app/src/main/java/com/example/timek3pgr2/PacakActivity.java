package com.example.timek3pgr2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PacakActivity extends AppCompatActivity {

    private ArrayList<ImageView> obrazki = new ArrayList<>();
    private int sekundy =10 ;
    private int punkty =0;
    private TextView czasTextView;
    private TextView punktyTekstView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pacak);
        czasTextView = findViewById(R.id.czasTextView);
        punktyTekstView = findViewById(R.id.punktyTextView);
        obrazki.add(findViewById(R.id.imageView));
        obrazki.add(findViewById(R.id.imageView2));
        obrazki.add(findViewById(R.id.imageView3));
        obrazki.add(findViewById(R.id.imageView4));
        pokazWylosowanyObraz();
        zlicz();
    }

    private void zlicz(){
        final Handler handler =new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                sekundy--;
                pokazWylosowanyObraz();
                czasTextView.setText("Czas: "+String.valueOf(sekundy));
                handler.postDelayed(this,1000);
            }

        });
    }
    private  void pokazWylosowanyObraz(){
        for(ImageView obrazek:obrazki){
            obrazek.setVisibility(View.INVISIBLE);
        }
        int indeks = (int)(Math.random()*obrazki.size());
        obrazki.get(indeks).setVisibility(View.VISIBLE);
        obrazki.get(indeks).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        punkty++;
                        punktyTekstView.setText("Punkty "+Integer.toString(punkty));
                        pokazWylosowanyObraz();
                    }
                }
        );
    }
}