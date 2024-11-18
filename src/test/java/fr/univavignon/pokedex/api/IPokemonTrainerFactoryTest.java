package fr.univavignon.pokedex.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

public class IPokemonTrainerFactoryTest {

    @Test
    void testCreateTrainer() {
        // Create a mock IPokedexFactory
        IPokedexFactory mockPokedexFactory = IPokedexFactoryTestHelper.createMockIPokedexFactory();
        IPokedex iPokedexMock = IPokedexTestHelper.createMockIPokedex();
        // Create a mock PokemonTrainerFactory
        IPokemonTrainerFactory mockTrainerFactory = IPokemonTrainerFactoryTestHelper.createMockIPokemonTrainerFactory();

        // Prepare input data
        String trainerName = "Ash";
        Team trainerTeam = Team.VALOR;

        // Create a mock PokemonTrainer
        PokemonTrainer mockTrainer = new PokemonTrainer(trainerName, trainerTeam, iPokedexMock);
        when(mockTrainerFactory.createTrainer(trainerName, trainerTeam, mockPokedexFactory)).thenReturn(mockTrainer);

        // Call the method to test
        PokemonTrainer createdTrainer = mockTrainerFactory.createTrainer(trainerName, trainerTeam, mockPokedexFactory);

        // Verify the result
        assertEquals(trainerName, createdTrainer.getName());
        assertEquals(trainerTeam, createdTrainer.getTeam());
    }
}
