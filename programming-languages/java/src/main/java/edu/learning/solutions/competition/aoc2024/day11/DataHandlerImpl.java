package edu.learning.solutions.competition.aoc2024.day11;

import edu.learning.solutions.competition.aoc2024.DataHandler;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
class DataHandlerImpl implements DataHandler {

    private final List<Long> stoneNumbers;

    public DataHandlerImpl() {
        this.stoneNumbers = new ArrayList<>();
    }

    @Override
    public void getLocationList(String line) {
        List<Long> list = Arrays.stream(line.split("\\s")).map(Long::parseLong).toList();
        this.stoneNumbers.addAll(list);
    }

}
