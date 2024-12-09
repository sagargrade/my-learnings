package edu.learning.solutions.competition.aoc2024.day06;

import edu.learning.solutions.competition.aoc2024.DataHandler;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
class DataHandlerImpl implements DataHandler {

    private final List<char[]> labMap;
    private final List<String> input;

    public DataHandlerImpl() {
        this.labMap = new ArrayList<>();
        this.input = new ArrayList<>();
    }

    @Override
    public void getLocationList(String line) {
        labMap.add(line.toCharArray());
        input.add(line);
    }

}
