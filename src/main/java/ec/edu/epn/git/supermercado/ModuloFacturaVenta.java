package ec.edu.epn.git.supermercado;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ModuloFacturaVenta {
    private FacturaVenta facturaVenta = new FacturaVenta();
    private ArrayList<FacturaVenta> listaFacturaVenta;
    private String nombreArchivo = "FacturasVenta.bin";
    private Scanner leer;
    Login newlogin;

    public FacturaVenta getfacturaVenta() {
        return this.facturaVenta;
    }

    public void setFacturaVenta(FacturaVenta facturaVenta) {
        this.facturaVenta = facturaVenta;
    }

    public ModuloFacturaVenta() {
        listaFacturaVenta = new ArrayList<>();
        leer = new Scanner(System.in);
    }

    public ModuloFacturaVenta(InputStream inputStream) {
        this.leer = new Scanner(inputStream);
    }

    public boolean iniciarArchivoFacturaVenta() {
        File fichero = new File(nombreArchivo);
        if (fichero.exists()) {
            System.out.println("Utilizando el archivo: " + nombreArchivo);
            leerArchivoFacturaVenta();
            return true;
        } else {
            System.out.println("No existe archivo entonces se creará el archivo: " + nombreArchivo);
            return false;
        }
    }

    public boolean agregarFacturaVentaAlArchivo() {

        File archivo = new File(nombreArchivo);
        FileOutputStream fos;
        ObjectOutputStream oos;
        try {
            fos = new FileOutputStream(archivo);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(listaFacturaVenta);
            oos.close();
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("Error al localizar el archivo");
            return false;
        } catch (IOException e) {
            System.out.println("Error al manipular el archivo");
            return false;
        }
    }

    public FacturaVenta formularioFacturaVenta() {
        this.facturaVenta = new FacturaVenta();
        System.out.println("__--Formulario para Generar una Factura de Venta--__");
        System.out.println("_1_ Ingrese el nombre del producto");
        this.facturaVenta.getProduct().setNombre(this.leer.nextLine());
        System.out.println("_2_ Ingrese la cantidad del producto");
        this.facturaVenta.getProduct().setCantidad(this.leer.nextInt());
        System.out.println("_3_ Ingrese el pvp del producto");
        this.facturaVenta.getProduct().setPvp(Double.parseDouble(this.leer.next()));
        this.facturaVenta.setPrecioFinal(calcularTotalFactura(facturaVenta.getProduct().getCantidad(),
                facturaVenta.getProduct().getPvp()));
        return facturaVenta;
    }

    public double calcularTotalFactura(int cantidad, double pvp) {
        return cantidad * pvp;
    }

    public boolean opcionGuardarFacturaVenta() {
        System.out.println("|---------¿Desea guardar la factura de venta?---------|");
        System.out.println("|------------[Si]-digite-1----[No]-digite-0-----------|");
        Scanner sc = new Scanner(System.in);
        int respuesta = sc.nextInt();
        return (respuesta == 1);
    }

    public void agregarNuevoFacturaVenta() {
        System.out.println("============Nueva Factura de venta============");
        formularioFacturaVenta();
        if (opcionGuardarFacturaVenta()) {
            if (actualizarStockFacturaVenta()) {
                System.out.println("***Actualizando Inventario");
                listaFacturaVenta.add(facturaVenta);
                agregarFacturaVentaAlArchivo();
            } else {
                listaFacturaVenta.add(facturaVenta);
                agregarFacturaVentaAlArchivo();
                System.out.println("Se guardo el nuevo producto");
            }
        } else
            System.out.println("NO se guardo el nuevo producto");
    }

    public void leerArchivoFacturaVenta() {
        FileInputStream fis;
        ObjectInputStream ois;
        listaFacturaVenta = new ArrayList<>();
        try {
            fis = new FileInputStream(nombreArchivo);
            ois = new ObjectInputStream(fis);
            listaFacturaVenta = (ArrayList<FacturaVenta>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no existe");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            Logger.getLogger(ModuloProducto.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void mostrarFacturaVentaEnPantalla() {
        leerArchivoFacturaVenta();
        System.out.println("=========Lista de Facturas de Ventas=========");
        for (FacturaVenta fv : listaFacturaVenta) {
            facturaVenta = fv;
            imprimirFacturaVenta();
        }
    }

    public void imprimirFacturaVenta() {
        System.out.println("Nombre: " + facturaVenta.getProduct().getNombre() + "\n" +
                "Cantidad: " + facturaVenta.getProduct().getCantidad() + "\n" +
                "PVP: " + facturaVenta.getProduct().getPvp() + "\n" +
                "Precio Final: " + facturaVenta.getPrecioFinal());
        System.out.println("-----------------------------");
    }

    public boolean actualizarStockFacturaVenta() {
        ModuloProducto mp = new ModuloProducto();
        Producto p;
        mp.leerArchivoProducto();
        int i = mp.buscarProductoPorNombre(facturaVenta.getProduct().getNombre());
        p = mp.resultadoBusquedaProducto(i);
        if (p == null) {
            return false;
        } else {
            if (facturaVenta.getProduct().getCantidad() <= p.getCantidad()) {
                int resta = p.getCantidad() - facturaVenta.getProduct().getCantidad();
                mp.getProduct().setCantidad(resta);
                //facturaVenta.getProduct().setCantidad(resta);
                mp.agregarProductoAlArchivo();
                //agregarFacturaVentaAlArchivo();
                return true;
            } else {
                System.out.println("No se puede generar esta factura hay un menor stock :(");
                return false;
            }
        }
    }
}
