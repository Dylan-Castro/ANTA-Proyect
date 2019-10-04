package com.example.anta_proyect;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public class DataBase extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Products.db";
    public DataBase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + ProductsEntry.TABLE_NAME + " ("
                + ProductsEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + ProductsEntry.Codigo + " TEXT NOT NULL,"
                + ProductsEntry.Nombre + " TEXT NOT NULL,"
                + ProductsEntry.Marca + " TEXT NOT NULL,"
                + ProductsEntry.Categoria + " TEXT NOT NULL,"
                + ProductsEntry.Costo + " TEXT NOT NULL,"
                + ProductsEntry.PrecioVenta + " TEXT,"
                + ProductsEntry.Cantidad + " TEXT,"
                + ProductsEntry.CantidadAlerta + " TEXT,"
                + "UNIQUE (" + ProductsEntry._ID + "))");
    }

    public static abstract class ProductsEntry implements BaseColumns {
        public static final String TABLE_NAME ="Inventario";
        public static final String Codigo = "Codigo";
        public static final String Nombre = "Nombre";
        public static final String Marca = "Marca";
        public static final String Categoria = "Categoria";
        public static final String Costo = "Costo";
        public static final String PrecioVenta = "PrecioVenta";
        public static final String Cantidad = "Cantidad";
        public static final String CantidadAlerta = "CantidadAlerta";
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}