package ec.edu.epn.git.supermercado;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class ListaPedido {
    ArrayList<Pedido> listaPedido = new ArrayList<Pedido>();
    Pedido pedido;
    login newlogin;

    public Pedido datosPedido() throws IOException { //se llenan los datos del pedido
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("============Ingreso Pedido============");
        System.out.println("Nombre del Producto:");
        String Productname = teclado.readLine();
        System.out.println("Empresa:");
        String company = teclado.readLine();
        System.out.println("Cantidad:");
        int quantity = Integer.parseInt(teclado.readLine());
        System.out.println("Fecha de Pedido");
        Date fPedido = new Date();
        System.out.println("Fecha de Entrega: ");
        Date fEntrega = new Date();
        pedido = new Pedido(Productname, company,quantity, fPedido, fEntrega);
        return pedido;
    }

    public void addPedido(Pedido pedido){
        listaPedido.add(pedido);

    }
    public void showListaPedidos(){
        for(int i = 0; i < listaPedido.size() ; i++){
            System.out.println(listaPedido.get(i));
        }
    }
    //opcion guardar
    public boolean guardarArchivo(){
        System.out.println("|---------¿Desea exportar factura?---------|");
        System.out.println("|-----[Si]-digite-1----[No]-digite-0--------|");
        Scanner sc = new Scanner(System.in);
        int respuesta = sc.nextInt();
        return (respuesta == 1);
    }
    /*//iniciar sesion
    public boolean singin(){
        newlogin = new login("admin", "123");
        newlogin.aunticar();
        return true;
    }*/

    //exportar Archivo
    public void export() {
        if(guardarArchivo()){
            //if(singin()){
                String DetallePedido = "Factura"+ pedido.getNameProd() + pedido.getFechaPedido();
                try{
                    FileWriter archivo = new FileWriter("C:\\Users\\yagua\\Desktop\\DetallePedido.txt", true);
                    try(BufferedWriter almacen = new BufferedWriter(archivo)){
                        almacen.write(listaPedido + "\n");
                        almacen.close();
                    }
                    archivo.close();
                    System.out.println("Se ha guardado y exportado la factura con éxito");
                }catch (Exception ex){}
            //}
        }else{
            System.out.println("GRACIAS VUELVA PRONTO");
        }
    }

}
