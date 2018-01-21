package com.example.alejandro.practica09shop.ui.adaptadores;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alejandro.practica09shop.R;
import com.example.alejandro.practica09shop.modelos.Producto;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Alejandro on 21/01/2018.
 */

public class CarritoActivityAdapter extends RecyclerView.Adapter<CarritoActivityAdapter.ViewHolder> {
    private ArrayList<Producto> productosEnCarrito;

    public CarritoActivityAdapter(ArrayList<Producto> productosCarrito) {
        productosEnCarrito = productosCarrito;
    }


    @Override
    public CarritoActivityAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_carrito_item, parent, false);

        return new ViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Producto productoBindear = productosEnCarrito.get(position);
        //Ahora que ya tenemos las vistas identificadas y el producto los ponemos en su sitio.
        holder.txtNombreProducto.setText(productoBindear.getNombre());
        holder.txtCantidadProducto.setText("0");

        holder.btnIncrementar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        holder.btnDecrementar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        if(productosEnCarrito == null){
            return 0;
        }else{
            return productosEnCarrito.size();
        }
    }



    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtNombreProducto;
        TextView txtCantidadProducto;
        ImageView btnIncrementar;
        ImageView btnDecrementar;

        public ViewHolder(View itemView) {
            super(itemView);
           txtNombreProducto = itemView.findViewById(R.id.txtNombreProducto);
           txtCantidadProducto = itemView.findViewById(R.id.txtCantidadProducto);
           btnIncrementar = itemView.findViewById(R.id.btnIncrementar);
           btnDecrementar = itemView.findViewById(R.id.btnDecrementar);
        }
    }
}
