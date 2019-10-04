package com.example.anta_proyect;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    ArrayList<Products> ProductList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setNestedScrollingEnabled(false);
        Button b_escaner = findViewById(R.id.button);
        b_escaner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Scaner();
            }
        });
        ProductList = SearchProducts("0","");
        ShowFilterResult(ProductList);
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        Button AddProduct = findViewById(R.id.button2);
        AddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), activity_insert.class);
                startActivity(intent);
            }
        });
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        EditText editText = (EditText) findViewById(R.id.editText);
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_SEND){
                    //Toast.makeText(MainActivity.this, v.getText(), Toast.LENGTH_SHORT).show();
                    ProductList = SearchProducts("0",String.valueOf(v.getText()));
                    ShowFilterResult(ProductList);
                    //Toast.makeText(MainActivity.this, v.getText(), Toast.LENGTH_SHORT).show();
                    return true;
                }
                return false;
            }
        });


    }
    public void ShowFilterResult(ArrayList<Products> ProductList) {
        RecyclerView rv = findViewById(R.id.recycler_view);
        rv.setNestedScrollingEnabled(false);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new Adapter(ProductList));
        //Toast.makeText(this, String.valueOf(ProductList.size()), Toast.LENGTH_SHORT).show();
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

    ArrayList<Products> SearchProducts(String Limit, String Filter) {
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
        Log.e("test", "test");
        if (cursor.moveToFirst()) {
            ProductList.clear();
            while (cursor.moveToNext()) {
                Products products = new Products(cursor.getString(1), cursor.getString(2)
                        , cursor.getString(3), cursor.getString(4), cursor.getString(5),
                        cursor.getString(6), cursor.getString(7), cursor.getString(8));
                ProductList.add(products);
                Log.e("test", Filter+"test2");
                Toast.makeText(this, cursor.getString(1), Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "No existe ningún producto con los datos ingresados",
                    Toast.LENGTH_SHORT).show();
            Log.e("test", Filter+"test3");
        }
        bd.close();
        Log.e("test", "test4");
        return ProductList;
    }
}
