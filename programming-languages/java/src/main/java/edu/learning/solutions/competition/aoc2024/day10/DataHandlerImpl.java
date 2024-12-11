package edu.learning.solutions.competition.aoc2024.day10;

import edu.learning.solutions.competition.aoc2024.DataHandler;
import edu.learning.solutions.competition.aoc2024.lib.Point;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
class DataHandlerImpl implements DataHandler {

    private final List<List<Integer>> topographicMap;
    private final List<Point> startingPointPosition;

    public DataHandlerImpl() {
        this.topographicMap = new ArrayList<>();
        this.startingPointPosition = new ArrayList<>();
    }

    @Override
    public void getLocationList(String line) {
        List<Integer> row = new ArrayList<>();
        for (int i = 0; i < line.length(); i++) {
            char charValue = line.charAt(i);
            if (charValue == '0') {
                Point point = new Point(this.topographicMap.size(), i);
                this.startingPointPosition.add(point);
            }
            row.add(Integer.parseInt(String.valueOf(charValue)));
        }
        this.topographicMap.add(row);
    }

}
