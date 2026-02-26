//Paulina Vazquez - 325917
//Lucas Conde - 340100
package Modelo;

import java.io.Serializable;
import java.util.*;
import javax.swing.JOptionPane;

public class Venta extends Observable implements Serializable {

    private int numFactura;
    private String nombreCliente;
    private String fecha;
    private HashMap<Libro, LineaDeVenta> librosSeleccionados;
    private int precioVentaTotal;
    private int precioCostoTotal;

    public Venta() {
        this.numFactura = 0;
        this.nombreCliente = "Sin Nombre";
        this.fecha = "00/00/0000";
        this.librosSeleccionados = new HashMap<Libro, LineaDeVenta>();

    }

    public Venta(int unNumFact, String unNombre, String unaFecha, HashMap<Libro, LineaDeVenta> unaListaLibros) {
        this.numFactura = unNumFact;
        this.nombreCliente = unNombre;
        this.fecha = unaFecha;
        this.librosSeleccionados = unaListaLibros;

    }

    public int getNumFactura() {
        return numFactura;
    }

    public void setNumFactura(int numFactura) {
        this.numFactura = numFactura;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getPrecioVentaTotal() {
        return precioVentaTotal;
    }

    public void setPrecioVentaTotal(int precioVentaTotal) {
        this.precioVentaTotal = precioVentaTotal;
        setChanged();
        notifyObservers();
    }

    public int getPrecioCostoTotal() {
        return precioCostoTotal;
    }

    public void setPrecioCostoTotal(int precioCostoTotal) {
        this.precioCostoTotal = precioCostoTotal;
    }

    public HashMap<Libro, LineaDeVenta> getLibrosSeleccionados() {
        return librosSeleccionados;
    }

    public void setLibrosSeleccionados(HashMap<Libro, LineaDeVenta> librosSeleccionados) {
        this.librosSeleccionados = librosSeleccionados;
    }

    public LineaDeVenta[] getListaVenta() {
        ArrayList<LineaDeVenta> aux = new ArrayList<LineaDeVenta>();

        for (LineaDeVenta ldv : this.getLibrosSeleccionados().values()) {
            aux.add(ldv);
        }
        LineaDeVenta[] res = new LineaDeVenta[aux.size()];
        res = aux.toArray(res);
        return res;

    }

    public void calcularPreciosTotales() {
        int precioVent = 0;
        int precioCost = 0;
        for (Libro lib : this.getLibrosSeleccionados().keySet()) {
            precioVent += lib.getPrecioDeVenta() * this.getLibrosSeleccionados().get(lib).getCantidad();
            precioCost += lib.getPrecioDeCosto() * this.getLibrosSeleccionados().get(lib).getCantidad();
        }
        this.setPrecioVentaTotal(precioVent);

        this.setPrecioCostoTotal(precioCost);
    }

}
