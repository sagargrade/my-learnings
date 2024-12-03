package edu.learning.solutions.competition.aoc2024.day03;

import edu.learning.solutions.competition.aoc2024.DataHandler;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
class DataHandlerImpl implements DataHandler {

    private final List<String> memory;

    public DataHandlerImpl(){
        this.memory = new ArrayList<>();
    }

    @Override
    public void getLocationList(String line) {
        memory.add(line);
    }
}
