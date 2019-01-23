package com.example.systemprogramming.lecture4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener, BackupNotifier{

    ArrayList<Person> allPersons = new ArrayList<>();
    BackupTimer backupTimer = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.addButton).setOnClickListener(this);

        backupTimer = new BackupTimer();
        backupTimer.setNotifier(this);
        backupTimer.start();

        Person rector = new Person();
        rector.setFirstName("Jouko");
        rector.setLastName("Paaso");

        allPersons.add(rector);

        Student seppo = new Student();
        seppo.setFirstName("Seppo");
        seppo.setLastName("Taalasmaa");
        seppo.setStudentNumber(allPersons.size());

        allPersons.add(seppo);
        printAllPersons();
    }

    @Override
    protected void onStop() {
        super.onStop();
        backupTimer.interrupt();
    }

    protected void printAllPersons() {
        TextView textView = findViewById(R.id.personTextView);
        textView.append("**** PRINTING ALL PERSONS ****");

        for (Person person : allPersons) {
            textView.append(person.toString() + "\n");
        }
    }

    protected void printAllPersonsToLog() {
        Log.d("LECTURE4", "**** PRINTING ALL PERSONS ****\n");
        for (Person person : allPersons) {
            Log.d("LUENTO4", person.toString());
        }
        Log.d("LECTURE4", "**** PRINTING ALL PERSONS DONE ****");
    }

    @Override
    public void onClick(View view) {
        EditText editor = findViewById(R.id.personEditText);
        String name = editor.getText().toString();

        Student newStudent = new Student();
        newStudent.setFirstName(name);
        newStudent.setStudentNumber(allPersons.size());
        allPersons.add(newStudent);

        printAllPersons();
    }

    @Override
    public void backupNow() {
        MainActivity.this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                TextView textView = findViewById(R.id.personTextView);
                textView.append("Backup now!");
            }
        });
    }
}
