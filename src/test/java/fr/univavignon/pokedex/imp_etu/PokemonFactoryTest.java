package fr.univavignon.pokedex.imp_etu;

import fr.univavignon.pokedex.api.IPokemonFactory;
import fr.univavignon.pokedex.api.Pokemon;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PokemonFactoryTest {

    @Test
    void testCreatePokemon() {
        // Utilise l'implémentation réelle de IPokemonFactory
        IPokemonFactory pokemonFactory = new PokemonFactory();

        // Données d'entrée
        int index = 1;
        int cp = 500;
        int hp = 60;
        int dust = 1000;
        int candy = 50;
        double iv = 5;

        // Données attendues pour le Pokémon créé
        Pokemon expectedPokemon = new Pokemon(index, "Pokemon "+index, 50, 50, 50, cp, hp, dust, candy, iv);

        // Appeler la méthode createPokemon
        Pokemon actualPokemon = pokemonFactory.createPokemon(index, cp, hp, dust, candy);

        // Vérifie les attributs du Pokémon créé
        assertEquals(expectedPokemon.getIndex(), actualPokemon.getIndex(), "Les index doivent être identiques.");
        assertEquals(expectedPokemon.getName(), actualPokemon.getName(), "Les noms doivent être identiques.");
        assertEquals(expectedPokemon.getAttack(), actualPokemon.getAttack(), "Les valeurs d'attaque doivent être identiques.");
        assertEquals(expectedPokemon.getDefense(), actualPokemon.getDefense(), "Les valeurs de défense doivent être identiques.");
        assertEquals(expectedPokemon.getStamina(), actualPokemon.getStamina(), "Les valeurs d'endurance doivent être identiques.");
        assertEquals(expectedPokemon.getCp(), actualPokemon.getCp(), "Les CP doivent être identiques.");
        assertEquals(expectedPokemon.getHp(), actualPokemon.getHp(), "Les HP doivent être identiques.");
        assertEquals(expectedPokemon.getDust(), actualPokemon.getDust(), "Les valeurs de poussière doivent être identiques.");
        assertEquals(expectedPokemon.getCandy(), actualPokemon.getCandy(), "Les valeurs de bonbons doivent être identiques.");
        assertEquals(expectedPokemon.getIv(), actualPokemon.getIv(), "Les valeurs d'IV doivent être identiques.");
    }
}