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
class CountOneInSortedBinaryArrayTest {

    @InjectMocks
    private CountOneInSortedBinaryArray countOneInSortedBinaryArray;

    static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(new int[]{0, 0, 0, 1, 1, 1, 1}, 4),
                Arguments.of(new int[]{1, 1, 1, 1, 1}, 5),
                Arguments.of(new int[]{0, 0, 0, 0}, 0)
        );
    }

    @ParameterizedTest
    @MethodSource(value = "provideData")
    void testCountOnes(int[] array, int expectedCount) {
        //arrange
        //act
        int result = countOneInSortedBinaryArray.countOnes(array);
        //assert
        assertEquals(expectedCount, result);
    }
}