package ec.edu.epn.git.supermercado;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ListaProv {
    ArrayList<Proveedor> listaProvedores = new ArrayList<>();
    //Llenar datos del proveedor
    Proveedor proveedor;

    public Proveedor provedorDatos() throws IOException {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("============Ingreso Proveedor============");
        System.out.println("Nombre:");
        String name = teclado.readLine();
        System.out.println("Empresa:");
        String company = teclado.readLine();
        System.out.println("Dias de Visita:");
        String days = teclado.readLine();
        proveedor = new Proveedor(name, company,days);

        return proveedor;
    }
    public void addProv(Proveedor proveedor){
        listaProvedores.add(proveedor);
    }
    //Muestra la lista de Proveedores
    public void mostrarLista(){
        for (Proveedor listaProvedore : listaProvedores) {
            System.out.println(listaProvedore);
        }
    }

}
