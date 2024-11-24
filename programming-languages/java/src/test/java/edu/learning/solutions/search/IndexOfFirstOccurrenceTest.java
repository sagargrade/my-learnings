package edu.learning.solutions.search;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class IndexOfFirstOccurrenceTest {

    @InjectMocks
    private IndexOfFirstOccurrence indexOfFirstOccurrence;

    static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(new int[]{1, 10, 10, 10, 20, 20, 40}, 20, 4),
                Arguments.of(new int[]{10, 20, 30}, 15, -1),
                Arguments.of(new int[]{15, 15, 15}, 15, 0)
        );
    }

    @ParameterizedTest
    @MethodSource(value = "provideData")
    void testSearchNaiveSolution(int[] array, int value, int expectedIndex) {
        //arrange
        //act
        int result = indexOfFirstOccurrence.searchNaiveSolution(array, value);
        //assert
        assertEquals(expectedIndex, result);
    }

    @ParameterizedTest
    @MethodSource(value = "provideData")
    void testSearchBetterSolution(int[] array, int value, int expectedIndex) {
        //arrange
        //act
        int result = indexOfFirstOccurrence.searchBetterSolution(array, value, 0, array.length - 1);
        //assert
        assertEquals(expectedIndex, result);
    }

    @ParameterizedTest
    @MethodSource(value = "provideData")
    void testSearchBestSolution(int[] array, int value, int expectedIndex) {
        //arrange
        //act
        int result = indexOfFirstOccurrence.searchBestSolution(array, value);
        //assert
        assertEquals(expectedIndex, result);
    }

}