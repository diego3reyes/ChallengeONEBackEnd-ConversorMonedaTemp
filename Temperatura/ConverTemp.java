package Proyectos_JAVA.ConversorMonedaTemp.Temperatura;

public class ConverTemp {

    public double CelsKel(double valor) {
        return valor + 273.15;
    }

    public double CelFar(double valor) {
        return (valor * 9 / 5) + 32;
    }

    public double KelCel(double valor) {
        return valor - 273.15;
    }

    public double KelFar(double valor) {
        return ((valor - 273.15) * 9 / 5) + 32;
    }

    public double FarCel(double valor) {
        return (valor - 32) * 5 / 9;
    }

    public double FarKel(double valor) {
        return ((valor - 32) * 5 / 9) + 273.15;
    }

}
