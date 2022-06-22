package ec.edu.epn.git.supermercado;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.*;

public class ModuloProductoTest {

    @Test
    public void given_a_file_when_is_save_then_ok() {
        ModuloProducto mp = new ModuloProducto();
        Assert.assertTrue(mp.iniciarArchivoProducto());
    }

    @Test
    public void given_agregarProductoAlArchivo_when_hay_archivo_then_escribe() {
        ModuloProducto mp = new ModuloProducto();
        Assert.assertTrue(mp.agregarProductoAlArchivo());
    }

    @Test
    public void given_formularioProducto_when_es_agregado_porTeclado_then_ok() {
        ByteArrayInputStream entradaPorTeclado = new ByteArrayInputStream("Coca Cola 1L\n7\n1.05\n1.20".getBytes());
        ModuloProducto entradaProducto = new ModuloProducto(entradaPorTeclado);
        Product p = entradaProducto.formularioProducto();
        Product p2 = new Product("Coca Cola 1L", 7, 1.05, 1.2);
        Assert.assertEquals(p2.getNombre(), p.getNombre());
        Assert.assertEquals((long)p2.getCantidad(), (long)p.getCantidad());
    }

    @Test
    public void given_String_when_buscarProducto_then_(){
        ModuloProducto mp = new ModuloProducto();
        mp.leerArchivoProducto();
        int indice = mp.buscarProductoPorNombre("Coca Cola 1L");
        Assert.assertNotNull(mp.resultadoBusquedaProducto(indice));
    }

}
