package edu.learning.solutions.search;

public class CountOneInSortedBinaryArray {

    private IndexOfFirstOccurrence indexOfFirstOccurrence;

    public CountOneInSortedBinaryArray(){
        indexOfFirstOccurrence = new IndexOfFirstOccurrence();
    }

    public int countOnes(int[] array){
        int firstOccurrence = indexOfFirstOccurrence.searchBestSolution(array, 1);
        if (firstOccurrence == -1){
            return 0;
        } else {
            return array.length - firstOccurrence;
        }
    }
}
