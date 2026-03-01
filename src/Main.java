import java.util.Random;

/**
 * Clase principal que sirve como punto de entrada de la simulación de combate.
 *

 */
public class Main {

    /**
     * Método principal. Selecciona al azar uno de los tres casos de prueba
     * y ejecuta el combate asociado.
     *
     */
    public static void main(String[] args) {
        Random selector = new Random();
        int caso = selector.nextInt(3);

        if (caso == 0) ejecutarCombate(new Random(111));
        else if (caso == 1) ejecutarCombate(new Random(222));
        else ejecutarCombate(new Random(333));
    }

    /**
     * Crea y ejecuta un combate usando el generador de números aleatorios indicado.
     *
     */
    static void ejecutarCombate(Random random) {
        Combate combate = ConfiguracionCombate.crearCombate(random);
        combate.iniciar();
    }
}
