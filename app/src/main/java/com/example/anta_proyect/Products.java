package com.example.anta_proyect;

import android.content.ContentValues;

public class Products {

    private String Codigo;
    private String Nombre;
    private String Marca;
    private String Categoria;
    private String Costo;
    private String PrecioVenta;
    private String Cantidad;
    private String CantidadAlerta;


    public Products(String codigo, String nombre, String marca, String categoria, String costo, String precioVenta, String cantidad, String cantidadAlerta) {
        Codigo = codigo;
        Nombre = nombre;
        Marca = marca;
        Categoria = categoria;
        Costo = costo;
        PrecioVenta = precioVenta;
        Cantidad = cantidad;
        CantidadAlerta = cantidadAlerta;

    }
    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String codigo) {
        Codigo = codigo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String marca) {
        Marca = marca;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }

    public String getCosto() {
        return Costo;
    }

    public void setCosto(String costo) {
        Costo = costo;
    }

    public String getPrecioVenta() {
        return PrecioVenta;
    }

    public void setPrecioVenta(String precioVenta) {
        PrecioVenta = precioVenta;
    }

    public String getCantidad() {
        return Cantidad;
    }

    public void setCantidad(String cantidad) {
        Cantidad = cantidad;
    }

    public String getCantidadAlerta() {
        return CantidadAlerta;
    }

    public void setCantidadAlerta(String cantidadAlerta) {
        CantidadAlerta = cantidadAlerta;
    }
    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(DataBase.ProductsEntry.Codigo, Codigo);
        values.put(DataBase.ProductsEntry.Nombre, Nombre);
        values.put(DataBase.ProductsEntry.Marca, Marca);
        values.put(DataBase.ProductsEntry.Categoria, Categoria);
        values.put(DataBase.ProductsEntry.Costo, Costo);
        values.put(DataBase.ProductsEntry.PrecioVenta, PrecioVenta);
        values.put(DataBase.ProductsEntry.Cantidad, Cantidad);
        values.put(DataBase.ProductsEntry.CantidadAlerta, CantidadAlerta);
        return values;
    }
}