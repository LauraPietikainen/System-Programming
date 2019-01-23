package com.example.systemprogramming.lecture4;

public class BackupTimer extends Thread {

    private BackupNotifier notifier;

    public void setNotifier(BackupNotifier notifier) {
        this.notifier = notifier;
    }

    public void run() {
        try {
            while (true) {
                sleep(5000);
                if (notifier != null) {
                    notifier.backupNow();
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
