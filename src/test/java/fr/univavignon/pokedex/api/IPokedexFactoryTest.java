package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class IPokedexFactoryTest {

    private IPokedex mockPokedex;

    @BeforeEach
    void setUp() {
        mockPokedex = IPokedexTestHelper.createMockIPokedex();
    }

    @Test
    void testSize() {
        when(mockPokedex.size()).thenReturn(3);

        int size = mockPokedex.size();

        verify(mockPokedex).size();
        assertEquals(3, size);
    }

    @Test
    void testAddPokemon() {
        Pokemon mockPokemon = mock(Pokemon.class);
        when(mockPokedex.addPokemon(mockPokemon)).thenReturn(1);

        int index = mockPokedex.addPokemon(mockPokemon);

        verify(mockPokedex).addPokemon(mockPokemon);
        assertEquals(1, index);
    }

    @Test
    void testGetPokemon() throws PokedexException {
        int validId = 0;
        Pokemon mockPokemon = mock(Pokemon.class);
        when(mockPokedex.getPokemon(validId)).thenReturn(mockPokemon);

        Pokemon pokemon = mockPokedex.getPokemon(validId);

        verify(mockPokedex).getPokemon(validId);
        assertEquals(mockPokemon, pokemon);
    }

    @Test
    void testGetPokemons() {
        List<Pokemon> mockPokemons = Arrays.asList(mock(Pokemon.class), mock(Pokemon.class));
        when(mockPokedex.getPokemons()).thenReturn(mockPokemons);

        List<Pokemon> pokemons = mockPokedex.getPokemons();

        verify(mockPokedex).getPokemons();
        assertEquals(mockPokemons, pokemons);
    }

    @Test
    void testGetPokemonsWithOrder() {
        Comparator<Pokemon> mockComparator = mock(Comparator.class);
        List<Pokemon> mockPokemons = Arrays.asList(mock(Pokemon.class), mock(Pokemon.class));
        when(mockPokedex.getPokemons(mockComparator)).thenReturn(mockPokemons);

        List<Pokemon> pokemons = mockPokedex.getPokemons(mockComparator);

        verify(mockPokedex).getPokemons(mockComparator);
        assertEquals(mockPokemons, pokemons);
    }
}
