package fr.univavignon.pokedex.api;

import static org.mockito.Mockito.mock;

public class IPokemonTrainerFactoryTestHelper {

    public static IPokemonTrainerFactory createMockIPokemonTrainerFactory() {
        return mock(IPokemonTrainerFactory.class);
    }

    // public static IPokemonTrainerFactory createRealIPokemonTrainerFactory() {
    //     return new PokemonTrainerFactory();
    // }
}
