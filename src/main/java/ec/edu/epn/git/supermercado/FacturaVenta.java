package ec.edu.epn.git.supermercado;

import java.io.Serializable;

public class FacturaVenta implements Serializable {
    public Product producto;
    public double precioFinal;

    public FacturaVenta(){
        this.producto = new Product();
        this.precioFinal = 0;
    }

    public Product getProduct() {
        return this.producto;
    }

    public void setProduct(Product product) {
        this.producto = product;
    }

    public double getPrecioFinal(){
        return this.precioFinal;
    }

    public void setPrecioFinal(double precioFinal){
        this.precioFinal=precioFinal;
    }


}
