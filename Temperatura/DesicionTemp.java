package Proyectos_JAVA.ConversorMonedaTemp.Temperatura;

import java.math.*;

import javax.swing.JOptionPane;

public class DesicionTemp {

    public String SelectTemp() {
        String[] convMon = { "Celsius a Kelvin", "Celsius a Fahrenheit", "Kelvin a Celsius",
                "Kelvin a Fahrenheit", "Fahrenheit a Celsius", "Fahrenheit a Kelvin" };

        String selectedValue = (String) JOptionPane.showInputDialog(null,
                "Seleccione una opcion de conversion", "Menu",
                JOptionPane.QUESTION_MESSAGE, null,
                convMon, convMon[0]);
        return selectedValue;
    }

    public void SeleccionConvTemp(double valor) {
        ConverTemp temp = new ConverTemp();
        double resultado = 0;
        String selecTemp = SelectTemp();
        String signo = "\u00B0C";

        switch (selecTemp) {
            case "Celsius a Kelvin":
                resultado = Aprox(temp.CelsKel(valor));
                signo = "K";
                break;
            case "Celsius a Fahrenheit":
                resultado = Aprox(temp.CelFar(valor));
                signo = "\u00B0F";
                break;
            case "Kelvin a Celsius":
                resultado = Aprox(temp.KelCel(valor));
                signo = "\u00B0C";
                break;
            case "Kelvin a Fahrenheit":
                resultado = Aprox(temp.KelFar(valor));
                signo = "\u00B0F";
                break;
            case "Fahrenheit a Celsius":
                resultado = Aprox(temp.FarCel(valor));
                signo = "\u00B0C";
                break;
            case "Fahrenheit a Kelvin":
                resultado = Aprox(temp.FarKel(valor));
                signo = "K";
                break;
            default:
                break;
        }
        JOptionPane.showMessageDialog(null,
                "Convertir " + selecTemp + "\nEl resultado es " + resultado + " " + signo, "Resultado", 1);
    }

    public double Aprox(double valor) {
        BigDecimal big = new BigDecimal(valor);
        return big.setScale(2, RoundingMode.FLOOR).doubleValue();
    }

}
