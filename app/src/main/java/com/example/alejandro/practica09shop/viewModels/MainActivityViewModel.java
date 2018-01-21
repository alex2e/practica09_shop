package com.example.alejandro.practica09shop.viewModels;

import android.arch.lifecycle.ViewModel;

import com.example.alejandro.practica09shop.modelos.Producto;

import java.util.ArrayList;

public class MainActivityViewModel extends ViewModel {
    private ArrayList<Producto> productos;
    private ArrayList<Producto> carrito;

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public ArrayList<Producto> getCarrito() {

        //Creamos la base de datos del carrito para evitar que nos de null pointer
        if(carrito == null){
           carrito = new ArrayList<Producto>();
        }

        return carrito;
    }

    public void setCarrito(ArrayList<Producto> carrito) {
        this.carrito = carrito;
    }
}
