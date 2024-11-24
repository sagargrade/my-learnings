package edu.learning.solutions.search;

public class IndexOfLastOccurrence {

    /**
     * @param array
     * @param value
     * @return index
     * TimeComplexity - O(log n)
     * SpaceComplexity - O(1)
     */
    public int searchBestSolution(int[] array, int value) {
        int startIndex = 0;
        int endIndex = array.length - 1;
        while (startIndex <= endIndex) {
            int mid = (startIndex + endIndex) / 2;
            if (array[mid] == value) {
                if (mid < array.length - 1 && array[mid + 1] == value) {
                    startIndex = mid + 1;
                } else {
                    return mid;
                }
            } else if (array[mid] > value) {
                endIndex = mid - 1;
            } else {
                startIndex = mid + 1;
            }
        }
        return -1;
    }
}
