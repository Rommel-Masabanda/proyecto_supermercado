package ec.edu.epn.git.supermercado;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

public class ProveedorTest {
     @Test
    public void addprovecdorTest() throws IOException {
        listaProv lista = new listaProv();
        String name = "Kevin Caranqui";
        String company = "Coca-Cola";
        String days = "Lunes-Jueves";
        proveedor prove = new proveedor(name, company,days);
        lista.addProv(prove);
        lista.mostrarLista();
    }
    @Test
    public void generatePedido(){

    }
}
