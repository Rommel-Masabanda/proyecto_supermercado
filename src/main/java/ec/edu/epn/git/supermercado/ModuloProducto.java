package ec.edu.epn.git.supermercado;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ModuloProducto {
    private Producto producto;
    private ArrayList<Producto> listaProducto;
    private String nombreArchivo = "Productos.bin";
    private Scanner leer;

    public Producto getProduct() {
        return this.producto;
    }

    public void setProduct(Producto product) {
        this.producto = product;
    }

    public ModuloProducto(){
        producto = new Producto();
        listaProducto = new ArrayList<>();
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
    public Producto formularioProducto() {
        this.producto = new Producto();
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
        listaProducto = new ArrayList<>();
        try {
            fis = new FileInputStream(nombreArchivo);
            ois = new ObjectInputStream(fis);
            listaProducto = (ArrayList<Producto>) ois.readObject();
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
        for (Producto p : listaProducto) {
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

    public int buscarProductoPorNombre(String nombreABuscar){
        int i=-1;
        for(Producto p : listaProducto){
            producto = p;
            if(producto.getNombre().equals(nombreABuscar)){
              i=listaProducto.indexOf(producto);
            }
        }
        return i;
    }

    public Producto resultadoBusquedaProducto(int i){
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

    public Producto opcionBuscarPorNombre(){
        String busqueda;
        System.out.println("============Buscar Productos============");
        System.out.println("_1_Ingrese el nombre del producto a buscar");
        //busqueda = leer.nextLine();
        leer = new Scanner(System.in);
        busqueda=leer.nextLine();
        return resultadoBusquedaProducto(buscarProductoPorNombre(busqueda));
    }

    public boolean eliminarProducto(){
        System.out.println("============Eliminar Productos============");
        System.out.println("**** Primero debe ****");
        producto = opcionBuscarPorNombre();
        if(producto != null){
        System.out.println("|---Está seguro que desea eliminar "+producto.getNombre()+"-----|");
        System.out.println("|------[Si]-digite-1---[No]-digite-0------|");
        Scanner sc = new Scanner(System.in);
        int respuesta = sc.nextInt();
            if (respuesta==1){
            listaProducto.remove(producto);
            agregarProductoAlArchivo();
                System.out.println("Se ha eliminado el producto de manera satisfactoria");
            }else{
                System.out.println("No se realizo cambios en el Archivo Productos");
            }
        }
        return false;
    }

    public boolean editarInfoProducto(){
        System.out.println("========Editar Informacion Producto========");
        System.out.println("**** Primero debe ****");
        producto = opcionBuscarPorNombre();
        if(producto != null){
            System.out.println("Selecione el número del atributo que desea editar"+
                    "\n1. Nombre"+
                    "\n2. Cantidad"+
                    "\n3. Costo"+
                    "\n4. Pvp");
            Scanner sc = new Scanner(System.in);
            int atributo = sc.nextInt();
            System.out.println("|---Está seguro que desea editar el producto "+producto.getNombre()+"-----|");
            System.out.println("|------------[Si]-digite-1------[No]-digite-0------------|");
            int respuesta = sc.nextInt();
            if (respuesta==1){
                System.out.println("Digite la nueva informacion");
                sc=new Scanner(System.in);
                switch (atributo){
                    case 1:
                        producto.setNombre(sc.nextLine());
                        break;
                    case 2:
                        producto.setCantidad(sc.nextInt());
                        break;
                    case 3:
                        producto.setCosto(Double.parseDouble(sc.next()));
                        break;
                    case 4:
                        producto.setPvp(Double.parseDouble(sc.next()));
                        break;
                    default:
                        System.out.println("Opción no valida");
                }
                agregarProductoAlArchivo();
                System.out.println("Cambio realizado satisfactoriamente");
            }else{
                System.out.println("No se realizo cambios en el Archivo Productos");
            }
        }else{
            System.out.println("No se realizo cambios en el Archivo Productos");
        }
        return false;
    }
}
