//Paulina Vazquez - 325917
//Lucas Conde - 340100
package Modelo;

import java.io.Serializable;

public class Editorial implements Serializable {

    private String nombre;
    private String paisDeOrigen;

    public void setNombre(String unNombre) {
        this.nombre = unNombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setPaisDeOrigen(String unPaisDeOrigen) {
        this.paisDeOrigen = unPaisDeOrigen;
    }

    public String getPaisDeOrigen() {
        return this.paisDeOrigen;
    }

    public Editorial() {
        this.setNombre("Sin nombre");
        this.setPaisDeOrigen("Sin pais de Origen");
    }

    public Editorial(String unNombre, String unPaisDeOrigen) {
        this.setNombre(unNombre);
        this.setPaisDeOrigen(unPaisDeOrigen);
    }

    @Override
    public boolean equals(Object o) {
        return this.getNombre().equals(((Editorial) o).getNombre());
    }

    @Override
    public String toString() {
        return this.getNombre() + " (" + this.getPaisDeOrigen() + ")";
    }
}
