package ec.edu.epn.git.supermercado;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class logginTest {
    @Test
    public void given_userPassword_then_ok(){
        ByteArrayInputStream  entrada = new ByteArrayInputStream ("kevin\npassword".getBytes());
        login log = new login(entrada);
        log.setUser("kevin");
        log.setPassword("password");
        Assert.assertTrue(log.aunticar());

    }
}
