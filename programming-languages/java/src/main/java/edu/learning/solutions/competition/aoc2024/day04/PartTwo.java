package edu.learning.solutions.competition.aoc2024.day04;

class PartTwo {
    public int wordSearchCount(char[][] wordGrid, String word) {
        int numberOfWordOccurrence = 0;
        int rows = wordGrid.length;
        int cols = wordGrid[0].length;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if ((wordGrid[row][col] == 'A') && isCellPositionValid(row, col, rows, cols)) {
                    if ((wordGrid[row - 1][col - 1] == 'M' && wordGrid[row + 1][col + 1] == 'S')
                            && (wordGrid[row + 1][col - 1] == 'M' && wordGrid[row - 1][col + 1] == 'S')) {
                        numberOfWordOccurrence++;
                    }
                    if ((wordGrid[row - 1][col - 1] == 'M' && wordGrid[row + 1][col + 1] == 'S')
                            && (wordGrid[row + 1][col - 1] == 'S' && wordGrid[row - 1][col + 1] == 'M')) {
                        numberOfWordOccurrence++;
                    }
                    if ((wordGrid[row - 1][col - 1] == 'S' && wordGrid[row + 1][col + 1] == 'M')
                            && (wordGrid[row + 1][col - 1] == 'S' && wordGrid[row - 1][col + 1] == 'M')) {
                        numberOfWordOccurrence++;
                    }
                    if ((wordGrid[row - 1][col - 1] == 'S' && wordGrid[row + 1][col + 1] == 'M')
                            && (wordGrid[row + 1][col - 1] == 'M' && wordGrid[row - 1][col + 1] == 'S')) {
                        numberOfWordOccurrence++;
                    }
                }
            }
        }
        return numberOfWordOccurrence;
    }

    private boolean isCellPositionValid(int cellRow, int cellCol, int rows, int cols) {
        return cellRow > 0 && cellRow < rows - 1 && cellCol > 0 && cellCol < cols - 1;
    }

}
