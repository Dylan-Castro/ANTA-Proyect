package com.example.anta_proyect;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Details extends AppCompatActivity {
    Products products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalle_layout);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String codigo = extras.getString("ProductCodigo");
            String nombre = extras.getString("ProductNombre");
            String marca = extras.getString("ProductMarca");
            String categoria = extras.getString("ProductCategoria");
            String costo = extras.getString("ProductCosto");
            String precio = extras.getString("ProductPrecioVenta");
            String cantidad = extras.getString("ProductCantidad");
            String cantidadAlerta = extras.getString("ProductCantidadAlerta");
            products = new Products(codigo, nombre, marca, categoria, costo, precio, cantidad, cantidadAlerta);

            TextView Tcodigo = findViewById(R.id.codigo);
            Tcodigo.setText(products.getCodigo());

            TextView Tnombre = findViewById(R.id.nombreProducto);
            Tnombre.setText(products.getNombre());

            TextView Tmarca = findViewById(R.id.marca);
            Tmarca.setText(products.getMarca());

            TextView Tcategoria = findViewById(R.id.categoria);
            Tcategoria.setText(products.getCategoria());

            TextView Tcosto = findViewById(R.id.costo);
            Tcosto.setText(products.getCosto());

            TextView Tprecio = findViewById(R.id.precio);
            Tprecio.setText(products.getPrecioVenta());

            TextView Tcantidad = findViewById(R.id.cantidad);
            Tcantidad.setText(products.getCantidad());

            TextView TcantidadAlerta = findViewById(R.id.cantidadAlerta);
            TcantidadAlerta.setText(products.getCantidadAlerta());

        }

        Button b_eliminar = findViewById(R.id.eliminar);
        b_eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataBase admin = new DataBase(v.getContext());
                SQLiteDatabase bd = admin.getWritableDatabase();
                bd.delete("Inventario", "Codigo='" + products.getCodigo() + "'", null);
                bd.close();
                Toast.makeText(v.getContext(), "Producto eliminado con éxito", Toast.LENGTH_SHORT).show();
            }
        });
    }

    void UpdateProduct(Products products) {
        DataBase admin = new DataBase(this);
        SQLiteDatabase bd = admin.getWritableDatabase();
        bd.update("Inventario", products.toContentValues(), "Codigo=" + products.getCodigo(), null);
        bd.close();
        Toast.makeText(this, "Producto Modificado con éxito", Toast.LENGTH_SHORT).show();
    }
}
