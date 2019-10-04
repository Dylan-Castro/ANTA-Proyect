package com.example.anta_proyect;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setNestedScrollingEnabled(false);
        ArrayList<Products> ProductList = new ArrayList<>();
        ProductList.add(new Products("Codigo", "Nombre",
                "Test", "Test", "Test", "Test", "Cantidad", "Test"));
        ProductList.add(new Products("Codigo", "Nombre",
                "Test", "Test", "Test", "Test", "Cantidad", "Test"));
        ProductList.add(new Products("Codigo", "Nombre",
                "Test", "Test", "Test", "Test", "Cantidad", "Test"));
        ProductList.add(new Products("Codigo", "Nombre",
                "Test", "Test", "Test", "Test", "Cantidad", "Test"));
        Adapter adapter = new Adapter(ProductList);
        recyclerView.setAdapter(adapter);


    }


}
