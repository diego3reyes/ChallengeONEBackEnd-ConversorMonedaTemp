package Proyectos_JAVA.ConversorMonedaTemp;

import javax.swing.JOptionPane;

public class EleccionMonTemp {
    public String Eleccion() {
        String[] possibleValues = { "Conversor de Moneda", "Conversor de Temperatura" };
        Object selectedValue = JOptionPane.showInputDialog(null,
                "Seleccione una opcion de conversion", "Menu",
                JOptionPane.QUESTION_MESSAGE, null,
                possibleValues, possibleValues[0]);
        return (String) selectedValue;
    }
}
