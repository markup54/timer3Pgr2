package com.example.timek3pgr2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ZegaSzachowyActivity extends AppCompatActivity {
Button button;
TextView textView1;
TextView textView2;
Zegar zegar1;
Zegar zegar2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zega_szachowy);
        textView1 = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
        zegar1 = new Zegar(true,textView1);
        zegar1.startTimer();
        zegar2 = new Zegar(false,textView2);
        button = findViewById(R.id.button2);
        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(zegar1.isRunning()){
                            zegar1.stopTimer();
                            zegar2.startTimer();
                            button.setText("GRACZ 2");
                        }
                        else{
                            zegar2.stopTimer();
                            zegar1.startTimer();
                            button.setText("GRACZ 1");
                        }
                    }
                }
        );
    }
}