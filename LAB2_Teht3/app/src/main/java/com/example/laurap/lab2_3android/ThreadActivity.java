package com.example.laurap.lab2_3android;

import java.util.Observable;

import static java.lang.Thread.sleep;

public class ThreadActivity extends Observable implements Runnable {
    @Override
    public void run() {

        try {
            System.out.println("Thread started");
            while (true) {
                String response = "Tiisu, we want more!";
                setChanged();
                notifyObservers(response);
                sleep(5000);
            }
        }
        catch (Exception e) {
            String interuption = "Thread interrupted";
        }
    }
}


