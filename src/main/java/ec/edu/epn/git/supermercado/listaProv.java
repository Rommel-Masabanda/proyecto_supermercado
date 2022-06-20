package ec.edu.epn.git.supermercado;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class listaProv {
    ArrayList<proveedor> listaProvedores = new ArrayList<proveedor>();
    //Llenar datos del proveedor
    proveedor proveedor;

    public proveedor provedorDatos() throws IOException {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Nombre:");
        String name = teclado.readLine();
        System.out.println("Empresa:");
        String company = teclado.readLine();
        System.out.println("Dias de Visita:");
        String days = teclado.readLine();
        proveedor = new proveedor(name, company,days);

        return proveedor;
    }
    public void addProv(proveedor proveedor){
        listaProvedores.add(proveedor);
    }
    //Muestra la lista de Proveedores
    public void mostrarLista(){
        for(int i = 0; i < listaProvedores.size() ; i++){
            System.out.println(listaProvedores.get(i));
        }
    }

}
