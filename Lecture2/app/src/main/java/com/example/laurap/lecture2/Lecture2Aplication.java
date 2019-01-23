package com.example.laurap.lecture2;

import android.app.Application;
import android.util.Log;

/*Manifestiin lisätään android:name=".Lecture2Aplication" jotta sen metodeita kutsutan sovelluksen
luonnin yhteydessä*/
public class Lecture2Aplication extends Application {

    //onCreate
    @Override
    public void onCreate() {
        super.onCreate();
        //Logi
        Log.d("Lecture2", "Application - On Create");
    }
    //onLowMemory
    @Override
    public void onLowMemory() {
        super.onLowMemory();
        //Logi
        Log.d("Lecture2", "Application - On Low Memory");
    }
}
