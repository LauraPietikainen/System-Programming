package com.example.laurap.lab3_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements NetworkLoaderThread.ResultInterface {

    private TextView resultView;
    private EditText et_Url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultView = (TextView) findViewById(R.id.tv_results);
        et_Url = (EditText) findViewById(R.id.et_Url);

    }

    @Override
    public void threadProgress(final String data) {

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                resultView.setText(data);
            }
        });

    }

    public void sendUrl(View view) {
        String Url = et_Url.getText().toString();
        NetworkLoaderThread networkLoaderThread = new NetworkLoaderThread(Url);
        networkLoaderThread.listener = this;
        networkLoaderThread.start();

    }
}

