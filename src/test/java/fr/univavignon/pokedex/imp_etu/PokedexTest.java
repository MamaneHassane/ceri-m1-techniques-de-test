package fr.univavignon.pokedex.imp_etu;

import fr.univavignon.pokedex.api.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

class PokedexTest {

    private Pokedex pokedex;
    private IPokemonMetadataProvider metadataProvider;
    private IPokemonFactory pokemonFactory;

    @BeforeEach
    void setUp() {
        metadataProvider = new PokemonMetadataProvider();
        pokemonFactory = new PokemonFactory();
        pokedex = new Pokedex(metadataProvider, pokemonFactory);
    }

    @Test
    void testSize() {
        assertEquals(0, pokedex.size(), "La taille initiale du Pokedex devrait être 0.");
        pokedex.addPokemon(pokemonFactory.createPokemon(0, 100, 100, 500, 50));
        assertEquals(1, pokedex.size(), "La taille devrait être 1 après l'ajout d'un Pokémon.");
    }

    @Test
    void testAddPokemon() {
        Pokemon pokemon = pokemonFactory.createPokemon(0, 100, 100, 500, 50);
        int index = pokedex.addPokemon(pokemon);
        assertEquals(0, index, "Le premier Pokémon ajouté devrait avoir l'index 0.");
        assertEquals(1, pokedex.size(), "La taille du Pokedex devrait être mise à jour après l'ajout.");
    }

    @Test
    void testGetPokemon() throws PokedexException {
        Pokemon pokemon = pokemonFactory.createPokemon(0, 100, 100, 500, 50);
        int index = pokedex.addPokemon(pokemon);
        Pokemon retrieved = pokedex.getPokemon(index);
        assertEquals(pokemon, retrieved, "Le Pokémon récupéré devrait correspondre à celui ajouté.");
    }

    @Test
    void testGetPokemonInvalidId() {
        assertThrows(PokedexException.class, () -> pokedex.getPokemon(0),
                "Demander un Pokémon avec un ID invalide devrait lever une exception.");
    }

    @Test
    void testGetPokemons() {
        Pokemon pokemon1 = pokemonFactory.createPokemon(0, 100, 100, 500, 50);
        Pokemon pokemon2 = pokemonFactory.createPokemon(1, 200, 200, 600, 60);
        pokedex.addPokemon(pokemon1);
        pokedex.addPokemon(pokemon2);

        List<Pokemon> pokemons = pokedex.getPokemons();
        assertEquals(Arrays.asList(pokemon1, pokemon2), pokemons,
                "La liste des Pokémon devrait contenir les Pokémon ajoutés.");
    }

    @Test
    void testGetPokemonsWithOrder() {
        Pokemon pokemon1 = pokemonFactory.createPokemon(0, 100, 100, 500, 50);
        Pokemon pokemon2 = pokemonFactory.createPokemon(1, 200, 200, 600, 60);
        pokedex.addPokemon(pokemon1);
        pokedex.addPokemon(pokemon2);

        List<Pokemon> sortedByCp = pokedex.getPokemons(PokemonComparators.CP);
        assertEquals(Arrays.asList(pokemon1, pokemon2), sortedByCp,
                "Les Pokémon devraient être triés par CP dans l'ordre croissant.");

        List<Pokemon> sortedByIndex = pokedex.getPokemons(PokemonComparators.INDEX);
        assertEquals(Arrays.asList(pokemon1, pokemon2), sortedByIndex,
                "Les Pokémon devraient être triés par index dans l'ordre croissant.");
    }
}
