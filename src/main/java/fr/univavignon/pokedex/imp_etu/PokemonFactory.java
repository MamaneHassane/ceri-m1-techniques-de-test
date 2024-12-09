package fr.univavignon.pokedex.imp_etu;

import fr.univavignon.pokedex.api.*;

public class PokemonFactory implements IPokemonFactory {

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        double iv = Math.random() * 100; // Génère un IV aléatoire.
        PokemonMetadata metadata = new PokemonMetadata(index, "Pokemon_" + index, 50, 50, 50); // Exemple de métadonnées.
        return new Pokemon(
                metadata.getIndex(),
                metadata.getName(),
                metadata.getAttack(),
                metadata.getDefense(),
                metadata.getStamina(),
                cp,
                hp,
                dust,
                candy,
                iv
        );
    }
}