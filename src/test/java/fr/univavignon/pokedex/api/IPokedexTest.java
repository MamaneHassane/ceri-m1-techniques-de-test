package fr.univavignon.pokedex.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

public class IPokedexTest {

    @Test
    void testSize() {
        IPokedex mockPokedex = IPokedexTestHelper.createMockIPokedex();

        when(mockPokedex.size()).thenReturn(5);

        int size = mockPokedex.size();

        assertEquals(5, size);
    }

    @Test
    void testAddPokemon() {
        IPokedex mockPokedex = IPokedexTestHelper.createMockIPokedex();

        // Crée une instance de Pokemon avec les arguments nécessaires
        Pokemon pokemon = new Pokemon(1, "Pikachu", 55, 40, 35, 500, 35, 1000, 50, 0.9);

        when(mockPokedex.addPokemon(pokemon)).thenReturn(0);

        int index = mockPokedex.addPokemon(pokemon);

        assertEquals(0, index);
    }

    @Test
    void testGetPokemon() throws PokedexException {
        IPokedex mockPokedex = IPokedexTestHelper.createMockIPokedex();

        int index = 1;
        String name = "Pikachu";
        int attack = 55;
        int defense = 40;
        int stamina = 35;
        int cp = 500;
        int hp = 35;
        int dust = 1000;
        int candy = 50;
        double iv = 0.9;

        Pokemon pokemon = new Pokemon(index, name, attack, defense, stamina, cp, hp, dust, candy, iv);

        when(mockPokedex.getPokemon(index)).thenReturn(pokemon);

        Pokemon retrievedPokemon = mockPokedex.getPokemon(index);

        assertEquals(pokemon, retrievedPokemon);
    }

    @Test
    void testGetPokemonThrowsException() throws PokedexException {
        IPokedex mockPokedex = IPokedexTestHelper.createMockIPokedex();

        when(mockPokedex.getPokemon(999)).thenThrow(new PokedexException("Invalid Pokemon ID"));

        assertThrows(PokedexException.class, () -> mockPokedex.getPokemon(999),
                "Une exception devrait être levée pour un identifiant de Pokémon invalide.");
    }

    @Test
    void testGetPokemons() {
        IPokedex mockPokedex = IPokedexTestHelper.createMockIPokedex();

        // Crée une instance de Pokemon avec les arguments nécessaires
        Pokemon pokemon = new Pokemon(1, "Pikachu", 55, 40, 35, 500, 35, 1000, 50, 0.9);
        when(mockPokedex.getPokemons()).thenReturn(Collections.singletonList(pokemon));

        List<Pokemon> pokemons = mockPokedex.getPokemons();

        assertEquals(1, pokemons.size());
        assertEquals(pokemon, pokemons.get(0));
    }

    @Test
    void testGetPokemonsWithOrder() {
        IPokedex mockPokedex = IPokedexTestHelper.createMockIPokedex();

        // Crée des instances de Pokemon avec les arguments nécessaires
        Pokemon pokemon1 = new Pokemon(1, "Pikachu", 55, 40, 35, 500, 35, 1000, 50, 0.9);
        Pokemon pokemon2 = new Pokemon(2, "Bulbasaur", 49, 49, 45, 600, 45, 2000, 75, 0.8);

        when(mockPokedex.getPokemons(PokemonComparators.NAME)).thenReturn(List.of(pokemon1, pokemon2));

        List<Pokemon> pokemons = mockPokedex.getPokemons(PokemonComparators.NAME);

        assertEquals(2, pokemons.size());
        assertEquals(pokemon1, pokemons.get(0));
        assertEquals(pokemon2, pokemons.get(1));
    }
}
