package Proyectos_JAVA.ConversorMonedaTemp.moneda;

import java.math.*;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class Moneda {

    public String SelectMone() {
        String[] convMon = { "Dolares a Euros", "Dolares a Libras Esterlinas",
                "Dolares a Yen Japones", "Dolares a Won Sur-Coreano", "Euros a Dolares",
                "Libras Esterlinas a Dolares", "Yen Japones a Dolares", "Won Sur-Coreano a Dolares" };

        String selectedValue = (String) JOptionPane.showInputDialog(null,
                "Seleccione una opcion de conversion", "Menu",
                JOptionPane.QUESTION_MESSAGE, null,
                convMon, convMon[0]);
        return selectedValue;
    }

    public void SeleccionConvMon(double valor) {
        DecimalFormat forma = new DecimalFormat("###,###.##");
        MonedaApi api = new MonedaApi();
        double resultado = 0;
        String selecMon = SelectMone();
        String moneda = "Dolar";
        String [] monedaApi = {String.valueOf(valor),"USD","EUR"};

        switch (selecMon) {
            case "Dolares a Euros":
                monedaApi[1] = "USD";
                monedaApi[2] = "EUR";
                moneda = "Euros";
                break;
            case "Dolares a Libras Esterlinas":
                monedaApi[1] = "USD";
                monedaApi[2] = "GBP";
                moneda = "Libras Esterlinas";
                break;
            case "Dolares a Yen Japones":
                monedaApi[1] = "USD";
                monedaApi[2] = "JPY";
                moneda = "Yenes";
                break;
            case "Dolares a Won Sur-Coreano":
                monedaApi[1] = "USD";
                monedaApi[2] = "KRW";
                moneda = "Wones";
                break;
            case "Euros a Dolares":
                monedaApi[1] = "EUR";
                monedaApi[2] = "USD";
                moneda = "Dolares";
                break;
            case "Libras Esterlinas a Dolares":
                monedaApi[1] = "GBP";
                monedaApi[2] = "USD";
                moneda = "Dolares";
                break;
            case "Yen Japones a Dolares":
                monedaApi[1] = "JPY";
                monedaApi[2] = "USD";
                moneda = "Dolares";
                break;
            case "Won Sur-Coreano a Dolares":
                monedaApi[1] = "KRW";
                monedaApi[2] = "USD";
                moneda = "Dolares";
                break;
            default:
                break;
        }
        resultado = api.GetAPI(monedaApi[0], monedaApi[1], monedaApi[2]);
        JOptionPane.showMessageDialog(null,
                "Usted quiere convertir $" + valor + " " + selecMon + "\nTienes $" + forma.format(resultado) + " " + moneda,
                "Resultado", 1);
    }

    public double Aprox(double valor) {
        BigDecimal big = new BigDecimal(valor);
        return big.setScale(2, RoundingMode.FLOOR).doubleValue();
    }

}
