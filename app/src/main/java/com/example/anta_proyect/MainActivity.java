package com.example.anta_proyect;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ArrayList<Products> Inventory = new ArrayList<>();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button b_save = findViewById(R.id.button);
        Button b_load = findViewById(R.id.button2);
        Button b_escaner = findViewById(R.id.button3);

        b_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddProduct();
            }
        });
        b_load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchProducts("0", "");
            }
        });
        b_escaner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Scaner();
            }
        });

    }
    void Scaner(){
        IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.setPrompt("Scan a barcode");
        integrator.initiateScan();
    }
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        if (scanningResult != null) {
            String scanContent = scanningResult.getContents();
            Toast.makeText(this, scanContent, Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(this, "No scan data received!", Toast.LENGTH_SHORT).show();
        }
    }
    void AddProduct() {
        DataBase admin = new DataBase(this);
        SQLiteDatabase bd = admin.getWritableDatabase();
        Products product = new Products("Luis", "Test", "Test"
                , "Test", "Test", "Test", "Test", "Test");
        Products product2 = new Products("Dylan", "Test", "Test"
                , "Test", "Test", "Test", "Test", "Test");
        bd.insert("Inventario", null, product.toContentValues());
        bd.insert("Inventario", null, product2.toContentValues());
        bd.close();
        Toast.makeText(this, "Saved",

                Toast.LENGTH_SHORT).show();
    }

    void SearchProducts(String Limit, String Filter) {
        DataBase admin = new DataBase(this);
        SQLiteDatabase bd = admin.getWritableDatabase();
        Cursor cursor = null;
        if (Limit.contentEquals("0")) {
            if (Filter.isEmpty()) {
                cursor = bd.rawQuery(
                        "select * from Inventario", null);
            } else {
                cursor = bd.rawQuery(
                        "select * from Inventario where Codigo='" + Filter + "' or  Nombre='" +
                                Filter + "' or  Marca='" + Filter + "' or  Categoria='" +
                                Filter + "' or  PrecioVenta='" + Filter + "' or  Cantidad='" + Filter + "'", null);
            }
        } else {
            if (Filter.isEmpty()) {
                cursor = bd.rawQuery(
                        "select * from Inventario LIMIT " + Limit, null);
            } else {
                cursor = bd.rawQuery(
                        "select * from Inventario where Codigo='" + Filter + "' or  Nombre='" +
                                Filter + "' or  Marca='" + Filter + "' or  Categoria='" +
                                Filter + "' or  PrecioVenta='" + Filter + "' or  Cantidad='" + Filter + "' LIMIT " + Limit, null);
            }
        }

        if (cursor.moveToFirst()) {
            while (cursor.moveToNext()) {
                Products products = new Products(cursor.getString(1), cursor.getString(2)
                        , cursor.getString(3), cursor.getString(4), cursor.getString(5),
                        cursor.getString(6), cursor.getString(7), cursor.getString(8));
                Log.e("codigo", products.getCodigo());
                //Toast.makeText(this, cursor.getString(1), Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "No existe ningún usuario con ese dni",
                    Toast.LENGTH_SHORT).show();
            bd.close();
        }

    }

    void DeleteProducts(String Codigo) {

        DataBase admin = new DataBase(this);
        SQLiteDatabase bd = admin.getWritableDatabase();
        bd.delete("Inventario", "Codigo=" + Codigo, null);
        bd.close();
        Toast.makeText(this, "Producto eliminado con éxito",Toast.LENGTH_SHORT).show();
    }
    void UpdateProduct(Products products){
        DataBase admin = new DataBase(this);
        SQLiteDatabase bd = admin.getWritableDatabase();
        bd.update("Inventario",products.toContentValues(), "Codigo=" + products.getCodigo(), null);
        bd.close();
        Toast.makeText(this, "Producto Modificado con éxito",Toast.LENGTH_SHORT).show();
    }

}