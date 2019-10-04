package com.example.anta_proyect;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class activity_insert extends AppCompatActivity {
    EditText nombre;
    EditText codigo;
    EditText marca;
    EditText categoria;
    EditText costo;
    EditText precio;
    EditText cantidad;
    EditText cantidadAlerta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        nombre = findViewById(R.id.nombre);
        codigo = findViewById(R.id.codigo);
        marca = findViewById(R.id.marca);
        categoria = findViewById(R.id.categoria);
        costo = findViewById(R.id.costo);
        precio = findViewById(R.id.precio);
        cantidad = findViewById(R.id.cantidad);
        cantidadAlerta = findViewById(R.id.cantidadAlerta);

        Button b_guardar = findViewById(R.id.guardar);
        b_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataBase admin = new DataBase(v.getContext());
                SQLiteDatabase bd = admin.getWritableDatabase();
                Products product = new Products(String.valueOf(codigo.getText()), String.valueOf(nombre.getText()),
                        String.valueOf(marca.getText()), String.valueOf(categoria.getText()), String.valueOf(costo.getText()),
                        String.valueOf(precio.getText()), String.valueOf(cantidad.getText()), String.valueOf(cantidadAlerta.getText()));
                bd.insert("Inventario", null, product.toContentValues());
                bd.close();
                Toast.makeText(v.getContext(), "Saved", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
