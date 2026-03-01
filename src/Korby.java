/**
 * Representa al personaje Korby, famoso por replicar las habilidades
 * de los enemigos que consume.
 */
public class Korby extends Personaje {

    /**
     * Construye a Korby con 100 puntos de vida y su catálogo de habilidades propio.
     */
    public Korby() {
        super("Korby", 100, new CatalogoKorby());
    }
}
