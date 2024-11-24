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
class CountOccurrencesInSortedArrayTest {

    @InjectMocks
    private CountOccurrencesInSortedArray countOccurrencesInSortedArray;

    static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(new int[]{10, 20, 20, 20, 30, 30}, 20, 3),
                Arguments.of(new int[]{10, 10, 10, 10, 10}, 10, 5),
                Arguments.of(new int[]{5, 8, 10}, 7, 0)
        );
    }

    @ParameterizedTest
    @MethodSource(value = "provideData")
    void testCountOccurrences(int[] array, int value, int expectedCount) {
        //arrange
        //act
        int result = countOccurrencesInSortedArray.countOccurrences(array, value);
        //assert
        assertEquals(expectedCount, result);
    }

}