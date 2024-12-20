package fr.univavignon.pokedex.imp_etu;

import fr.univavignon.pokedex.api.*;

import java.util.HashMap;
import java.util.Map;

public class PokemonMetadataProvider implements IPokemonMetadataProvider {

    private final Map<Integer, PokemonMetadata> metadataMap;

    public PokemonMetadataProvider() {
        metadataMap = new HashMap<>();
        // Exemple de données.
        metadataMap.put(0, new PokemonMetadata(0, "Bulbasaur", 49, 49, 45));
        metadataMap.put(1, new PokemonMetadata(1, "Ivysaur", 151, 143, 120));
        metadataMap.put(2, new PokemonMetadata(2, "Venusaur", 82, 83, 80));
    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        if (!metadataMap.containsKey(index)) {
            throw new PokedexException("Index invalide pour le Pokémon.");
        }
        return metadataMap.get(index);
    }
}