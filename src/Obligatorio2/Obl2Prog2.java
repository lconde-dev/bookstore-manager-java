//Paulina Vazquez - 325917
//Lucas Conde - 340100
package Obligatorio2;

import Interfaz.VtnMenu;
import Modelo.Sistema;
import javax.swing.JOptionPane;

public class Obl2Prog2 {

    private static final String FILE_PATH = "sistema.dat";

    public static void main(String[] args) {
        // Iniciar el sistema utilizando el método iniciarSistema
        Sistema sistema = Sistema.iniciarSistema(FILE_PATH);

        // Crear y mostrar la ventana del menú
        VtnMenu menu = new VtnMenu(sistema);
        menu.setVisible(true);

        
        // Añadir hook para guardar los datos al cerrar la aplicación
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            Sistema.guardarSistema(sistema, FILE_PATH);
        }));
    }
}
