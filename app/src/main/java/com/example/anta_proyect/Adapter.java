package com.example.anta_proyect;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.Viewholder> {

    private ArrayList<Products> productsList;
    private Context context;

    public Adapter(ArrayList<Products> productsList) {
        this.productsList = productsList;
    }


    @NonNull
    @Override
    public Adapter.Viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_layout,viewGroup,false);
        context = viewGroup.getContext();
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder viewholder, final int position) {
        viewholder.Nombre.setText(productsList.get(position).getNombre());
        viewholder.Cantidad.setText(productsList.get(position).getCantidad());
        viewholder.Codigo.setText(productsList.get(position).getCodigo());
        viewholder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(v.getContext(), Details.class);
               /* intent.putExtra("ProductCodigo", productsList.get(position).getCodigo());
                intent.putExtra("ProductNombre", productsList.get(position).getNombre());
                intent.putExtra("ProductMarca", productsList.get(position).getMarca());
                intent.putExtra("ProductCategoria", productsList.get(position).getCategoria());
                intent.putExtra("ProductCosto", productsList.get(position).getCosto());
                intent.putExtra("ProductPrecioVenta", productsList.get(position).getPrecioVenta());
                intent.putExtra("ProductCantidad", productsList.get(position).getCantidad());
                intent.putExtra("ProductCantidadAlerta", productsList.get(position).getCantidadAlerta());*/

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return productsList.size();
    }

    static class Viewholder extends RecyclerView.ViewHolder {

        private TextView Nombre;
        private TextView Cantidad;
        private TextView Codigo;


        public Viewholder(@NonNull View itemView) {
            super(itemView);
            Nombre = itemView.findViewById(R.id.Nombre);
            Cantidad = itemView.findViewById(R.id.Cantidad);
            Codigo = itemView.findViewById(R.id.Codigo);
        }
    }


}
