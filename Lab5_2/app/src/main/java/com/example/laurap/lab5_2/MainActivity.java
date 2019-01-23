package com.example.laurap.lab5_2;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//Tiedosto tallentuu Android applikaatiosta puhelimen muistiin
//Settings  -> Tallennustila -> Tiedostot

public class MainActivity extends AppCompatActivity {

    EditText et_filename, et_filecontent;
    Button button_save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Riippuen android versiosta edellyttää lupaa kirjoittaa laitteen muistiin
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
        != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);
        }

        et_filename = (EditText) findViewById(R.id.et_name);
        et_filecontent = (EditText) findViewById(R.id.et_content);
        button_save = (Button)findViewById(R.id.b_save);

        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String filename = et_filename.getText().toString();
                String content = et_filecontent.getText().toString();

                if(!filename.equals("") && !content.equals("")) {
                    saveTextAsFile(filename, content);
                }
            }
        });
    }
//Tallentaa tekstitiedoston
    private void saveTextAsFile(String filename, String content){
        String fileName = filename + ".txt";

        //luo tiedoston
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), fileName);

        try {
            //kirjoitaa tiedostoon
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(content.getBytes());
            fos.close();
            Toast.makeText(this, "Tallennettu!", Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(this, "Tiedostoa ei löydy!", Toast.LENGTH_SHORT).show();
        }catch (IOException e){
            e.printStackTrace();
            Toast.makeText(this, "Tallennus epäonnistui!", Toast.LENGTH_SHORT).show();
        }

    }
//Riippuen onko permissio hyväksytty vai ei, tekee jomman kumman toastin.
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 1000:
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this, "Permission granted!", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(this, "Permission not granted", Toast.LENGTH_SHORT).show();
                    finish();
                }
        }
    }
}
