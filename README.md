Equipo: Funciona en mi maquina

Integrantes: 
- Valeria Camacho Hernández/ 322007273
- Oliver Rodrigo Antonio Hernández/422066521
- Christian David Gutiérrez Rangel

Para el Patrón Strategy decidimos encapsular el comportamiento con la interfaz
ComportamientoHabilidad con sus 10 implementaciones (9 poderes y el ComportamientoBase), esta sería nuestra estrategia y nuestras estrategias concretas respectivamente. El contexto es la clase Personaje, que mantiene una referencia al comportamiento actual y delega en él los métodos atacar() y defender(). Decidimos hacerlo así porque permite cambiar el comportamiento de un personaje en tiempo de ejecución sin modificar su clase, simplemente intercambiando el objeto ComportamientoHabilidad mediante consumirPoder(). De esta manera si quisieramos añadir un nuevo poder no es necesario tocar ninguna clase existente, solo crear una nueva clase que implemente la interfaz.

Para el Patrón Observer el sujeto es la interfaz Sujeto con su implementación SujetoConcreto, que mantiene la lista de observadores y los notifica. El observador es la interfaz Observador con su implementación ObservadorConcreto. Decidimos hacerlo de este modo porque desacopla completamente el combate de los espectadores. Combate no sabe nada sobre cómo los espectadores procesan la información, solo notifica eventos. De esta forma uno podría agregar o quitar espectadores sin tocar la lógica del combate.

Algunas otras decisiones que tomamos fueron incluir:

CatalogoHabilidades con 3 implementaciones, una para cada personaje, las creamos para encapsular qué poderes pertenecen a cada franquicia, evitando hardcodear esta restricción en cada subclase de Personaje, evitando así la rigidez.

GestorCombate se separó de Combate para que esta última no tuviera demasiadas responsabilidades. La clase Combate solo coordina, mientras que GestorCombate contiene toda la lógica de las rondas, los ataques y la selección de objetivos.

ConfiguracionCombate se creó para encapsular la creación de personajes y observadores, evitando que el Main tuviera que lidiar con esas listas directamente. También garantiza que los espectadores tengan referencias a los mismos objetos que pelean y no a copias.

Un único objeto Random pasado como parámetro en toda la Práctica, con este podemos garantizar tener casos de prueba reproducibles, pues mediante el uso de tres semillas controlamos la aleatoreidad. Y bastaría con la eliminación de estas tres para tener una infinidad de combates diferentes.

Para compilar haga:

```javac -d bin src/*.java```

Para ejecutar haga:

```java -cp bin Main```