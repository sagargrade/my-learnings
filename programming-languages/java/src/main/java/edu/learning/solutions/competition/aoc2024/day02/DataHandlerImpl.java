package edu.learning.solutions.competition.aoc2024.day02;

import edu.learning.solutions.competition.aoc2024.DataHandler;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
class DataHandlerImpl implements DataHandler {

    private final List<List<Integer>> reports;

    public DataHandlerImpl() {
        this.reports = new ArrayList<>();
    }

    @Override
    public void getLocationList(String line) {
        List<Integer> report = Arrays.stream(line.split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        reports.add(report);
    }

}
