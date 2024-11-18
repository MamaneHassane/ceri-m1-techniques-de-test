package fr.univavignon.pokedex.api;

import static org.mockito.Mockito.mock;

public class IPokemonFactoryTestHelper {

    public static IPokemonFactory createMockIPokemonFactory() {
        return mock(IPokemonFactory.class);
    }

    // public static IPokemonFactory createRealIPokemonFactory() {
    //     return new PokemonFactory();
    // }
}
