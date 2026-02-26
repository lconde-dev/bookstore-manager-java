//Paulina Vazquez - 325917
//Lucas Conde - 340100
package LecturaYGrabacion;

import java.io.*;
import java.nio.file.Paths;
import java.util.*;

public class ArchivoLectura {
    private Scanner in;
    private String linea;
    
    public ArchivoLectura (String unNombre){
        try{
            this.in = new Scanner(Paths.get(unNombre));
        } catch (IOException e){
            System.err.println("Error");
            System.exit(1);
        }
    }
    
    public boolean hayMasLineas(){
        boolean hay = false;
        this.linea = null;
        if(this.in.hasNext()){
            this.linea= this.in.nextLine();
            hay=true;
        }
        
        return hay;
    }
    
    public String linea(){
        return this.linea;
    }
    
    public void cerrar(){
        this.in.close();
    }
}
