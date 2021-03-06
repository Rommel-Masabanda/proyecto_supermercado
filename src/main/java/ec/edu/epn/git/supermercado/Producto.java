package ec.edu.epn.git.supermercado;

import java.io.Serializable;

public class Producto implements Serializable {
    private String nombre;
    private int cantidad;
    private double costo;
    private double pvp;

    public Producto() {
    }

    public Producto(String nombre, int cantidad, double costo, double pvp) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.costo = costo;
        this.pvp = pvp;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getCosto() {
        return this.costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public double getPvp() {
        return this.pvp;
    }

    public void setPvp(double pvp) {
        this.pvp = pvp;
    }

    public void imprimirProducto() {
        System.out.println("Nombre: "+this.nombre+"\n"+
                "Cantidad: "+this.cantidad+"\n"+
                "Costo: "+this.costo+"\n"+
                "Pvp: "+this.pvp);
        System.out.println("-----------------------------");
    }
}

