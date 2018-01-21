package com.example.alejandro.practica09shop.modelos;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Alejandro on 21/01/2018.
 */

public class Producto implements Parcelable {
    private String nombre;
    private String fabricante;
    private float precio;
    private String imageUrl;
    private float rating;

    //Constructor
    public Producto(String nombre, String fabricante, float precio, String imageUrl, float rating) {
        this.nombre = nombre;
        this.fabricante = fabricante;
        this.precio = precio;
        this.imageUrl = imageUrl;
        this.rating = rating;
    }

    // Getter y Setter
    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nombre);
        dest.writeString(this.fabricante);
        dest.writeFloat(this.precio);
        dest.writeString(this.imageUrl);
        dest.writeFloat(this.rating);
    }

    protected Producto(Parcel in) {
        this.nombre = in.readString();
        this.fabricante = in.readString();
        this.precio = in.readFloat();
        this.imageUrl = in.readString();
        this.rating = in.readFloat();
    }

    public static final Parcelable.Creator<Producto> CREATOR = new Parcelable.Creator<Producto>() {
        @Override
        public Producto createFromParcel(Parcel source) {
            return new Producto(source);
        }

        @Override
        public Producto[] newArray(int size) {
            return new Producto[size];
        }
    };
}


