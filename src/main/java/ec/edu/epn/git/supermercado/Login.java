package ec.edu.epn.git.supermercado;

import java.io.InputStream;
import java.util.Objects;
import java.util.Scanner;

public class Login {
    private String user;
    private String password;

    public Login() {
        this.user = "Administrador";
        this.password = "p@ssw0rd";
    }

    public boolean auntenticar(String user, String password) {
        return this.user.equals(user) && this.password.equals(password);
    }
}
