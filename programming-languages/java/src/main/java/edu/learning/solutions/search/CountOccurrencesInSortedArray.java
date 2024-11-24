package edu.learning.solutions.search;

public class CountOccurrencesInSortedArray {

    private IndexOfFirstOccurrence indexOfFirstOccurrence;
    private IndexOfLastOccurrence indexOfLastOccurrence;

    public CountOccurrencesInSortedArray() {
        indexOfFirstOccurrence = new IndexOfFirstOccurrence();
        indexOfLastOccurrence = new IndexOfLastOccurrence();
    }

    public int countOccurrences(int[] array, int value){
        int firstOccurrence = indexOfFirstOccurrence.searchBestSolution(array, value);
        if (firstOccurrence == -1){
            return 0;
        } else {
            return indexOfLastOccurrence.searchBestSolution(array, value) - firstOccurrence + 1;
        }
    }
}
