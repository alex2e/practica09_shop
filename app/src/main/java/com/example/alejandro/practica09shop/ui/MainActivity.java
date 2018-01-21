package com.example.alejandro.practica09shop.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.alejandro.practica09shop.ui.adaptadores.MainActivityAdapter;
import com.example.alejandro.practica09shop.viewModels.MainActivityViewModel;
import com.example.alejandro.practica09shop.modelos.Producto;
import com.example.alejandro.practica09shop.R;
import com.example.alejandro.practica09shop.datos.BdProductos;

import java.util.ArrayList;

import me.relex.circleindicator.CircleIndicator;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton fabAdd;
    private ViewPager viewPager;
    private CircleIndicator indicator;
    private BdProductos productos;
    private MainActivityViewModel viewModel;
    private MainActivityAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        fabAdd = (FloatingActionButton) findViewById(R.id.fabAdd);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        indicator = (CircleIndicator) findViewById(R.id.indicator);

        //Cuando clicamos el FAB
        fabAdd.setOnClickListener(v -> aniadirProducto());

        //Cogemos la BD
        productos = BdProductos.getInstance();

        //Traerme el viewModel que se encargará de que no se destruyan los datos nunca.
        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);

        //Guardamos en el viewModel la base de datos.
        if (viewModel.getProductos()== null){
            viewModel.setProductos(productos.getProductosEnBd());
        }

        //Creamos el adaptador
        adapter = new MainActivityAdapter(this, viewModel.getProductos());

        // Le decimos al viewPager que use el adaptador anterior
        viewPager.setAdapter(adapter);

        //Le decimos al CyrcleIndicator que use el view pager.
        indicator.setViewPager(viewPager);


    }

    private void aniadirProducto() {
        Producto productoRecibido = adapter.getItem(viewPager.getCurrentItem());

        viewModel.getCarrito().add(productoRecibido);
        Toast.makeText(this, "Has añadido un producto al carrito", Toast.LENGTH_SHORT).show();;
    }

    //Para que se cree el menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Se obtiene un objeto inflador de menús.
        MenuInflater inflador = getMenuInflater();
        // Se infla la especificacion xml del menú (mimenu.xml) y
        // se almacena en el menú.
        inflador.inflate(R.menu.main_activity_menu, menu);
        // Por si el sistema quiere añadir algún ítem de menú.
        return super.onCreateOptionsMenu(menu);
    }
    //Cuando se pulsa un boton del menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Dependiendo del ítem seleccionado.
        switch (item.getItemId()) {
            case R.id.mnu_Carrito:
                irCarrito();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void irCarrito() {
        CarritoActivity.startForResult(this,1,viewModel.getCarrito());
    }

}
