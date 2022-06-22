package ec.edu.epn.git.supermercado;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class logginTest {
    @Test
    public void given_userPassword_then_ok(){
        login newLogin = new login("kevin", "password");
        newLogin.crearUsuario();
        Assert.assertTrue(newLogin.aunticar());

    }
}
