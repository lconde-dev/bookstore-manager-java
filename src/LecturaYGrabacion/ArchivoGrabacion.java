//Paulina Vazquez - 325917
//Lucas Conde - 340100
package LecturaYGrabacion;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ArchivoGrabacion {

    private Formatter out;

    public ArchivoGrabacion(String unNombre) {
        try {
            this.out = new Formatter(unNombre);
        } catch (FileNotFoundException e) {
            System.out.println("Error");
        }
    }

    public ArchivoGrabacion(String unNombre, boolean ext) throws IOException {
        try {
            FileWriter f = new FileWriter(unNombre, ext);
            this.out = new Formatter(f);

        } catch (FileNotFoundException e) {
            System.out.println("Error");

        }
    }

    public void grabarLinea(String linea) {
        this.out.format("%s%n", linea);
    }
    
    public void cerrar(){
        this.out.close();
    }
}
