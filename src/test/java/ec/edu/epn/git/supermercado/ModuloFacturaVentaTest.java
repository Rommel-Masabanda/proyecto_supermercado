package ec.edu.epn.git.supermercado;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.*;

public class ModuloFacturaVentaTest {


    @Test
    public void when_iniciar_arhivo_producto_then_ok() {
        ModuloFacturaVenta mfv = new ModuloFacturaVenta();
        Assert.assertTrue(mfv.iniciarArchivoFacturaVenta());
    }

    @Test
    public void when_agregar_factura_venta_al_archivo_then_ok() {
        ModuloFacturaVenta mfv = new ModuloFacturaVenta();
        Assert.assertTrue(mfv.agregarFacturaVentaAlArchivo());
    }

    @Test
    public void when_formulario_factura_venta_then_ok() {
        ByteArrayInputStream entradaPorTeclado = new ByteArrayInputStream("Coca Cola 1L\n7\n1.05\n1.20".getBytes());
        ModuloFacturaVenta mfv = new ModuloFacturaVenta(entradaPorTeclado);
        Producto p = mfv.formularioFacturaVenta().getProduct();
        Producto p2 = new Producto("Coca Cola 1L", 7, 1.05, 1.2);
        Assert.assertEquals(p2.getNombre(), p.getNombre());
        Assert.assertEquals(p2.getCantidad(), p.getCantidad());
    }

    @Test
    public void given_two_numbers_when_calcular_total_factura_then_ok(){
        ModuloFacturaVenta mfv = new ModuloFacturaVenta();
        String respuesta = String.valueOf(mfv.calcularTotalFactura(5,0.50));
        assertEquals("2.5",respuesta);
    }

}