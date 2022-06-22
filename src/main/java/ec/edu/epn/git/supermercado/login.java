package ec.edu.epn.git.supermercado;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class login {
    private String user;
    private String password;
    Scanner teclado = new Scanner(System.in);

    public login() {
    }

    public login(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    //crear usuario
    public void crearUsuario(){
        System.out.println("===============CREANDO USUARIO================");
        System.out.print("USUARIO: ");
        this.user= teclado.nextLine();
        System.out.print("CONTRASEÑA: ");
        this.password  = teclado.nextLine();
    }

    //auntificar usuario
    public boolean aunticar(){
        System.out.println("===============INICIO DE SESIÓN================");
        System.out.print("USUARIO: ");
        String usuario = teclado.nextLine();
        System.out.print("CONTRASEÑA: ");
        String contrasena = teclado.nextLine();

        if(usuario.equals(user) && contrasena.equals(password)){
            System.out.println("Bienvenido "+usuario);
            return true;
        } else {
            System.out.println("USUARIO O CONTRASEÑA INCORRECTOS");
            aunticar();
            return false;
        }
    }
}
