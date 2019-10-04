package com.example.anta_proyect;

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


    public Adapter(ArrayList<Products> productsList) {
        this.productsList = productsList;
    }


    @NonNull
    @Override
    public Adapter.Viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_layout,viewGroup,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder viewholder, int position) {
        viewholder.Nombre.setText(productsList.get(position).getNombre());
        viewholder.Cantidad.setText(productsList.get(position).getCantidad());
        viewholder.Codigo.setText(productsList.get(position).getCodigo());
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
