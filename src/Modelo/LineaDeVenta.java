//Paulina Vazquez - 325917
//Lucas Conde - 340100
package Modelo;

import java.io.Serializable;


public class LineaDeVenta implements Serializable {
    private Libro lib;
    private int cantidad;

    public LineaDeVenta(Libro lib, int cantidad) {
        this.lib = lib;
        this.cantidad = cantidad;
    }

    public Libro getLib() {
        return lib;
    }

    public void setLib(Libro lib) {
        this.lib = lib;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    @Override
    public String toString(){
        return this.getCantidad() + " - " + this.getLib().getTitulo() + " - $ " + this.getLib().getPrecioDeVenta();
    }
    
}
