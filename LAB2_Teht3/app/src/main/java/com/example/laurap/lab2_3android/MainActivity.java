package com.example.laurap.lab2_3android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Observable;
import java.util.Observer;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private String text = "";
    private Button btnStart;
    private Button btnStop;
    private TextView tv;
    private ThreadActivity actThread;
    private Thread thread;
    private boolean stopThread;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView)findViewById(R.id.tv_text);
        tv.setMovementMethod(new ScrollingMovementMethod());
        btnStart = (Button)findViewById(R.id.btn_start);
        btnStop = (Button)findViewById(R.id.btn_stop);
        btnStart.setOnClickListener(this);
        btnStop.setOnClickListener(this);
        stopThread = false;
        actThread = new ThreadActivity();
        thread = new Thread(actThread);
    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.btn_start && !thread.isAlive()) {
            if(stopThread){
                actThread = new ThreadActivity();
                thread = new Thread(actThread);
            }

            // addObserver and start a thread

            actThread.addObserver(new Observer() {
                @Override
                public void update(Observable o, Object arg) {
                    text = text + (arg) + "\n";
                    runOnUiThread(new Runnable() {

                        @Override
                        public void run() {
                            tv.setText(text);

                        }
                    });

                }
            });

            thread.start();
            text = text + "Thread Started" + "\n";
        }
        else if(v.getId() == R.id.btn_stop && thread.isAlive()){
            //interrupt thread
            thread.interrupt();
            stopThread = true;
            text = text + "Thread Stopped \n";
            tv.setText(text);
        }

    }
}