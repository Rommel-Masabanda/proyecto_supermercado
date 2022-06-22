package ec.edu.epn.git.supermercado;

import org.junit.Assert;
import org.junit.Test;

public class ProductoTest {
    @Test
    public void given_a_Producto_when_is_created_then_ok() {
        Producto p = new Producto();
        Assert.assertNotNull(p);
    }

}