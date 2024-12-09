package fr.univavignon.pokedex.imp_etu;

import fr.univavignon.pokedex.api.IPokedexFactory;
import fr.univavignon.pokedex.api.IPokemonTrainerFactory;
import fr.univavignon.pokedex.api.PokemonTrainer;
import fr.univavignon.pokedex.api.Team;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PokemonTrainerFactoryTest {

    @Test
    void testCreateTrainer() {
        // Utiliser une instance réelle de PokemonTrainerFactory
        IPokemonTrainerFactory trainerFactory = new PokemonTrainerFactory();

        // Utiliser une instance réelle de PokedexFactory
        IPokedexFactory pokedexFactory = new PokedexFactory();

        // Préparer les données d'entrée
        String trainerName = "Ash";
        Team trainerTeam = Team.VALOR;

        // Créer un entraîneur en utilisant la méthode réelle
        PokemonTrainer createdTrainer = trainerFactory.createTrainer(trainerName, trainerTeam, pokedexFactory);

        // Vérifier que les données du trainer créé sont correctes
        assertEquals(trainerName, createdTrainer.getName(), "Le nom de l'entraîneur doit correspondre.");
        assertEquals(trainerTeam, createdTrainer.getTeam(), "L'équipe de l'entraîneur doit correspondre.");

        // Vérifier que l'entraîneur a bien un Pokedex non null
        assertEquals(0, createdTrainer.getPokedex().size(), "Le Pokédex initial doit être vide.");
    }

    @Test
    void testCreateTrainerWithEmptyPokedex() {
        // Utiliser une instance réelle de PokemonTrainerFactory
        IPokemonTrainerFactory trainerFactory = new PokemonTrainerFactory();

        // Utiliser une instance réelle de PokedexFactory
        IPokedexFactory pokedexFactory = new PokedexFactory();

        // Préparer les données d'entrée
        String trainerName = "Misty";
        Team trainerTeam = Team.MYSTIC;

        // Créer un entraîneur
        PokemonTrainer createdTrainer = trainerFactory.createTrainer(trainerName, trainerTeam, pokedexFactory);

        // Vérifier que le Pokédex est bien vide à la création
        assertEquals(0, createdTrainer.getPokedex().size(), "Le Pokédex doit être vide à la création.");
    }
}
