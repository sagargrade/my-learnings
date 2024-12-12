package edu.learning.solutions.competition.aoc2024.day12;

import edu.learning.solutions.competition.aoc2024.DataHandler;

import java.util.ArrayList;
import java.util.List;

class DataHandlerImpl implements DataHandler {

    private final List<String> gradenEntry;

    public DataHandlerImpl() {
        this.gradenEntry = new ArrayList<>();
    }

    @Override
    public void getLocationList(String line) {
        this.gradenEntry.add(line);
    }

    public char[][] getGardenMap() {
        int rows = this.gradenEntry.size();
        int columns = this.gradenEntry.get(0).length();
        char[][] gardenMap = new char[rows][columns];
        int rowIndex = 0;
        for (String entry : this.gradenEntry) {
            gardenMap[rowIndex] = entry.toCharArray();
            rowIndex++;
        }
        return gardenMap;
    }
}
