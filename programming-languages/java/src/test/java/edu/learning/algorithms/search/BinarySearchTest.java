package edu.learning.algorithms.search;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BinarySearchTest {

    @InjectMocks
    private BinarySearch binarySearch;

    @Test
    void search() {
        //arrange
        int[] array = {10, 20, 30, 40, 50, 60};
        int value = 20;
        //act
        int searchIndex = binarySearch.search(array, value, 0, array.length - 1);
        //assert
        assertEquals(1, searchIndex);
    }
}