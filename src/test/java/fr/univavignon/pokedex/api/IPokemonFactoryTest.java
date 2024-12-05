package fr.univavignon.pokedex.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import fr.univavignon.pokedex.imp.RocketPokemonFactory;
import org.junit.jupiter.api.Test;

public class IPokemonFactoryTest {

    @Test
    void testCreatePokemon() {
        // IPokemonFactory mockPokemonFactory = IPokemonFactoryTestHelper.createMockIPokemonFactory();

        IPokemonFactory mockPokemonFactory = new RocketPokemonFactory();

        // Crée une instance de Pokemon avec les arguments nécessaires
        int index = 1;
        int cp = 500;
        int hp = 35;
        int dust = 1000;
        int candy = 50;
        double iv = 0.9;

        // Crée l'objet Pokemon attendu
        Pokemon expectedPokemon = new Pokemon(index, "Pikachu", 55, 40, 35, cp, hp, dust, candy, iv);

        // Définir le comportement du mock
        when(mockPokemonFactory.createPokemon(index, cp, hp, dust, candy)).thenReturn(expectedPokemon);

        // Appeler la méthode createPokemon
        Pokemon actualPokemon = mockPokemonFactory.createPokemon(index, cp, hp, dust, candy);

        // Vérifier que le Pokemon créé est celui attendu
        assertEquals(expectedPokemon, actualPokemon);
    }
}
