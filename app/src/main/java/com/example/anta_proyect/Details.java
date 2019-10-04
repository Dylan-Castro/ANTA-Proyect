package com.example.anta_proyect;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalle_layout);
/*
        Bundle extras = getIntent().getExtras();
        if (extras != null){
            String  codigo = extras.getString("ProductCodigo");
            String  nombre = extras.getString("ProductNombre");
            String  marca = extras.getString("ProductMarca");
            String  categoria = extras.getString("ProductCategoria");
            String  costo = extras.getString("ProductCosto");
            String  precio = extras.getString("ProductPrecio");
            String  cantidad = extras.getString("ProductCantidad");
            String  cantidadAlerta = extras.getString("ProductCantidadAlerta");
            Products products = new Products(codigo, nombre, marca, categoria, costo, precio, cantidad, cantidadAlerta);

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

        }*/
    }

}
