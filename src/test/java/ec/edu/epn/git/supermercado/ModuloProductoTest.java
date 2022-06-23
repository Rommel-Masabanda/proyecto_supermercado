package ec.edu.epn.git.supermercado;

import static org.junit.Assert.*;
import org.junit.Test;

import java.io.ByteArrayInputStream;

public class ModuloProductoTest {


    @Test
    public void when_agregar_producto_al_archivo_then_ok() {
        ModuloProducto mp = new ModuloProducto();
        assertTrue(mp.agregarProductoAlArchivo());
    }

    @Test
    public void given_datos_producto_when_formulario_producto_then_ok() {
        ByteArrayInputStream entradaPorTeclado = new ByteArrayInputStream("Coca Cola 1L\n7\n1.05\n1.20".getBytes());
        ModuloProducto entradaProducto = new ModuloProducto(entradaPorTeclado);
        Producto p = entradaProducto.formularioProducto();
        assertEquals(p.getNombre(), "Coca Cola 1L");
        assertEquals(p.getCantidad(), 7);
    }

    @Test
    public void given_string_when_buscar_producto_then_ok(){
        ModuloProducto mp = new ModuloProducto();
        mp.leerArchivoProducto();
        int indice = mp.buscarProductoPorNombre("");
        assertNull(mp.resultadoBusquedaProducto(indice));
    }

}
