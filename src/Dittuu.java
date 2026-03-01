/**
 * Representa al personaje Dittuu, un chinpokomon capaz de transformarse
 * en cualquier otro chinpokomon que vea, copiando sus características.
 */
public class Dittuu extends Personaje {

    /**
     * Construye a Dittuu con 100 puntos de vida y su catálogo de habilidades propio.
     */
    public Dittuu() {
        super("Dittuu", 100, new CatalogoDittuu());
    }
}
