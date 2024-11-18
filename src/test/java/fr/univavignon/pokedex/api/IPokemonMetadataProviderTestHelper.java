package fr.univavignon.pokedex.api;
import static org.mockito.Mockito.mock;


public class IPokemonMetadataProviderTestHelper {
    public static IPokemonMetadataProvider createMockIPokemonMetadataProvider() {
        return mock(IPokemonMetadataProvider.class);
    }

    // public static IPokemonMetadataProvider createRealIPokemonMetadataProvider() {
    //     return new PokemonMetadataProvider();
    // }
}
