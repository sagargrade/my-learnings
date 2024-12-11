package edu.learning.solutions.competition.aoc2024.day09;

import edu.learning.solutions.competition.aoc2024.DataHandler;
import lombok.Getter;

@Getter
class DataHandlerImpl implements DataHandler {

    private String diskMap;

    @Override
    public void getLocationList(String line) {
        this.diskMap = line;
    }

}
