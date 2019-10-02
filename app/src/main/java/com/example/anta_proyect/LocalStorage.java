package com.example.anta_proyect;

import android.content.Context;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class LocalStorage {
    Inventory inventory;
    public void Save (Context context){
        try {
            FileOutputStream outputStream = context.getApplicationContext().openFileOutput("Filename", Context.MODE_PRIVATE);
            outputStream.write("gaaaaaaaaaaa".getBytes());
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Inventory Load(Context context){
        try {
            FileInputStream fileInputStream = context.openFileInput("Filename");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer = new StringBuffer();
            String lines;
            while ((lines = bufferedReader.readLine()) != null) {
                stringBuffer.append(lines + "\n");
            }
            inventory = ParseLoadData(stringBuffer.toString());

            //myText.setText(stringBuffer.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inventory;
    }

    private Inventory ParseLoadData(String text) {
        return inventory;
    }
}
