package Proyectos_JAVA.ConversorMonedaTemp;

/**
 * @version 1.0
 * @author Diego Reyes
 * 
 */

import javax.swing.JOptionPane;

import Proyectos_JAVA.ConversorMonedaTemp.Temperatura.DesicionTemp;
import Proyectos_JAVA.ConversorMonedaTemp.moneda.Moneda;

public class Main {
    public static void main(String[] args) {
        String option;
        EleccionMonTemp start = new EleccionMonTemp();
        IngresoValidacion ingre = new IngresoValidacion();

        while (true) {

            option = start.Eleccion();

            switch (option) {
                case "Conversor de Moneda":
                    Moneda mone = new Moneda();
                    mone.SeleccionConvMon(ingre.IngresoNum(option));
                    break;
                case "Conversor de Temperatura":
                    DesicionTemp temp = new DesicionTemp();
                    temp.SeleccionConvTemp(ingre.IngresoNum(option));
                    break;
                default:
                    break;
            }
            int next = JOptionPane.showConfirmDialog(null, "¿Desea continuar?", "Selecciona una opción",
                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (next == 1 || next == 2) {
                JOptionPane.showMessageDialog(null, "Programa finalizado!", "Adios!", 1);
                break;
            }
        }
    }

}