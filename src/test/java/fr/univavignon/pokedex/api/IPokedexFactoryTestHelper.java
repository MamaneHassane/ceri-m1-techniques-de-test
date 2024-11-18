package fr.univavignon.pokedex.api;

import static org.mockito.Mockito.mock;

/**
 * Classe de factory pour créer des instances d'IPokedex et des mocks.
 */
public class IPokedexFactoryTestHelper {

    /**
     * Crée un mock de IPokedex.
     *
     * @return Une instance mock de IPokedex.
     */
    public static IPokedexFactory createMockIPokedexFactory() {
        return mock(IPokedexFactory.class);
    }

    /*
     * Crée une instance réelle de IPokedex en utilisant le metadataProvider et le pokemonFactory fournis.
     public static IPokedex createRealIPokedex(){

     }
     *
     */
}
