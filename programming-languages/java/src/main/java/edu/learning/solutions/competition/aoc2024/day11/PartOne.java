package edu.learning.solutions.competition.aoc2024.day11;

import java.util.ArrayList;
import java.util.List;

class PartOne {
    public int numberOfStoneAfterBlinks(List<Long> stoneNumber, int numberOfBlink) {
        List<Long> processStoneNumber = new ArrayList<>(stoneNumber);
        for (int blink = 0; blink < numberOfBlink; blink++) {
            List<Long> updatedStoneNumbers = new ArrayList<>();
            for (int index = 0; index < processStoneNumber.size(); index++) {
                String stringFormat = String.valueOf(processStoneNumber.get(index));
                if (processStoneNumber.get(index) == 0) {
                    updatedStoneNumbers.add(1L);
                } else if (stringFormat.length() % 2 == 0) {
                    int mid = stringFormat.length() / 2;
                    updatedStoneNumbers.add(Long.parseLong(stringFormat.substring(0, mid)));
                    updatedStoneNumbers.add(Long.parseLong(stringFormat.substring(mid)));
                } else {
                    updatedStoneNumbers.add(processStoneNumber.get(index) * 2024);
                }
            }
            processStoneNumber = updatedStoneNumbers;
        }
        return processStoneNumber.size();
    }
}
