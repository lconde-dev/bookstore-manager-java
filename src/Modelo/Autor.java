//Paulina Vazquez - 325917
//Lucas Conde - 340100
package Modelo;

import java.io.Serializable;
import java.util.*;


public class Autor implements Serializable {
    private String nombre;
    private String nacionalidad;
    private ArrayList<Genero> generosQueEscribe;

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return this.nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public ArrayList<Genero> getGenerosQueEscribe() {
        return this.generosQueEscribe;
    }

    public void setGenerosQueEscribe(ArrayList<Genero> generosQueEscribe) {
        this.generosQueEscribe = generosQueEscribe;
    }
    
    public Autor(){
        this.setNombre("Sin nombre");
        this.setNacionalidad("Sin nacionalidad");
        this.setGenerosQueEscribe(new ArrayList<Genero>());
    }

    public Autor(String unNombre, String unaNacionalidad, ArrayList<Genero> listaGenerosQueEscribe) {
        this.setNombre(unNombre);
        this.setNacionalidad(unaNacionalidad);
        this.setGenerosQueEscribe(listaGenerosQueEscribe);
    }
    
    @Override
    public boolean equals(Object o){
        
        return this.getNombre().equals(((Autor) o).getNombre());
    }
    
    @Override
    public String toString(){
        return this.getNombre() + " (" + this.getNacionalidad() + ")";
    }
    
    
    
}
