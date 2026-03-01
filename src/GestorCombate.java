import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Clase que gestiona la lógica interna de un combate entre personajes.
 */
public class GestorCombate {

    /** Lista de personajes que participan en el combate. */
    private List<Personaje> participantes;

    /** Generador de números aleatorios para decisiones de combate. */
    private Random random;

    /** Contador de rondas ejecutadas. */
    private int numeroRonda = 0;

    /**
     * Construye un nuevo gestor de combate con los participantes indicados.
     */
    public GestorCombate(List<Personaje> participantes, Random random) {
        this.participantes = participantes;
        this.random = random;
    }

    /**
     * Ejecuta una ronda completa del combate.
     * En cada ronda, cada personaje vivo tiene un 30% de probabilidad de
     * adquirir aleatoriamente un nuevo poder de su catálogo. Luego, cada
     * personaje vivo ataca a un objetivo aleatorio entre los demás vivos.
     *
     */
    public String ejecutarRonda() {
        numeroRonda++;
        StringBuilder eventos = new StringBuilder();
        eventos.append("--- Ronda ").append(numeroRonda).append(" ---\n");

        for (Personaje p : participantes) {
            if (p.estaVivo() && random.nextInt(100) < 30) {
                p.adquirirPoder(random);
                eventos.append(p.getNombre())
                       .append(" ha consumido un poder y ahora usa ")
                       .append(p.getComportamiento().getNombre())
                       .append("\n");
            }
        }

        for (Personaje atacante : participantes) {
            if (atacante.estaVivo()) {
                Personaje objetivo = obtenerObjetivoAleatorio(atacante);
                if (objetivo != null) {
                    eventos.append(ejecutarAtaque(atacante, objetivo));
                }
            }
        }

        return eventos.toString();
    }

    /**
     * Ejecuta el ataque de un personaje contra otro y calcula el daño resultante.
     *
     * El daño final nunca es negativo: si la defensa supera al ataque,
     * el daño aplicado es 0.
     *
     */
    private String ejecutarAtaque(Personaje atacante, Personaje objetivo) {
        int danioFinal = Math.max(0, atacante.getComportamiento().getDanio() - objetivo.getComportamiento().getDefensa());
        objetivo.recibirDanio(danioFinal);

        return atacante.atacar(objetivo.getNombre()) + "\n"
             + objetivo.defender() + "\n"
             + objetivo.getNombre() + " recibe " + danioFinal + " puntos de daño. "
             + "Le quedan " + objetivo.getPuntosVida() + " puntos de vida.\n";
    }

    /**
     * Selecciona aleatoriamente un personaje vivo diferente al atacante.
     */
    private Personaje obtenerObjetivoAleatorio(Personaje atacante) {
        List<Personaje> objetivos = new ArrayList<>();
        for (Personaje p : participantes) {
            if (p != atacante && p.estaVivo()) {
                objetivos.add(p);
            }
        }
        if (objetivos.isEmpty()) return null;
        return objetivos.get(random.nextInt(objetivos.size()));
    }

    /**
     * Cuenta cuántos personajes siguen con vida en el combate.
     *
     * @return número de personajes vivos
     */
    public int personajesVivos() {
        int count = 0;
        for (Personaje p : participantes) {
            if (p.estaVivo()) count++;
        }
        return count;
    }

    /**
     * Devuelve el personaje ganador del combate, es decir, el único que sigue vivo.
     */
    public Personaje obtenerGanador() {
        for (Personaje p : participantes) {
            if (p.estaVivo()) return p;
        }
        return null;
    }
}
