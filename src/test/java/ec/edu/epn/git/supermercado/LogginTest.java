package ec.edu.epn.git.supermercado;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;

public class LogginTest {
    @Test
    public void given_two_Strings_when_autenticar_then_ok(){
        Login log = new Login();

        Assert.assertTrue(log.auntenticar("Administrador", "p@ssw0rd"));

    }
}
