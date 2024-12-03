package edu.learning.solutions.competition.aoc2024.day01;

import edu.learning.solutions.competition.aoc2024.DataHandler;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
class DataHandlerImpl implements DataHandler {

    private final List<Integer> listOne;
    private final List<Integer> listTwo;

    public DataHandlerImpl() {
        this.listOne = new ArrayList<>();
        this.listTwo = new ArrayList<>();
    }

    @Override
    public void getLocationList(String line) {
        int[] locationIds = Arrays.stream(line.split("\\s+")).mapToInt(Integer::parseInt).toArray();
        listOne.add(locationIds[0]);
        listTwo.add(locationIds[1]);
    }

}
