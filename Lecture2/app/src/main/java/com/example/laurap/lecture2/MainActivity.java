package com.example.laurap.lecture2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //onCreate elinkaari metodi suoritetaan kun MainActivity luodaan
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista);
        //Logi näkyy kun ohjelma avautuu
        Log.d("Lecture2", "onCreate call");

        findViewById(R.id.printTimeButton).setOnClickListener(this);
        findViewById(R.id.loadButton).setOnClickListener(this);
    }
    //onStop elinkaari metodi kutsutaan kun activity pysähtyy
    @Override
    protected void onStop() {
        super.onStop();
        //Logi näkyy kun ohjelmaa menee taustalle
        Log.d("Lecture2", "onStop call");
    }
    //onResume elinkaari metodi kutsutaan kun activity on ollut taustalla ja tulee takaisin esiin
    @Override
    protected void onResume() {
        super.onResume();
        //Logi näkyy kun ohjelma avautuu ja kun palataan ohjelmaan
        Log.d("Lecture2", "onResume call");
    }
    //onDestroy elinkaari metodi kutsutaan kun activity häviää muistista eli tuhotaan kokonaan
    @Override
    protected void onDestroy() {
        super.onDestroy();
        //Logi kun taustalle mennyt ohjelma tuhotaan järjestelmän kautta
        Log.d("Lecture2", "onDestroy call");
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.loadButton){
            //Load buttonista käynnistyy ikiluuppi, eli onClick ei palaa
            while (true) {

            }
        }
        //Print time ottaa ajan ja tulostaa tekstitenttään
        else if (view.getId() == R.id.printTimeButton){
            Date time = new Date();

            TextView textView = findViewById(R.id.textView);
            textView.setText(time.toString());
        }
    }
}
