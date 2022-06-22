package ec.edu.epn.git.supermercado;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ModuloProducto {
    private Product producto;
    private ArrayList<Product> listaProducto;
    private String nombreArchivo = "Productos.bin";
    private Scanner leer;
    login newlogin;

    public Product getProduct() {
        return this.producto;
    }

    public void setProduct(Product product) {
        this.producto = product;
    }

    public ModuloProducto(){
        producto = new Product();
        listaProducto = new ArrayList();
        leer = new Scanner(System.in);
    }

    public ModuloProducto(InputStream inputStream) {
        this.leer = new Scanner(inputStream);
    }

    public boolean iniciarArchivoProducto(){
        File fichero = new File(nombreArchivo);
        if (fichero.exists()){
            System.out.println("Utilizando el archivo: " + nombreArchivo);
            leerArchivoProducto();
            return true;
        }else{
            System.out.println("No existe archivo entonces se creará el archivo: "+ nombreArchivo );
            return false;
        }
    }

    public boolean agregarProductoAlArchivo(){

        File archivo = new File(nombreArchivo);
        FileOutputStream fos;
        ObjectOutputStream oos;
        try {
            fos = new FileOutputStream(archivo);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(listaProducto);
            oos.close();
            return true;
        }catch(FileNotFoundException e){
            System.out.println("Error al localizar el archivo");
            return false;
        }catch (IOException e){
            System.out.println("Error al manipular el archivo");
            return false;
        }

    }

    //Luego de guardar debemos ingresar la informacion
    public Product formularioProducto() {
        this.producto = new Product();
        System.out.println("__--Formulario para Agregar un Producto--__");
        System.out.println("_1_ Ingrese el nombre del producto");
        this.producto.setNombre(this.leer.nextLine());
        System.out.println("_2_ Ingrese la cantidad del producto");
        this.producto.setCantidad(this.leer.nextInt());
        System.out.println("_3_ Ingrese el costo del producto");
        this.producto.setCosto(Double.parseDouble(this.leer.next()));
        System.out.println("_4_ Ingrese el pvp del producto");
        this.producto.setPvp(Double.parseDouble(this.leer.next()));
        return this.producto;
    }
    //iniciar sesion
    public boolean singin(){
        newlogin = new login("admin", "123");
        newlogin.aunticar();
        return true;
    }

    public boolean opcionGuardarProducto(){
        System.out.println("|---------¿Desea guardar los datos?---------|");
        System.out.println("|-----[Si]-digite-1----[No]-digite-0--------|");
        Scanner sc = new Scanner(System.in);
        int respuesta = sc.nextInt();
        return (respuesta == 1);
    }

    public void agregarNuevoProducto(){
        System.out.println("============Nuevo Producto============");
        formularioProducto();
        if(opcionGuardarProducto()){
                listaProducto.add(producto);
                agregarProductoAlArchivo();
                System.out.println("Se guardo el nuevo producto");
        }else
            System.out.println("NO se guardo el nuevo producto");
    }

    public void leerArchivoProducto(){
        FileInputStream fis;
        ObjectInputStream ois;
        listaProducto = new ArrayList();
        try {
            fis = new FileInputStream(nombreArchivo);
            ois = new ObjectInputStream(fis);
            listaProducto = (ArrayList<Product>)ois.readObject();
        }catch(FileNotFoundException e){
            System.out.println("Archivo no existe");
        }catch (IOException e){
            System.out.println("Error al manipular");
        }catch (ClassNotFoundException e){
            Logger.getLogger(ModuloProducto.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void mostrarProductosEnPantalla(){
        leerArchivoProducto();
        System.out.println("=========Lista de Productos=========");
        for (Product p : listaProducto) {
            producto = new Product();
            producto = p;
            imprimirProducto();
        }
    }

    public void imprimirProducto(){
        System.out.println("Nombre: "+producto.getNombre()+"\n"+
                "Cantidad: "+producto.getCantidad()+"\n"+
                "Costo: "+producto.getCosto()+"\n"+
                "Pvp: "+producto.getPvp());
        System.out.println("-----------------------------");
    }

    //PREGUNTA SI DESEA EDITAR ALGÚN PRODUCTO
    public boolean opcionEditarProducto(){
        System.out.println("|---------¿Desea editar los datos?---------|");
        System.out.println("|-----[Si]-digite-1----[No]-digite-0--------|");
        Scanner sc = new Scanner(System.in);
        int respuesta = sc.nextInt();
        return (respuesta == 1);
    }

    public int buscarProductoPorNombre(String nombreABuscar){
        int i=-1;
        for(Product p : listaProducto){
            producto = new Product();
            producto = p;
            if(producto.getNombre().equals(nombreABuscar)){
              i=listaProducto.indexOf(producto);
            }
        }
        return i;
    }

    public Product resultadoBusquedaProducto(int i){
        if (i==-1){
            System.out.println("***El producto no existe");
            return null;
        }else {
            System.out.println("***Producto encontrado");
            producto = listaProducto.get(i);
            imprimirProducto();
            return producto;
        }
    }

    public Product opcionBuscarPorNombre(){
        String busqueda="";
        System.out.println("============Buscar Productos============");
        System.out.println("_1_Ingrese el nombre del producto a buscar");
        //busqueda = leer.nextLine();
        leer = new Scanner(System.in);
        busqueda=leer.nextLine();
        return resultadoBusquedaProducto(buscarProductoPorNombre(busqueda));
    }

    //
    public void editarProducto(){
        System.out.println("============Editando Producto============");
        formularioProducto();
        if(opcionGuardarProducto()){
            listaProducto.add(producto);
            agregarProductoAlArchivo();
            System.out.println("Se guardo el nuevo producto");
        }else
            System.out.println("NO se guardo el nuevo producto");
    }

}
