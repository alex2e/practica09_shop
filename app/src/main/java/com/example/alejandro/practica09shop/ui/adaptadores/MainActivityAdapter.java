package com.example.alejandro.practica09shop.ui.adaptadores;

import android.content.Context;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.alejandro.practica09shop.modelos.Producto;
import com.example.alejandro.practica09shop.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Alejandro on 21/01/2018.
 */

public class MainActivityAdapter extends PagerAdapter{
    private final LayoutInflater layoutInflater;
    private final ArrayList<Producto> productos;
    private final Context context;


    // Constructor
    public MainActivityAdapter(Context context, ArrayList<Producto> productos) {
        layoutInflater = LayoutInflater.from(context);
        this.productos = productos;
        this.context = context;
    }

    // Craar las vistas que serán las páginas
    @Override
    public Object instantiateItem(ViewGroup collection, int position) {
        View view = layoutInflater.inflate(R.layout.product_layout, collection, false);
        setupPage(view, position);
        collection.addView(view, 0);
        return view;
    }

    private void setupPage(View view, int position) {
        TextView txtNombre = view.findViewById(R.id.txtNombre);
        TextView txtFabricante = view.findViewById(R.id.txtfabricante);
        TextView txtPrecio = view.findViewById(R.id.txtPrecio);
        ImageView imgProducto = view.findViewById(R.id.imgProducto);
        RatingBar ratingBar = view.findViewById(R.id.ratingBar);
        Producto productoPintar = productos.get(position);

        //Ahora que ya tenemos las vistas identificadas y el producto los ponemos en su sitio.
        txtNombre.setText(productoPintar.getNombre());
        txtFabricante.setText(productoPintar.getFabricante());
        txtPrecio.setText(String.valueOf(productoPintar.getPrecio()));
        //Para recoger la imagen y el rating
        Picasso.with(context).load(productoPintar.getImageUrl()).into(imgProducto);
        ratingBar.setRating(productoPintar.getRating());

        //Listener para que si el usuario le cambia la puntuación se quede guardada
        ratingBar.setOnRatingBarChangeListener((ratingBar1, rating, fromUser) -> productoPintar.setRating(rating));
    }

    public Producto getItem(int posicion){
        return productos.get(posicion);
    }

    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        collection.removeView((View) view);
    }

    //Ni idea son lentejas
    @Override
    public Parcelable saveState() {
        return null;
    }

    //Debe devolver el número de elementos que hay
    @Override
    public int getCount() {
        return productos.size();
    }

    // No se por que
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == object);
    }
}
