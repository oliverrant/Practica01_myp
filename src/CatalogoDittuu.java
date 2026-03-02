import java.util.List;

/**
 * Implementación del catálogo de habilidades para Dittuu.
 * 
 * Proporciona la lista de habilidades disponibles
 * que pueden ser utilizadas por los personajes.
 */

public class CatalogoDittuu implements CatalogoHabilidades {
   
    /**
     * Devuelve la lista de habilidades disponibles en este catálogo.
     *
     */
    @Override
    public List<ComportamientoHabilidad> getHabilidades() {
        return List.of(new ComportamientoBruja(), new ComportamientoFuego(), new ComportamientoZapato());
    }
    
}
