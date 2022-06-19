package ec.edu.epn.git.supermercado;

import java.util.Date;

public class Pedido {
    String nameProd;
    String nameCompany;
    int quantity;
    Date fechaPedido;
    Date fechaEntrega;

    public Pedido(String nameProd, String nameProve, int quantity, Date fechaPedido, Date fechaEntrega) {
        this.nameProd = nameProd;
        this.nameCompany = nameProve;
        this.quantity = quantity;
        this.fechaPedido = fechaPedido;
        this.fechaEntrega = fechaEntrega;
    }

    public String getNameProd() {
        return nameProd;
    }

    public void setNameProd(String nameProd) {
        this.nameProd = nameProd;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    @Override
    public String toString() {
        String exit;
        exit = "Nombre: " + nameProd+
                "\nEmpresa: " + nameCompany+
                "\nCantidad: " + quantity +
                "\nFecha de Pedido: " + fechaPedido+
                "\nFecha de Entrega: " + fechaEntrega;
        return exit;
    }
}
