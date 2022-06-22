package ec.edu.epn.git.supermercado;

import java.io.Serializable;

public class FacturaCompra implements Serializable {

    public Pedido pedido;
    public double costoProducto;
    public double precioFinalCompra;

    public FacturaCompra(){
        this.pedido = new Pedido();
        this.costoProducto = 0;
        this.precioFinalCompra = 0;
    }


    public Pedido getPedido() {return this.pedido;}

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public double getCostoProducto() {return this.costoProducto;}

    public void setCostoProducto(double costoProducto) {
        this.costoProducto = costoProducto;
    }

    public double getPrecioFinalCompra(){
        return this.precioFinalCompra;
    }

    public void setPrecioFinalCompra(double precioFinal){
        this.precioFinalCompra=precioFinal;
    }

}
