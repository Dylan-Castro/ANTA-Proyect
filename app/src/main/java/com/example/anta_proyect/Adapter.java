package com.example.anta_proyect;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.Viewholder> {

    private List<Products> productsList;


    public Adapter(List<Products> productsList) {
        this.productsList = productsList;
    }


    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_layout,viewGroup,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder viewholder, int position) {
        String name = productsList.get(position).getNombre();
        String code = productsList.get(position).getCodigo();
        String cant = productsList.get(position).getCantidad();
        viewholder.setData(name,code,cant);
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


        }

        private void setData(String titleText, String codeText, String cantidadText) {
            Nombre.setText(titleText);
            Cantidad.setText(codeText);
            Codigo.setText(cantidadText);
        }
    }


}
