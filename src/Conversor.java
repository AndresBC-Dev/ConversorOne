import java.util.HashMap;
import java.util.Map;

public class Conversor {

    private Map<String, Double> tasasDeCambio;

    public Conversor() {
        tasasDeCambio = new HashMap<>();
        tasasDeCambio.put("USD", 1.0);
        tasasDeCambio.put("COP", 4000.0);
        tasasDeCambio.put("EUR", 0.85);
    }



    public double convertir(String monedaActual, String monedaDestino, double cantidad) {
        double tasaActual = tasasDeCambio.get(monedaActual);
        double tasaDestino = tasasDeCambio.get(monedaDestino);
        double cantidadEnUSD = cantidad / tasaActual;
        return cantidadEnUSD * tasaDestino;
    }
}

