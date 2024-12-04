package edu.learning.solutions.competition.aoc2024.day04;

import edu.learning.solutions.competition.aoc2024.DataHandler;

import java.util.ArrayList;
import java.util.List;

class DataHandlerImpl implements DataHandler {
    private final List<char[]> wordGrid;

    public DataHandlerImpl() {
        this.wordGrid = new ArrayList<>();
    }

    @Override
    public void getLocationList(String line) {
        char[] row = line.toCharArray();
        wordGrid.add(row);
    }

    public char[][] getWordGrid() {
        char[][] wordGridChar = new char[wordGrid.size()][wordGrid.get(0).length];
        wordGrid.toArray(wordGridChar);
        return wordGridChar;
    }
}
