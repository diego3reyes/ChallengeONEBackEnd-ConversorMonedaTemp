package Proyectos_JAVA.ConversorMonedaTemp.moneda;

import java.net.*;
import java.util.*;

public class MonedaApi {

    // https://api.apilayer.com/exchangerates_data/convert?to="+pasar_a+"&from="+pasar_De+"&amount="+Cantidad_Dinero+"&apikey=yUxVXEpXohaDMG9CE0DyPtzd56bIJfQe");

    public double GetAPI(String cantidadDinero, String pasarDe, String pasarA) {

        double valorFinal = 0;

        try {
            System.out.println("Esperando");
            URL url = new URI("https://api.apilayer.com/exchangerates_data/convert?to=" + pasarA + "&from=" + pasarDe+ "&amount=" + cantidadDinero + "&apikey=yUxVXEpXohaDMG9CE0DyPtzd56bIJfQe").toURL();
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");
            conn.setRequestProperty("apikey", "yUxVXEpXohaDMG9CE0DyPtzd56bIJfQe");
            conn.connect();

            int resp = conn.getResponseCode();

            if(resp != 200){

                throw new RuntimeException("hola"+resp);

            }else{
                List<String> information_string = new ArrayList<String>();
                Scanner scanner = new Scanner(url.openStream());
                while(scanner.hasNext()){
                    information_string.add(scanner.nextLine());
                }
                scanner.close();

                String valor = (String) information_string.get(12);
                valor = valor.replaceAll("\"result\": ", "");
                valorFinal = Double.parseDouble(valor);
                System.out.println("El valor es: "+valorFinal);
            }
            conn.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return valorFinal;

    }
}
