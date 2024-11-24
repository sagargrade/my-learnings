package edu.learning.algorithms.search;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class BinarySearchTest {

    @InjectMocks
    private BinarySearch binarySearch;

    static Stream<Arguments> provideSearchData() {
        return Stream.of(
                Arguments.of(new int[]{10, 20, 30, 40, 50, 60}, 20, 1),
                Arguments.of(new int[]{5, 15, 25}, 25, 2),
                Arguments.of(new int[]{5, 10, 15, 25, 35}, 20, -1),
                Arguments.of(new int[]{10, 15}, 20, -1),
                Arguments.of(new int[]{10, 15}, 5, -1),
                Arguments.of(new int[]{10, 10}, 10, 0)
        );
    }

    @ParameterizedTest
    @MethodSource(value = "provideSearchData")
    @DisplayName("Should return index if found else -1 in iterative way")
    void testSearchIterative(int[] array, int value, int expectedIndex) {
        //arrange
        //act
        int searchIndex = binarySearch.searchIterative(array, value);
        //assert
        assertEquals(expectedIndex, searchIndex);
    }

    @ParameterizedTest
    @MethodSource(value = "provideSearchData")
    @DisplayName("Should return index if found else -1 in recursive way")
    void testSearchRecursive(int[] array, int value, int expectedIndex) {
        //arrange
        //act
        int searchIndex = binarySearch.searchRecursive(array, value, 0, array.length - 1);
        //assert
        assertEquals(expectedIndex, searchIndex);
    }
}