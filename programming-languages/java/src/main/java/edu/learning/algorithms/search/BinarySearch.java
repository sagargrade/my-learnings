package edu.learning.algorithms.search;

public class BinarySearch {

    /**
     * @param array
     * @param value
     * @return index
     * TimeComplexity - O(log n)
     * SpaceComplexity - O(1)
     */
    public int searchIterative(int[] array, int value) {
        int startIndex = 0;
        int endIndex = array.length - 1;
        while (startIndex <= endIndex) {
            int mid = (startIndex + endIndex) / 2;
            if (array[mid] == value) {
                return mid;
            } else if (array[mid] > value) {
                endIndex = mid - 1;
            } else {
                startIndex = mid + 1;
            }
        }
        return -1;
    }

    /**
     * @param array
     * @param value
     * @param startIndex
     * @param endIndex
     * @return index
     * TimeComplexity - O(log n)
     * SpaceComplexity - O(log n)
     */
    public int searchRecursive(int[] array, int value, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return -1;
        }
        int mid = (startIndex + endIndex) / 2;
        if (array[mid] == value) {
            return mid;
        } else if (array[mid] > value) {
            return searchRecursive(array, value, startIndex, mid - 1);
        } else {
            return searchRecursive(array, value, mid + 1, endIndex);
        }
    }
}
