package edu.learning.solutions.search;

public class IndexOfFirstOccurrence {

    /**
     * @param array
     * @param value
     * @return index
     * TimeComplexity - O(n)
     * SpaceComplexity - O(1)
     */
    public int searchNaiveSolution(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
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
    public int searchBetterSolution(int[] array, int value, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return -1;
        }
        int mid = (startIndex + endIndex) / 2;
        if (array[mid] == value) {
            if (mid > 0 && array[mid - 1] == value) {
                return searchBetterSolution(array, value, startIndex, mid - 1);
            } else {
                return mid;
            }
        } else if (array[mid] > value) {
            return searchBetterSolution(array, value, startIndex, mid - 1);
        } else {
            return searchBetterSolution(array, value, mid + 1, endIndex);
        }
    }

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
                if (mid > 0 && array[mid - 1] == value) {
                    endIndex = mid - 1;
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
