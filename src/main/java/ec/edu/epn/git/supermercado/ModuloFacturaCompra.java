package ec.edu.epn.git.supermercado;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ModuloFacturaCompra {
    private FacturaCompra facturaCompra;
    private ArrayList<FacturaCompra> listaFacturaCompra;
    private String nombreArchivo = "FacturasCompra.bin";
    private Scanner leer;
    private EscrituraLecturaArchivo<ArrayList<FacturaCompra>> archivo;

    public FacturaCompra getfacturaVenta() {
        return this.facturaCompra;
    }

    public void setFacturaCompra(FacturaCompra facturaCompra) {
        this.facturaCompra = facturaCompra;
    }

    public ModuloFacturaCompra() {
        facturaCompra = new FacturaCompra();
        listaFacturaCompra = new ArrayList<>();
        leer = new Scanner(System.in);
        archivo = new EscrituraLecturaArchivo<>(nombreArchivo);
    }

    public ModuloFacturaCompra(InputStream inputStream) {
        this.leer = new Scanner(inputStream);
    }

    public boolean iniciarArchivoFacturaCompra() {
        File fichero = new File(nombreArchivo);
        if (fichero.exists()) {
            System.out.println("Utilizando el archivo: " + nombreArchivo);
            leerArchivoFacturaCompra();
            return true;
        } else {
            System.out.println("No existe archivo entonces se creará el archivo: " + nombreArchivo);
            return false;
        }
    }

    public boolean agregarFacturaCompraAlArchivo() {
        try {
            archivo.escribirArchivo(listaFacturaCompra);
            return true;
        } catch (IOException e) {
            System.err.println("Error al manipual el archivo");
            return false;
        }
    }

    public FacturaCompra formularioFacturaCompra() {
        this.facturaCompra = new FacturaCompra();
        System.out.println("__--Formulario para el Ingreso de Facturas de Compra a Proveedores--__");
        System.out.println("_1_ Ingrese el nombre del proveedor");
        this.facturaCompra.getPedido().setNameCompany(this.leer.nextLine());
        System.out.println("_2_ Ingrese el nombre del producto");
        this.facturaCompra.getPedido().setNameProd(this.leer.nextLine());
        System.out.println("_3_ Ingrese la cantidad de productos adquiridos");
        this.facturaCompra.getPedido().setQuantity(this.leer.nextInt());
        System.out.println("_4_ Ingrese el costo de distribuidor del producto");
        this.facturaCompra.setCostoProducto(Double.parseDouble(this.leer.next()));
        this.facturaCompra.setPrecioFinalCompra(calcularTotalFactura(facturaCompra.getPedido().getQuantity(),
                facturaCompra.getCostoProducto()));
        return facturaCompra;
    }

    public double calcularTotalFactura(int cantidad, double pvp) {
        return cantidad * pvp;
    }

    public boolean opcionGuardarFacturaVenta() {
        System.out.println("|---------¿Desea guardar la factura de Compra?---------|");
        System.out.println("|------------[Si]-digite-1----[No]-digite-0-----------|");
        Scanner sc = new Scanner(System.in);
        int respuesta = sc.nextInt();
        return (respuesta == 1);
    }

    public void agregarNuevaFacturaCompra() {
        System.out.println("============Nueva Factura de Compra============");
        formularioFacturaCompra();
        if (opcionGuardarFacturaVenta()) {
            if (actualizarStockFacturaCompra()) {
                System.out.println("***Actualizando Inventario");
                listaFacturaCompra.add(facturaCompra);
                agregarFacturaCompraAlArchivo();
            } else {
                listaFacturaCompra.add(facturaCompra);
                agregarFacturaCompraAlArchivo();
                System.out.println("Se guardo la factura de compra");
            }
        } else
            System.out.println("NO se guardo la factura de compra");
    }

    public void leerArchivoFacturaCompra() {
        try {
            listaFacturaCompra = archivo.leerArchivo();
        } catch (IOException e) {
            System.err.println("Error al manipular el archivo");
        } catch (ClassNotFoundException e) {
            Logger.getLogger(ModuloProducto.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void mostrarFacturaCompraEnPantalla() {
        leerArchivoFacturaCompra();
        System.out.println("=========Lista de Facturas Compra=========");
        for (FacturaCompra fc : listaFacturaCompra) {
            facturaCompra = fc;
            imprimirFacturaCompra();
        }
    }

    public void imprimirFacturaCompra() {
        System.out.println
                ("Nombre Proveedor: " + facturaCompra.getPedido().getNameCompany() + "\n" +
                        "Nombre Producto: " + facturaCompra.getPedido().getNameProd() + "\n" +
                        "Cantidad Producto: " + facturaCompra.getPedido().getQuantity() + "\n" +
                        "Costo Producto: " + facturaCompra.getCostoProducto() + "\n" +
                        "Precio final de la compra: " + facturaCompra.getPrecioFinalCompra());
        System.out.println("-----------------------------");
    }

    public boolean actualizarStockFacturaCompra() {
        ModuloProducto mp = new ModuloProducto();
        Producto p;
        mp.leerArchivoProducto();
        int i = mp.buscarProductoPorNombre(facturaCompra.getPedido().getNameProd());
        p = mp.resultadoBusquedaProducto(i);
        if (p == null) {
            return false;
        } else {
            int suma = p.getCantidad() + facturaCompra.getPedido().getQuantity();
            p.setCantidad(suma);
            mp.agregarProductoAlArchivo();
            return true;
        }
    }
}
