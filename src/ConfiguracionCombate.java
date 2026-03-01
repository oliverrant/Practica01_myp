import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Clase utilitaria que se encarga de construir y configurar un {@link Combate}.
 *
 * <p>Instancia los tres personajes del juego (Korby, MeganMan y Dittuu),
 * crea los cuatro espectadores simulados con sus personajes favoritos,
 * y ensambla el {@link SujetoConcreto} y el {@link GestorCombate} necesarios
 * para iniciar la simulación.</p>
 */
public class ConfiguracionCombate {

    /**
     * Crea y devuelve un {@link Combate} completamente configurado.
     *
     * Los personajes creados son Korby, MeganMan y Dittuu, cada uno con
     * 100 puntos de vida y su propio catálogo de habilidades. Se registran
     * cuatro espectadores simulados con identificadores y personajes favoritos
     * predefinidos.
     *

     */
    public static Combate crearCombate(Random random) {
        Korby korby = new Korby();
        MeganMan meganMan = new MeganMan();
        Dittuu dittuu = new Dittuu();

        List<Personaje> personajes = new ArrayList<>();
        personajes.add(korby);
        personajes.add(meganMan);
        personajes.add(dittuu);

        List<Observador> observadores = new ArrayList<>();
        observadores.add(new ObservadorConcreto("espectador123", korby));
        observadores.add(new ObservadorConcreto("espectador456", meganMan));
        observadores.add(new ObservadorConcreto("gamer99", dittuu));
        observadores.add(new ObservadorConcreto("jugador007", korby));

        SujetoConcreto sujetoConcreto = new SujetoConcreto(observadores);
        GestorCombate gestorCombate = new GestorCombate(personajes, random);

        return new Combate(sujetoConcreto, gestorCombate);
    }
}
