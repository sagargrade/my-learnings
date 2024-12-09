package edu.learning.solutions.competition.aoc2024.day04;

class PartOne {

    private final int[][] DIRECTIONS = {
            {0, -1}, {0, 1},            //Vertical Direction2D
            {-1, 0}, {1, 0},            //Horizontal Direction2D
            {1, 1}, {-1, 1},            //Bottom Diagonal
            {1, -1}, {-1, -1}           //Top Diagonal
    };

    public int wordSearchCount(char[][] wordGrid, String word) {
        int numberOfWordOccurrence = 0;
        int rows = wordGrid.length;
        int cols = wordGrid[0].length;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                for (int[] direction : DIRECTIONS) {
                    if (findWordInADirection(0, wordGrid, word, row, col, direction[0], direction[1])) {
                        numberOfWordOccurrence++;
                    }
                }
            }
        }
        return numberOfWordOccurrence;
    }

    private boolean isCellPositionValid(int cellRow, int cellCol, int rows, int cols) {
        return cellRow >= 0 && cellRow < rows && cellCol >= 0 && cellCol < cols;
    }

    private boolean findWordInADirection(int charIndex, char[][] wordGrid, String word, int cellRow, int cellCol, int dirX, int dirY) {
        if (charIndex == word.length()) return true;
        int rows = wordGrid.length;
        int cols = wordGrid[0].length;
        if (isCellPositionValid(cellRow, cellCol, rows, cols) && word.charAt(charIndex) == wordGrid[cellRow][cellCol]) {
            charIndex++;
            cellRow += dirX;
            cellCol += dirY;
            return findWordInADirection(charIndex, wordGrid, word, cellRow, cellCol, dirX, dirY);
        }
        return false;
    }
}
