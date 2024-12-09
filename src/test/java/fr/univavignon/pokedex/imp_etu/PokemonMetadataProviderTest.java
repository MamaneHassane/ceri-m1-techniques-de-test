package fr.univavignon.pokedex.imp_etu;

import fr.univavignon.pokedex.api.IPokemonMetadataProvider;
import fr.univavignon.pokedex.api.PokedexException;
import fr.univavignon.pokedex.api.PokemonMetadata;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PokemonMetadataProviderTest {

    @Test
    void testGetPokemonMetadata() throws PokedexException {
        // Utiliser l'implémentation réelle de IPokemonMetadataProvider
        IPokemonMetadataProvider metadataProvider = new PokemonMetadataProvider();

        // Index d'un Pokémon valide pour le test
        int index = 1; // Correspond à "Ivysaur" par exemple

        // Métadonnées attendues pour le Pokémon
        String expectedName = "Ivysaur"; // Nom attendu pour l'index 1
        int expectedAttack = 151;       // Attaque
        int expectedDefense = 143;      // Défense
        int expectedStamina = 120;      // Endurance

        // Appeler la méthode getPokemonMetadata
        PokemonMetadata actualMetadata = metadataProvider.getPokemonMetadata(index);

        // Vérifier les attributs des métadonnées récupérées
        assertEquals(index, actualMetadata.getIndex(), "L'index doit correspondre.");
        assertEquals(expectedName, actualMetadata.getName(), "Le nom doit correspondre.");
        assertEquals(expectedAttack, actualMetadata.getAttack(), "L'attaque doit correspondre.");
        assertEquals(expectedDefense, actualMetadata.getDefense(), "La défense doit correspondre.");
        assertEquals(expectedStamina, actualMetadata.getStamina(), "L'endurance doit correspondre.");
    }

    @Test
    void testGetPokemonMetadataThrowsException() {
        // Utiliser l'implémentation réelle de IPokemonMetadataProvider
        IPokemonMetadataProvider metadataProvider = new PokemonMetadataProvider();

        // Index invalide pour provoquer une exception
        int invalidIndex = 999;

        // Vérifier qu'une exception est levée pour un index invalide
        assertThrows(
                PokedexException.class,
                () -> metadataProvider.getPokemonMetadata(invalidIndex),
                "Une PokedexException devrait être levée pour un index invalide."
        );
    }
}
