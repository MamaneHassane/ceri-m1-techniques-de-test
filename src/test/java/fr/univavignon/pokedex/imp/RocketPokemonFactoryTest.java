package fr.univavignon.pokedex.imp;

import fr.univavignon.pokedex.api.IPokemonFactory;
import fr.univavignon.pokedex.api.Pokemon;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RocketPokemonFactoryTest {

    @Test
    void testCreatePokemonValidIndex() {
        // Création d'une instance de RocketPokemonFactory
        IPokemonFactory factory = new RocketPokemonFactory();

        // Données d'entrée pour un index valide
        int index = 1; // Bulbasaur
        int cp = 500;
        int hp = 50;
        int dust = 1000;
        int candy = 10;

        // Appel de la méthode createPokemon
        Pokemon pokemon = factory.createPokemon(index, cp, hp, dust, candy);

        // Vérifications
        assertEquals(index, pokemon.getIndex());
        assertEquals("Bulbasaur", pokemon.getName());
        assertTrue(pokemon.getAttack() >= 0 && pokemon.getAttack() <= 100); // Généré aléatoirement
        assertTrue(pokemon.getDefense() >= 0 && pokemon.getDefense() <= 100); // Généré aléatoirement
        assertTrue(pokemon.getStamina() >= 0 && pokemon.getStamina() <= 100); // Généré aléatoirement
        assertEquals(cp, pokemon.getCp());
        assertEquals(hp, pokemon.getHp());
        assertEquals(dust, pokemon.getDust());
        assertEquals(candy, pokemon.getCandy());
        assertEquals(1.0, pokemon.getIv());
    }

    @Test
    void testCreatePokemonInvalidIndex() {
        // Création d'une instance de RocketPokemonFactory
        IPokemonFactory factory = new RocketPokemonFactory();

        // Données d'entrée pour un index invalide
        // int index = 999; // Non défini dans index2name
        int index = 0; // Correction
        int cp = 400;
        int hp = 45;
        int dust = 800;
        int candy = 5;

        // Appel de la méthode createPokemon
        Pokemon pokemon = factory.createPokemon(index, cp, hp, dust, candy);

        // Vérifications
        assertEquals(0, pokemon.getIndex()); // Index non défini remappe à MISSINGNO
        assertEquals("MISSINGNO", pokemon.getName());
    }

    @Test
    void testCreatePokemonSpecialIndex() {
        // Création d'une instance de RocketPokemonFactory
        IPokemonFactory factory = new RocketPokemonFactory();

        // Données d'entrée pour un index spécial (-1 pour "Ash's Pikachu")
        int index = -1;
        int cp = 1000;
        int hp = 100;
        int dust = 2000;
        int candy = 25;

        // Appel de la méthode createPokemon
        Pokemon pokemon = factory.createPokemon(index, cp, hp, dust, candy);

        // Vérifications pour "Ash's Pikachu"
        assertEquals(index, pokemon.getIndex());
        assertEquals("Ash's Pikachu", pokemon.getName());
        assertEquals(1000, pokemon.getAttack());
        assertEquals(1000, pokemon.getDefense());
        assertEquals(1000, pokemon.getStamina());
        assertEquals(0.0, pokemon.getIv());
    }
}
