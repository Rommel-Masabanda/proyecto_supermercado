package ec.edu.epn.git.supermercado;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) throws IOException {

        Scanner sc = new Scanner(System.in);
        bienvenida();
        int inicio = sc.nextInt();
        if(inicio==1){
            if (singin()){
                boolean continuar = false;
                do {
                    modulos();
                    inicio= sc.nextInt();
                    switch (inicio){

                        case 1:
                            ModuloProducto moduloProducto = new ModuloProducto();
                            moduloProducto.iniciarArchivoProducto();
                            moduloProducto.mostrarProductosEnPantalla();
                            moduloProducto.eliminarProducto();
                            moduloProducto.mostrarProductosEnPantalla();
                            moduloProducto.editarInfoProducto();
                            moduloProducto.mostrarProductosEnPantalla();
                            continuar=opcionSalir();
                            break;
                        case 2:
                            ModuloProducto moduloProducto2 = new ModuloProducto();
                            moduloProducto2.iniciarArchivoProducto();
                            ModuloFacturaVenta mfv = new ModuloFacturaVenta();
                            mfv.iniciarArchivoFacturaVenta();
                            mfv.agregarNuevoFacturaVenta();
                            mfv.mostrarFacturaVentaEnPantalla();
                            moduloProducto2.mostrarProductosEnPantalla();
                            continuar=opcionSalir();
                            break;
                        case 3:
                            ModuloProducto moduloProducto3 = new ModuloProducto();
                            moduloProducto3.iniciarArchivoProducto();
                            ModuloFacturaCompra mfc = new ModuloFacturaCompra();
                            mfc.iniciarArchivoFacturaCompra();
                            mfc.agregarNuevaFacturaCompra();
                            mfc.mostrarFacturaCompraEnPantalla();
                            moduloProducto3.mostrarProductosEnPantalla();
                            break;
                        case 4:
                            ListaProv lista = new ListaProv();
                            lista.addProv(lista.provedorDatos());
                            lista.mostrarLista();
                            continuar=opcionSalir();
                            break;
                        case 5:
                            ListaPedido nuevaLista = new ListaPedido();
                            nuevaLista.addPedido(nuevaLista.datosPedido());
                            nuevaLista.showListaPedidos();
                            nuevaLista.export();
                            continuar=opcionSalir();
                            break;
                        case 6:
                            System.out.println("Salir");
                            continuar=false;
                            break;
                    }
                }while (continuar);
                System.out.println("|--------Hasta pronto-------|");
            }
        }else{
            System.out.println("|--------Hasta pronto-------|");
        }
    }

    public static boolean singin(){
        Login newlogin;
        newlogin = new Login();
        newlogin.auntenticar("Administrador", "p@ssw0rd");
        return true;
    }
    public static void bienvenida(){
        System.out.println("|____------***Bienvedido al Supermercado***------____|");
        System.out.println("Digite una opción para continuar: ");
        System.out.println("_Para ingresar [1], para salir [2]");
    }
    public static void modulos(){
        System.out.println("|============Módulos del sistema============|");
        System.out.println("Digite el número de la opción a la cual desea acceder");
        System.out.println("__[1]__Productos");
        System.out.println("__[2]__Facturas de Venta a clientes");
        System.out.println("__[3]__Facturas de Compra a proveedores");
        System.out.println("__[4]__Proveedores");
        System.out.println("__[5]__Pedidos");
        System.out.println("__[6]__Salir");
    }

    public static boolean opcionSalir(){
        System.out.println("|---------¿Desea continuar o salir?---------|");
        System.out.println("|-------[Si]-digite-1----[No]-digite-0-------|");
        Scanner sc = new Scanner(System.in);
        int respuesta = sc.nextInt();
        return (respuesta == 1);
    }

}
