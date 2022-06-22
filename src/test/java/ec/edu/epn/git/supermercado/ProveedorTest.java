package ec.edu.epn.git.supermercado;

import org.junit.Test;

import java.io.IOException;

public class ProveedorTest {
     @Test
    public void addprovecdorTest() {
        ListaProv lista = new ListaProv();
        String name = "Kevin Caranqui";
        String company = "Coca-Cola";
        String days = "Lunes-Jueves";
        Proveedor prove = new Proveedor(name, company,days);
        lista.addProv(prove);
        lista.mostrarLista();
    }
    @Test
    public void generatePedido(){

    }
}
