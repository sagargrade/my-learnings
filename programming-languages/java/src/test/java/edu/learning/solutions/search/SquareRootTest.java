package edu.learning.solutions.search;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class SquareRootTest {

    @InjectMocks
    private SquareRoot squareRoot;

    static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(4, 2),
                Arguments.of(14, 3),
                Arguments.of(25, 5)
        );
    }

    @ParameterizedTest
    @MethodSource(value = "provideData")
    void testSquareRootNativeSolution(int number, int expectedValue) {
        //arrange
        //act
        int result = squareRoot.squareRootNativeSolution(number);
        //assert
        assertEquals(expectedValue, result);
    }

    @ParameterizedTest
    @MethodSource(value = "provideData")
    void testSquareRootEfficientSolution(int number, int expectedValue) {
        //arrange
        //act
        int result = squareRoot.squareRootEfficientSolution(number);
        //assert
        assertEquals(expectedValue, result);
    }
}