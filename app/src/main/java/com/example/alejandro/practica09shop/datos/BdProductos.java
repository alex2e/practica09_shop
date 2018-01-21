package com.example.alejandro.practica09shop.datos;

import com.example.alejandro.practica09shop.modelos.Producto;

import java.util.ArrayList;

/**
 * Created by Alejandro on 21/01/2018.
 */

public class BdProductos {
    private static final BdProductos ourInstance = new BdProductos();

    private ArrayList<Producto> productosEnBd;


    public ArrayList<Producto> getProductosEnBd() {
        if (productosEnBd == null) {
            productosEnBd = new ArrayList<>();
            productosEnBd.add(new Producto("Reloj","aaa",1000,"https://i2.linio.com/p/d13cc59e557cca5603d01572e61492a2-product.jpg",1));
            productosEnBd.add(new Producto("Movil","aaa",2000,"https://gloimg.gbtcdn.com/gb/pdm-product-pic/Electronic/2017/12/14/goods-img/1513208710134915677.jpg",1));
            productosEnBd.add(new Producto("Cartera","aaa",3000,"http://www.blaque.com.ar/media/catalog/product/cache/62/image/468x468/9df78eab33525d08d6e5fb8d27136e95/c/a/cartera_66-6462_2.jpg",1));
            productosEnBd.add(new Producto("Coche","aaa",4000,"http://segurouniversia.segurosbroker.com/img/v2.0/Universidades/espera_landing/coche.png",1));
            productosEnBd.add(new Producto("Moto","aaa",5000,"http://www.motoguzzi.com/mediaObject/motoguzzi-sites/MASTER/bikes/v9/v9_roamer/gallery/my2017/Roamer_LatDx_2017/resolutions/res-o1600x1100-p-1514362764/Roamer_LatDx_2017.png",1));
        }
        return productosEnBd;
    }

    public void setProductosEnBd(ArrayList<Producto> productosEnBd) {
        this.productosEnBd = productosEnBd;
    }

    public static BdProductos getInstance() {
        return ourInstance;
    }

    //Para que no puedas instanciarlo
    private BdProductos() {
    }
}
