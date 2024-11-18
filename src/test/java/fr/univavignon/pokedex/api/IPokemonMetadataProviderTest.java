package fr.univavignon.pokedex.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

public class IPokemonMetadataProviderTest {

    @Test
    void testGetPokemonMetadata() throws PokedexException {
        IPokemonMetadataProvider mockMetadataProvider = IPokemonMetadataProviderTestHelper.createMockIPokemonMetadataProvider();

        // Définir l'index du Pokémon pour le test
        int index = 1;

        // Créer une instance de PokémonMetadata attendue
        PokemonMetadata expectedMetadata = new PokemonMetadata(index, "Pikachu", 55, 40, 35);

        // Définir le comportement du mock
        when(mockMetadataProvider.getPokemonMetadata(index)).thenReturn(expectedMetadata);

        // Appeler la méthode getPokemonMetadata
        PokemonMetadata actualMetadata = mockMetadataProvider.getPokemonMetadata(index);

        // Vérifier que la métadonnée récupérée est celle attendue
        assertEquals(expectedMetadata, actualMetadata);
    }

    @Test
    void testGetPokemonMetadataThrowsException() throws PokedexException {
        IPokemonMetadataProvider mockMetadataProvider = IPokemonMetadataProviderTestHelper.createMockIPokemonMetadataProvider();

        // Définir un index invalide pour provoquer une exception
        int invalidIndex = 999;

        // Définir le comportement du mock pour lever une exception
        when(mockMetadataProvider.getPokemonMetadata(invalidIndex)).thenThrow(new PokedexException("Invalid Pokemon index"));

        // Vérifier que l'exception est levée
        assertThrows(PokedexException.class, () -> mockMetadataProvider.getPokemonMetadata(invalidIndex),
                "Une exception devrait être levée pour un index de Pokémon invalide.");
    }
}
