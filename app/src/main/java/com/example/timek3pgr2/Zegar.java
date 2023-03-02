package com.example.timek3pgr2;

import android.os.CountDownTimer;
import android.widget.TextView;

public class Zegar {
    private boolean running;
    private int sekundy = 180;
    private TextView timeTextView;
    private CountDownTimer timer;

    public Zegar(boolean running, TextView timeTextView) {
        this.running = running;
        this.timeTextView = timeTextView;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
    private void pokazIleZostalo(int s){
        int minuty = s/60;
        int sek = s%60;
        timeTextView.setText(String.format("%02d : %02d",minuty,sek));
    }
    public  void startTimer(){
        timer = new CountDownTimer(sekundy*1000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                sekundy =(int) millisUntilFinished/1000;
                pokazIleZostalo(sekundy);
            }

            @Override
            public void onFinish() {
                timeTextView.setText("KONIEC");
                //TODO wyłączyć guzik itp
            }
        };
        timer.start();
        running = true;
    }
    public void stopTimer(){
        timer.cancel();
        running = false;
    }
}
