//Paulina Vazquez - 325917
//Lucas Conde - 340100
package Modelo;

import java.io.Serializable;

public class Genero implements Serializable{
   private String nombre;
   private String descripcion;

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public Genero(){
        this.setNombre("Sin nombre");
        this.setDescripcion("Sin descripcion");
    }

    public Genero(String unNombre, String unaDescripcion) {
        this.setNombre(unNombre);
        this.setDescripcion(unaDescripcion);
    }
   
   @Override
    public boolean equals(Object o){
        return this.getNombre().equals(((Genero) o).getNombre());
    }
    
    @Override
    public String toString(){
        return this.getNombre() + ": " + this.getDescripcion();
    }
}
