package ec.edu.epn.git.supermercado;

import java.io.IOException;

public class Main {
    public static void main(String args[]) throws IOException {
        listaProv lista = new listaProv();
        lista.addProv(lista.provedorDatos());
        lista.mostrarLista();
    }

}
