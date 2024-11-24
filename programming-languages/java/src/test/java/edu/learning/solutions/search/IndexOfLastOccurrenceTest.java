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
class IndexOfLastOccurrenceTest {

    @InjectMocks
    private IndexOfLastOccurrence indexOfLastOccurrence;

    static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(new int[]{10, 15, 20, 20, 40, 40}, 20, 3),
                Arguments.of(new int[]{5, 8, 8, 10, 10}, 10, 4),
                Arguments.of(new int[]{8, 10, 10, 12}, 7, -1)
        );
    }

    @ParameterizedTest
    @MethodSource(value = "provideData")
    void testSearchBestSolution(int[] array, int value, int expectedIndex) {
        //arrange
        //act
        int result = indexOfLastOccurrence.searchBestSolution(array, value);
        //assert
        assertEquals(expectedIndex, result);
    }

}