/**
 * Clase que representa el desarrollo de un combate entre personajes.
*/
public class Combate {

    /** Sujeto observable que notifica a los espectadores sobre los eventos del combate. */
    private Sujeto sujeto;

    /** Gestor que maneja la lógica de rondas, ataques y estado de los personajes. */
    private GestorCombate gestorCombate;

    /**
     * Construye un nuevo combate con el sujeto y el gestor indicados.
     */
    public Combate(Sujeto sujeto, GestorCombate gestorCombate) {
        this.sujeto = sujeto;
        this.gestorCombate = gestorCombate;
    }

    /**
     * Inicia y ejecuta el combate completo.
     */
    public void iniciar() {
        sujeto.notificarObservadores("¡El combate ha comenzado!");

        while (gestorCombate.personajesVivos() > 1) {
            String eventos = gestorCombate.ejecutarRonda();
            sujeto.notificarObservadores(eventos);
        }

        Personaje ganador = gestorCombate.obtenerGanador();
        if (ganador != null) {
            sujeto.notificarObservadores("¡El combate ha terminado! El ganador es " + ganador.getNombre());
            sujeto.cerrar(ganador.getNombre());
        } else {
            sujeto.notificarObservadores("¡El combate ha terminado en empate!");
            sujeto.cerrar("ninguno");
        }
    }
}
