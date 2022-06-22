package ec.edu.epn.git.supermercado;

import java.io.Serializable;

public class FacturaVenta implements Serializable {
    public Producto producto;
    public double precioFinal;

    public FacturaVenta(){
        this.producto = new Producto();
        this.precioFinal = 0;
    }

    public Producto getProduct() {
        return this.producto;
    }

    public void setProduct(Producto product) {
        this.producto = product;
    }

    public double getPrecioFinal(){
        return this.precioFinal;
    }

    public void setPrecioFinal(double precioFinal){
        this.precioFinal=precioFinal;
    }


}
