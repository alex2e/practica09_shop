package com.example.alejandro.practica09shop.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.alejandro.practica09shop.R;
import com.example.alejandro.practica09shop.modelos.Producto;
import com.example.alejandro.practica09shop.ui.adaptadores.CarritoActivityAdapter;

import java.util.ArrayList;

public class CarritoActivity extends AppCompatActivity {

    public static final String EXTRA_CARRITO = "EXTRA_CARRITO";
    private RecyclerView rcvCarrito;
    private Button btnComprar;
    private TextView txtPrecioCompra;
    ArrayList<Producto> productosCarrito;
    private CarritoActivityAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito);
        Intent intencion = getIntent();

        Bundle extras = intencion.getExtras();
        if(extras != null){
            productosCarrito = extras.getParcelableArrayList(EXTRA_CARRITO);
        }
        initView();
    }

    private void initView() {
        rcvCarrito = (RecyclerView) findViewById(R.id.rcvCarrito);
        btnComprar = (Button) findViewById(R.id.btnComprar);
        txtPrecioCompra = (TextView) findViewById(R.id.txtPrecioCompra);

        btnComprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        adapter = new CarritoActivityAdapter(productosCarrito);
        rcvCarrito.setAdapter(adapter);
        //Como queremos que se pinte.
        rcvCarrito.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        //Separador
        rcvCarrito.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        //Animación
        rcvCarrito.setItemAnimator(new DefaultItemAnimator());
    }

    public static void startForResult(Activity actividad, int requestCode, ArrayList<Producto> productosCarrito) {
        Intent intencion = new Intent(actividad, CarritoActivity.class);
        intencion.putExtra(EXTRA_CARRITO, productosCarrito);
        actividad.startActivityForResult(intencion, requestCode);
    }
}
