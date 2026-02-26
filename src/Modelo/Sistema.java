//Paulina Vazquez - 325917
//Lucas Conde - 340100
package Modelo;

import LecturaYGrabacion.ArchivoGrabacion;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import javax.swing.*;

public class Sistema extends Observable implements Serializable {

    private int numFactura;
    private static final long serialVersionUID = 1L;
    private HashMap<String, Editorial> listaEditoriales;
    private HashMap<String, Genero> listaGeneros;
    private HashMap<String, Autor> listaAutores;
    private HashMap<String, Libro> listaLibros;
    private HashMap<Integer, Venta> listaVentas;

    public Sistema() {
        this.setNumFactura(1);
        this.setListaEditoriales(new HashMap<String, Editorial>());
        this.setListaGeneros(new HashMap<String, Genero>());
        this.setListaAutores(new HashMap<String, Autor>());
        this.setListaLibros(new HashMap<String, Libro>());
        this.setListaVentas(new HashMap<Integer, Venta>());
    }

    public int getNumFactura() {
        return numFactura;
    }

    public void setNumFactura(int numeroFactura) {
        this.numFactura = numeroFactura;
    }

    //Metodos de Editoriales
    public HashMap<String, Editorial> getListaEditoriales() {
        return this.listaEditoriales;
    }

    public void setListaEditoriales(HashMap<String, Editorial> unaListaEditoriales) {
        this.listaEditoriales = unaListaEditoriales;
    }

    public void agregarEditorial(Editorial unaEditorial) {
        this.getListaEditoriales().put(unaEditorial.getNombre(), unaEditorial);
        setChanged();
        notifyObservers();
    }

    public boolean existeEditorial(String unNombre) {
        return this.getListaEditoriales().containsKey(unNombre);

    }

    public Editorial[] getArrayEditoriales() {
        ArrayList<Editorial> aux = new ArrayList<Editorial>();

        for (Editorial editorial : this.getListaEditoriales().values()) {
            aux.add(editorial);
        }
        Editorial[] res = new Editorial[aux.size()];
        res = aux.toArray(res);
        return res;

    }

    //Metodos de Generos
    public HashMap<String, Genero> getListaGeneros() {
        return this.listaGeneros;
    }

    public void setListaGeneros(HashMap<String, Genero> unaListaGeneros) {
        this.listaGeneros = unaListaGeneros;
    }

    public void agregarGenero(Genero genero) {
        this.getListaGeneros().put(genero.getNombre(), genero);
        setChanged();
        notifyObservers();
    }

    public boolean existeGenero(String nombre) {
        return this.getListaGeneros().containsKey(nombre);
    }

    public Genero[] getArrayGeneros() {
        ArrayList<Genero> aux = new ArrayList<Genero>();

        for (Genero genero : this.getListaGeneros().values()) {
            aux.add(genero);
        }
        Genero[] res = new Genero[aux.size()];
        res = aux.toArray(res);
        return res;

    }

    //Metodos de Autores
    public void setListaAutores(HashMap<String, Autor> listaAutores) {
        this.listaAutores = listaAutores;
    }

    public Autor[] getArrayAutores(Genero g) {
        ArrayList<Autor> aux = new ArrayList<Autor>();

        if (g == null) {
            for (Autor autor : this.getListaAutores().values()) {
                aux.add(autor);
            }
        } else {
            for (Autor autor : this.getListaAutores().values()) {
                if (autor.getGenerosQueEscribe().contains(g)) {
                    aux.add(autor);
                }
            }
        }
        // Convertir el ArrayList a un array de Autores
        Autor[] res = new Autor[aux.size()];
        res = aux.toArray(res);

        return res;
    }

    public void agregarAutor(Autor autor) {
        this.getListaAutores().put(autor.getNombre(), autor);
        setChanged();
        notifyObservers();
    }

    public boolean existeAutor(String nombre) {
        return this.getListaAutores().containsKey(nombre);
    }

    public HashMap<String, Autor> getListaAutores() {
        return this.listaAutores;
    }

    //Metodos de Libros
    public HashMap<String, Libro> getListaLibros() {
        return this.listaLibros;
    }

    public void setListaLibros(HashMap<String, Libro> listaLibros) {
        this.listaLibros = listaLibros;
    }

    public void agregarLibro(Libro unLibro) {
        this.getListaLibros().put(unLibro.getIsbn(), unLibro);
        setChanged();
        notifyObservers();
    }

    public boolean existeLibro(String unIsbn) {
        return this.getListaLibros().containsKey(unIsbn);
    }

    public Libro[] getArrayLibros() {
        ArrayList<Libro> aux = new ArrayList<Libro>();

        for (Libro libro : this.getListaLibros().values()) {
            aux.add(libro);
        }

        Collections.sort(aux, new Comparator<Libro>() {
            public int compare(Libro l1, Libro l2) {
                int ret = (int) (l1.getTitulo().compareTo(l2.getTitulo()));
                return ret;
            }
        });

        Libro[] res = new Libro[aux.size()];
        res = aux.toArray(res);

        return res;
    }

    public void guardarImagen(File archivo, String nombre) {
        // Obtener la extensión del archivo original 
        String extension = "";
        int i = archivo.getName().lastIndexOf('.');
        if (i > 0) {
            extension = archivo.getName().substring(i);
        }

        File carpetaDestino = new File("imagenes"); // Crear una carpeta llamada "imagenes" en el directorio del proyecto
        //Si no existe, la crea
        if (!carpetaDestino.exists()) {
            carpetaDestino.mkdirs();
        }

        File archivoDestino = new File(carpetaDestino, nombre + extension);
        try {
            //Copia el archivo que le pasamos al nuevo creado en la carpeta
            Files.copy(archivo.toPath(), archivoDestino.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void exportarDatos(Libro l) {
        ArchivoGrabacion datos = new ArchivoGrabacion("VENTAS.csv");
        datos.grabarLinea("Fecha, Cliente, Factura, Cantidad, Precio, Importe");
        Venta[] listaVentasDelLibro = this.obtenerVentasLibro(l);
        for (Venta v : listaVentasDelLibro) {
            String linea = v.getFecha() + "," + v.getNombreCliente() + "," + v.getNumFactura() + "," + v.getLibrosSeleccionados().get(l).getCantidad() + "," + l.getPrecioDeVenta() + "," + v.getLibrosSeleccionados().get(l).getCantidad() * l.getPrecioDeVenta();
            datos.grabarLinea(linea);
        }

        datos.cerrar();
    }

    public void agregarALista(Libro unLibro, List unaLista) {
        unaLista.add(unLibro);
        setChanged();
        notifyObservers();
    }

    public ArrayList<Libro> filtrarResultados(String genero, String titulo, String autor) {
        ArrayList<Libro> resultados = new ArrayList<>();
        if (genero.isEmpty() || titulo.isEmpty() || autor.isEmpty()) {
            for (Libro libro : this.getListaLibros().values()) {
                boolean coincideGenero = genero.isEmpty() || libro.getGenero().getNombre().equalsIgnoreCase(genero);
                boolean coincideTitulo = titulo.isEmpty() || libro.getTitulo().toLowerCase().contains(titulo.toLowerCase());
                boolean coincideAutor = autor.isEmpty() || libro.getAutor().getNombre().equalsIgnoreCase(autor);

                if (coincideGenero && coincideTitulo && coincideAutor) {
                    this.agregarALista(libro, resultados);
                }
            }
        }
        return resultados;
    }

    //Metodos de Ventas
    public HashMap<Integer, Venta> getListaVentas() {
        return this.listaVentas;
    }

    public void setListaVentas(HashMap<Integer, Venta> listaVentas) {
        this.listaVentas = listaVentas;
    }

    public void agregarVenta(Venta v) {
        this.getListaVentas().put(numFactura, v);
        efectuarVenta(v);
        numFactura++;
        setChanged();
        notifyObservers();
    }

    public void anularVenta(int numeroFactura) {
        reingresarLibros(this.getListaVentas().get(numeroFactura));
        this.getListaVentas().remove(numeroFactura);
        setChanged();
        notifyObservers();
    }

    public void reingresarLibros(Venta v) {
        for (Libro l : v.getLibrosSeleccionados().keySet()) {

            Libro lib = this.getListaLibros().get(l.getIsbn());
            lib.setCantidadEjemplares(lib.getCantidadEjemplares() + v.getLibrosSeleccionados().get(l).getCantidad());
            this.getListaLibros().put(lib.getIsbn(), lib);
        }
    }

    public void efectuarVenta(Venta v) {
        for (Libro l : v.getLibrosSeleccionados().keySet()) {

            Libro lib = this.getListaLibros().get(l.getIsbn());
            lib.setCantidadEjemplares(lib.getCantidadEjemplares() - v.getLibrosSeleccionados().get(l).getCantidad());
            this.getListaLibros().put(lib.getIsbn(), lib);
        }
    }

    public Venta[] obtenerVentasLibro(Libro l) {
        ArrayList<Venta> aux = new ArrayList<Venta>();
        for (Venta v : this.getListaVentas().values()) {
            if (v.getLibrosSeleccionados().containsKey(l)) {
                aux.add(v);
            } else {
            }
        }

        Venta[] res = new Venta[aux.size()];
        res = aux.toArray(res);
        return res;
    }

    //Metodos del Sistema
    public static void guardarSistema(Sistema sistema, String filePath) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(sistema);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Sistema cargarSistema(String filePath) {
        Sistema sistema = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            sistema = (Sistema) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "No se han encontrado datos, se ha creado un nuevo sistema.");
            sistema = new Sistema();  // Crear un sistema nuevo si no se encuentra el archivo
        }
        return sistema;
    }

    public static Sistema iniciarSistema(String file) {
        Sistema sistema;
        String[] options = {"Sí", "No"};
        int choice = JOptionPane.showOptionDialog(
                null,
                "¿Quieres cargar datos desde un archivo?",
                "Cargar Datos",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );

        if (choice == JOptionPane.YES_OPTION) {
            sistema = Sistema.cargarSistema(file);
        } else {
            sistema = new Sistema(); // Iniciar el sistema desde cero
            JOptionPane.showMessageDialog(null, "Se ha creado un nuevo sistema.");

            // Eliminar la carpeta imagenes si existe 
            File carpetaImagenes = new File("imagenes");
            if (carpetaImagenes.exists()) {
                borrarArchivo(carpetaImagenes);
            }
            File datosVenta = new File("VENTAS.csv");
            if (datosVenta.exists()) {
                borrarArchivo(datosVenta);
            }
        }
        return sistema;
    }

    private static void borrarArchivo(File archivo) {
        //Si el archivo que le pasamos es un directorio
        if (archivo.isDirectory()) {
            //Obtiene todos los elementos del mismo y los borra
            File[] archivos = archivo.listFiles();
            if (archivos != null) {
                for (File a : archivos) {
                    borrarArchivo(a);
                }
            }
        }
        //Borra el archivo o directorio que le pasamos
        archivo.delete();
    }

}
