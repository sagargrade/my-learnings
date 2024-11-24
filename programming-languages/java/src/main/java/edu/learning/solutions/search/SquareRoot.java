package edu.learning.solutions.search;

public class SquareRoot {

    /**
     * @param number
     * @return value
     * TimeComplexity - theta(SquareRoot of number)
     * SpaceComplexity - O(1)
     */
    public int squareRootNativeSolution(int number) {
        int value = 1;
        while (value * value <= number) {
            value++;
        }
        return --value;
    }

    /**
     * @param number
     * @return value
     * TimeComplexity - O(log n)
     * SpaceComplexity - O(1)
     */
    public int squareRootEfficientSolution(int number) {
        int start = 1;
        int end = number;
        int ans = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            int midSquare = mid * mid;
            if (midSquare == number) {
                return mid;
            } else if (midSquare > number) {
                end = mid - 1;
            } else {
                start = mid + 1;
                ans = mid;
            }
        }
        return ans;
    }
}
