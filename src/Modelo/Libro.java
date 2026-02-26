//Paulina Vazquez - 325917
//Lucas Conde - 340100
package Modelo;

import java.awt.Image;
import java.io.*;
import javax.swing.ImageIcon;

public class Libro implements Serializable{

    private Editorial editorial;
    private Genero genero;
    private Autor autor;
    private String isbn;
    private String titulo;
    private int precioDeCosto;
    private int precioDeVenta;
    private String tapaPath;
    private int cantidadEjemplares;

    public Editorial getEditorial() {
        return this.editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    public Genero getGenero() {
        return this.genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Autor getAutor() {
        return this.autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return this.isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getPrecioDeCosto() {
        return this.precioDeCosto;
    }

    public void setPrecioDeCosto(int precioDeCosto) {
        this.precioDeCosto = precioDeCosto;
    }

    public int getPrecioDeVenta() {
        return this.precioDeVenta;
    }

    public void setPrecioDeVenta(int precioDeVenta) {
        this.precioDeVenta = precioDeVenta;
    }

    public int getCantidadEjemplares() {
        return this.cantidadEjemplares;
    }

    public void setCantidadEjemplares(int cantidadEjemplares) {
        this.cantidadEjemplares = cantidadEjemplares;
    }

    
    
    
    
    
    public Libro(Editorial unaEd, Genero unGen, Autor unAutor, String unTitulo,
            String unIsbn, int unPrecioCosto, int unPrecioVenta, int unaCantEjemplares, String tapaPath) {

        this.setEditorial(unaEd);
        this.setGenero(unGen);
        this.setAutor(unAutor);
        this.setTitulo(unTitulo);
        this.setIsbn(unIsbn);
        this.setPrecioDeCosto(unPrecioCosto);
        this.setPrecioDeVenta(unPrecioVenta);
        this.setCantidadEjemplares(unaCantEjemplares);
        this.setTapaPath(tapaPath);
    }

    public String getTapaPath() {
        return tapaPath;
    }

    public void setTapaPath(String tapaPath) {
        this.tapaPath = tapaPath;
    }
    
    public Image getTapa() {
    Image result = null;
    if (tapaPath != null && !tapaPath.isEmpty()) {
        // Intentar cargar la imagen desde la ruta proporcionada
        ImageIcon icon = new ImageIcon(tapaPath);
        result = icon.getImage();  // Asigna la imagen cargada a result
    }
    return result;  // Retorna el resultado
}

    @Override
    public boolean equals(Object o) {
        return this.getIsbn().equals(((Libro) o).getIsbn());
    }

    @Override
    public String toString() {
        return this.getIsbn() + " - " + this.getTitulo();
    }
}
