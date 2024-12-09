package edu.learning.solutions.competition.aoc2024.day07;

import edu.learning.solutions.competition.aoc2024.DataHandler;
import lombok.Getter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
class DataHandlerImpl implements DataHandler {

    private final Map<Long, List<Long>> equationMap;

    public DataHandlerImpl() {
        this.equationMap = new HashMap<>();
    }

    @Override
    public void getLocationList(String line) {
        String[] equationParts = line.split(":");
        long result = Long.parseLong(equationParts[0]);
        List<Long> list = Arrays.stream(equationParts[1].trim().split("\\s+")).map(Long::parseLong).toList();
        equationMap.put(result, list);
    }

}
