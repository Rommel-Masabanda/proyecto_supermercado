package ec.edu.epn.git.supermercado;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.*;

public class ModuloFacturaCompraTest {
    @Test
    public void given_inicarArhivoProducto_when_is_called_then_ok() {
        ModuloFacturaCompra mfc = new ModuloFacturaCompra();
        Assert.assertTrue(mfc.iniciarArchivoFacturaCompra());
    }

    @Test
    public void given_agregarFacturaCompraAlArchivo_when_hay_archivo_then_escribe() {
        ModuloFacturaCompra mfc = new ModuloFacturaCompra();
        Assert.assertTrue(mfc.agregarFacturaCompraAlArchivo());
    }

    @Test
    public void given_formularioFacturaCompra_when_es_agregado_porTeclado_then_ok() {
        ByteArrayInputStream entradaPorTeclado = new ByteArrayInputStream("Proveedor 1\nCoca Cola 1L\n7\n1.10".getBytes());
        ModuloFacturaCompra mfc = new ModuloFacturaCompra(entradaPorTeclado);
        Pedido p = mfc.formularioFacturaCompra().getPedido();
        Pedido p2 = new Pedido("Coca Cola 1L", "Proveedor 1", 7,null, null);
        Assert.assertEquals(p2.getNameProd(), p.getNameProd());
        Assert.assertEquals(p2.getNameCompany(), p.getNameCompany());
    }

    @Test
    public void given_2enteros_when_calcularTotalFactura_then_ok(){
        ModuloFacturaCompra mfc = new ModuloFacturaCompra();
        String respuesta = String.valueOf(mfc.calcularTotalFactura(5,0.50));
        assertEquals("2.5",respuesta);
    }


}