package refa;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GestorFutbol implements Comparable<GestorFutbol> {

    private static final Logger LOGGER = Logger.getLogger(GestorFutbol.class.getName());

    private String equipoNombre;
    private int puntos;
    private static int partidosTotales = 0;

    public GestorFutbol(String nombreEquipo) {
        this.equipoNombre = nombreEquipo;
        this.puntos = 0;
    }

    public GestorFutbol(GestorFutbol otro) {
        this.equipoNombre = otro.equipoNombre;
        this.puntos = otro.puntos;
    }

    public static void main(String[] args) {
        GestorFutbol equipoPrincipal = new GestorFutbol("Atlético Madrid");

        List<String> resultadosTemporada = Arrays.asList(
            "victoria local", "empate visitante", "derrota local",
            "victoria visitante!", "empate", "victoria!",
            "derrota", "empate local", "victoria local"
        );

        if (resultadosTemporada == null || resultadosTemporada.isEmpty()) {
            LOGGER.warning("No hay resultados para procesar.");
            return;
        }

        equipoPrincipal.procesarTemporada(resultadosTemporada);

        GestorFutbol otroEquipo = new GestorFutbol("Real Madrid");
        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.info(String.format("Comparación entre equipos: %d", equipoPrincipal.compareTo(otroEquipo)));
        }
    }

    public void procesarTemporada(List<String> resultados) {
        for (String resultado : resultados) {
            procesarResultado(resultado);
            procesarContexto(resultado);
            procesarLongitud(resultado);
            if (resultado.endsWith("!")) {
                LOGGER.info("¡Resultado enfatizado!");
            }
            LOGGER.info("----------------------");
        }
    }

    private void procesarResultado(String resultado) {
        if (resultado.startsWith("victoria")) {
            puntos += 3;
            if (LOGGER.isLoggable(Level.INFO)) {
                LOGGER.info(String.format("Victoria. Puntos acumulados: %d", puntos));
            }
        } else if (resultado.startsWith("empate")) {
            puntos += 1;
            if (LOGGER.isLoggable(Level.INFO)) {
                LOGGER.info(String.format("Empate. Puntos acumulados: %d", puntos));
            }
        } else if (resultado.startsWith("derrota") && LOGGER.isLoggable(Level.INFO)) {
            LOGGER.info(String.format("Derrota. Puntos acumulados: %d", puntos));
        }
    }

    private void procesarContexto(String resultado) {
        if (resultado.contains("local")) {
            LOGGER.info("Jugado como local.");
            if (resultado.length() > 10 && LOGGER.isLoggable(Level.INFO)) {
                LOGGER.info(String.format("Detalle adicional: %s", resultado));
            }
        } else if (resultado.contains("visitante")) {
            LOGGER.info("Jugado como visitante.");
            if (resultado.length() > 8 && LOGGER.isLoggable(Level.INFO)) {
                LOGGER.info(String.format("Comentario: %s", resultado));
            }
        }
    }

    private void procesarLongitud(String resultado) {
        switch (resultado.length()) {
            case 7:
                LOGGER.info("Resultado corto.");
                break;
            case 14:
                LOGGER.info("Resultado medio.");
                break;
            default:
                LOGGER.info("Resultado de longitud estándar.");
                break;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof GestorFutbol)) return false;
        GestorFutbol otro = (GestorFutbol) obj;
        return Objects.equals(this.equipoNombre, otro.equipoNombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(equipoNombre);
    }

    @Override
    public int compareTo(GestorFutbol otro) {
        if (this.equipoNombre == null || otro.equipoNombre == null) {
            return -1;
        }
        return this.equipoNombre.compareTo(otro.equipoNombre);
    }

    // Getters y setters
    public String getEquipoNombre() {
        return equipoNombre;
    }

    public void setEquipoNombre(String equipoNombre) {
        this.equipoNombre = equipoNombre;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public static int getPartidosTotales() {
        return partidosTotales;
    }

    public static void setPartidosTotales(int partidosTotales) {
        GestorFutbol.partidosTotales = partidosTotales;
    }
}
