package fr.univavignon.pokedex.api;

import static org.mockito.Mockito.mock;

/**
 * Classe de factory pour créer des instances d'IPokedex et des mocks.
 */
public class PokedexFactoryTestHelper {

    /**
     * Crée un mock de IPokedex.
     *
     * @return Une instance mock de IPokedex.
     */
    public static IPokedex createMockIPokedex() {
        return mock(IPokedex.class);
    }

    /*
     * Crée une instance réelle de IPokedex en utilisant le metadataProvider et le pokemonFactory fournis.
     public static IPokedex createRealIPokedex(){

     }
     *
     */

}
