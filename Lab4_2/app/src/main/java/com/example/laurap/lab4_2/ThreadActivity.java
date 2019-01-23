package com.example.laurap.lab4_2;

import android.util.Log;

public class ThreadActivity extends Thread {

    private int progressCounter = 0;
    private int progress = 0;
    private int threadId = 0;
    protected Interface notifier = null;

    public ThreadActivity(int identifier){
        this.threadId = identifier;
    }

    public void setNotifier(Interface notifier) {
        this.notifier = notifier;
    }

    public void run(){
        while(progressCounter < 10){
            try{
                sleep(3000);
                progress = progress + 10;
                if(notifier != null){
                    notifier.printProgress(progress, threadId);
                }
                progressCounter++;
            }
            catch (Exception e) {
                //System.out.println("Interrupted");
                return;
            }
        }
    }

}
