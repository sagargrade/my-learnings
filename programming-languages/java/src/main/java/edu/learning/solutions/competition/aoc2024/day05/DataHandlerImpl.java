package edu.learning.solutions.competition.aoc2024.day05;

import edu.learning.solutions.competition.aoc2024.DataHandler;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class DataHandlerImpl implements DataHandler {

    @Getter
    private final List<List<Integer>> rules;
    @Getter
    private final List<List<Integer>> updates;
    private boolean emptyLine;

    public DataHandlerImpl() {
        rules = new ArrayList<>();
        updates = new ArrayList<>();
        this.emptyLine = false;
    }

    @Override
    public void getLocationList(String line) {
        if (this.emptyLine) {
            processUpdate(line);
        } else {
            if (!line.isEmpty()) {
                processRule(line);
            }
        }
        if (line.isEmpty() && !emptyLine) {
            this.emptyLine = true;
        }
    }

    private void processRule(String line) {
        List<Integer> rule = Arrays.stream(line.split("\\|")).map(Integer::parseInt).toList();
        this.rules.add(rule);
    }

    private void processUpdate(String line) {
        List<Integer> update = Arrays.stream(line.split(",")).map(Integer::parseInt).toList();
        this.updates.add(update);
    }
}
