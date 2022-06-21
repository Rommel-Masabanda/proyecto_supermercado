package ec.edu.epn.git.supermercado;

import java.io.IOException;

public class Main {
    public static void main(String args[]) throws IOException {
        ModuloProducto moduloProducto = new ModuloProducto();
        moduloProducto.iniciarArchivoProducto();
        moduloProducto.agregarNuevoProducto();
        moduloProducto.mostrarProductosEnPantalla();

        /*listaProv lista = new listaProv();
        lista.addProv(lista.provedorDatos());
        lista.mostrarLista();*/

        ListaPedido nuevaLista = new ListaPedido();
        nuevaLista.addPedido(nuevaLista.datosPedido());
        nuevaLista.showListaPedidos();
        nuevaLista.export();
    }

}
