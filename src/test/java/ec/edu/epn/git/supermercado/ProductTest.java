package ec.edu.epn.git.supermercado;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProductTest {
    @Test
    public void given_a_Producto_when_is_created_then_ok() {
        Product p = new Product();
        Assert.assertNotNull(p);
    }

}