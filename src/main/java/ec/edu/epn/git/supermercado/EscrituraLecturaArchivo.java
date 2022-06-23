package ec.edu.epn.git.supermercado;

import java.io.*;

public class EscrituraLecturaArchivo<T> {
    private String nameFile;
    private File archivo;

    public EscrituraLecturaArchivo(String nameFile) {
        this.nameFile = nameFile;
        this.archivo = new File(nameFile);
    }

    public void escribirArchivo(T object) throws IOException {
        FileOutputStream fos = new FileOutputStream(archivo);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(object);
        oos.close();
    }

    public T leerArchivo() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(archivo);
        ObjectInputStream ois = new ObjectInputStream(fis);
        T objeto = (T)ois.readObject();
        ois.close();
        return objeto;
    }
}
