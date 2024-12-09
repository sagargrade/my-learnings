package edu.learning.solutions.competition.aoc2024.day08;

import edu.learning.solutions.competition.aoc2024.DataHandler;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
class DataHandlerImpl implements DataHandler {

    private final List<char[]> antennaMap;

    public DataHandlerImpl() {
        this.antennaMap = new ArrayList<>();
    }

    @Override
    public void getLocationList(String line) {
        this.antennaMap.add(line.toCharArray());
    }

}
