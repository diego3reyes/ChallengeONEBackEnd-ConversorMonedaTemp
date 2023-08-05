package Proyectos_JAVA.ConversorMonedaTemp;
/**
 * @author Diego Reyes
 * @version 1.0
 */
import javax.swing.JOptionPane;

public class IngresoValidacion {

    public double IngresoNum(String selec) {

        String valor = JOptionPane.showInputDialog(null, selec +
                "\nIngrese la cantidad que desea convertir:", null);
        while (!Validacion(valor)) {
            JOptionPane.showMessageDialog(null, "Datos no validos", "Error", 0);
            valor = JOptionPane.showInputDialog(null,
                    "Ingrese la cantidad que desea convertir", null);
        }
        return Double.parseDouble(valor);
    }

    public boolean Validacion(String valor1) {
        boolean valido = true;
        if (!valor1.matches("^[0-9]+(\\.[0-9]+){0,1}$")) {
            valido = false;
        }
        return valido;
    }

}
