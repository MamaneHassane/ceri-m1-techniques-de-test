package fr.univavignon.pokedex.imp_etu;

import fr.univavignon.pokedex.api.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PokedexFactoryTest {

    private IPokedexFactory pokedexFactory;
    private IPokedex pokedex;

    @BeforeEach
    void setUp() {
        pokedexFactory = new PokedexFactory();
        IPokemonMetadataProvider metadataProvider = new PokemonMetadataProvider();
        IPokemonFactory pokemonFactory = new PokemonFactory();
        pokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);
    }

    @Test
    void testSize() {
        // Vérifie qu'un pokedex initialement vide retourne une taille de 0
        assertEquals(0, pokedex.size(), "La taille initiale du pokedex doit être 0.");

        // Ajoute un Pokémon et vérifie que la taille est mise à jour
        Pokemon pokemon = new Pokemon(0, "Bulbasaur", 126, 126, 90, 613, 64, 4000, 4, 0.56);
        pokedex.addPokemon(pokemon);
        assertEquals(1, pokedex.size(), "La taille du pokedex doit être 1 après l'ajout d'un Pokémon.");
    }

    @Test
    void testAddPokemon() {
        // Ajoute un Pokémon et vérifie l'index retourné
        Pokemon pokemon = new Pokemon(0, "Bulbasaur", 126, 126, 90, 613, 64, 4000, 4, 0.56);
        int index = pokedex.addPokemon(pokemon);
        assertEquals(0, index, "Le premier Pokémon ajouté doit avoir l'index 0.");
    }

    @Test
    void testGetPokemon() throws PokedexException {
        // Ajoute un Pokémon
        Pokemon pokemon = new Pokemon(0, "Bulbasaur", 126, 126, 90, 613, 64, 4000, 4, 0.56);
        pokedex.addPokemon(pokemon);

        // Récupère le Pokémon par son index et vérifie les données
        Pokemon retrieved = pokedex.getPokemon(0);
        assertEquals(pokemon, retrieved, "Le Pokémon récupéré doit correspondre à celui ajouté.");
    }

    @Test
    void testGetPokemons() {
        // Ajoute deux Pokémon
        Pokemon pokemon1 = new Pokemon(0, "Bulbasaur", 126, 126, 90, 613, 64, 4000, 4, 0.56);
        Pokemon pokemon2 = new Pokemon(1, "Ivysaur", 156, 158, 120, 718, 123, 6000, 7, 1.0);
        pokedex.addPokemon(pokemon1);
        pokedex.addPokemon(pokemon2);

        // Récupère la liste des Pokémon et vérifie
        List<Pokemon> pokemons = pokedex.getPokemons();
        assertEquals(Arrays.asList(pokemon1, pokemon2), pokemons, "Les Pokémon récupérés doivent correspondre à ceux ajoutés.");
    }

    @Test
    void testGetPokemonsWithOrder() {
        // Ajoute deux Pokémon
        Pokemon pokemon1 = new Pokemon(0, "Bulbasaur", 126, 126, 90, 613, 64, 4000, 4, 0.56);
        Pokemon pokemon2 = new Pokemon(1, "Ivysaur", 156, 158, 120, 718, 123, 6000, 7, 1.0);
        pokedex.addPokemon(pokemon1);
        pokedex.addPokemon(pokemon2);

        // Crée un comparateur pour trier par CP
        Comparator<Pokemon> comparator = Comparator.comparingInt(Pokemon::getCp);

        // Récupère les Pokémon triés
        List<Pokemon> sortedPokemons = pokedex.getPokemons(comparator);

        // Vérifie l'ordre des Pokémon
        assertEquals(Arrays.asList(pokemon1, pokemon2), sortedPokemons, "Les Pokémon doivent être triés par CP.");
    }
}
