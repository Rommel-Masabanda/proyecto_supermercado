package ec.edu.epn.git.supermercado;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class ListaPedido {
    ArrayList<Pedido> listaPedido = new ArrayList<Pedido>();
    Pedido pedido;

    public Pedido datosPedido() throws IOException { //se llenan los datos del pedido
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
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
    //exportar Archivo
    public void export(){
        String DetallePedido = "Factura"+ pedido.getNameProd() + pedido.getFechaPedido();
        try{
            FileWriter archivo = new FileWriter("C:\\Users\\yagua\\Desktop\\DetallePedido+ pedido.getNameProd() + pedido.getFechaPedido().txt", true);
            try(BufferedWriter almacen = new BufferedWriter(archivo)){
                almacen.write(listaPedido + "\n");
                almacen.close();
            }
            archivo.close();
        }catch (Exception ex){}
    }

}
