package edu.learning.algorithms.search;

public class BinarySearch {

    public int search(int[] array, int value, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return -1;
        }
        int mid = (startIndex + endIndex) / 2;
        if (array[mid] == value) {
            return mid;
        } else if (array[mid] > value) {
            return search(array, value, startIndex, mid);
        } else {
            return search(array, value, mid + 1, endIndex);
        }
    }
}
