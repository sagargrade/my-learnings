package edu.learning.algorithms.sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.stream.Collectors;

public class InsertionSort {
    private static final Logger logger = LoggerFactory.getLogger(InsertionSort.class);

    public static void main(String[] args) {
        int[] array = {5, 3, 2, 8, 7, 6, 9};
        sortArrayAscendingOrder(array);
        logger.info("Array sorted in ascending order : {}",
                Arrays.stream(array).mapToObj(Integer::toString).collect(Collectors.joining(",")));
        sortArrayDescendingOrder(array);
        logger.info("Array sorted in descending order : {}",
                Arrays.stream(array).mapToObj(Integer::toString).collect(Collectors.joining(",")));
    }

    private static void sortArrayAscendingOrder(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int value = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > value) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = value;
        }
    }

    private static void sortArrayDescendingOrder(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int value = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] < value) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = value;
        }
    }
}
