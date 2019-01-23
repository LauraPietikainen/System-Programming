package com.example.laurap.lab4_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Interface {

    private TextView tv;
    private ArrayList<ThreadActivity> threads;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tv_text);
        threads = new ArrayList<ThreadActivity>();
        Button button = findViewById(R.id.btn_start);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        ThreadActivity thread = new ThreadActivity(threads.size() + 1);
        threads.add(thread);
        thread.notifier = this;
        thread.start();
    }
//Progress and Thread Id
    @Override
    public void printProgress(final int progress, final int threadCounter) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tv.append("Thread Id: " + threadCounter + " Progress: " + progress + "\n");
            }
        });

    }
}

