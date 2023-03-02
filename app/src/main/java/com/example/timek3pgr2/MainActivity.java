package com.example.timek3pgr2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int sekundy = 0;
    boolean running = true;
    Button button;
    TextView textView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textViewTimerUp);
        button = findViewById(R.id.button);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                if(running) {
                    sekundy++;
                    textView.setText(Integer.toString(sekundy));
                }
               handler.postDelayed(this,1000);

            }
        });
        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(running){
                            running = false;
                            button.setText("Dalej");
                        }
                        else{
                            running = true;
                            button.setText("Pauza");
                        }
                    }
                }
        );
    }


}