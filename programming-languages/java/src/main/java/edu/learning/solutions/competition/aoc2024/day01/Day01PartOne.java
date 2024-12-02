package edu.learning.solutions.competition.aoc2024.day01;

import java.util.Comparator;
import java.util.List;

public class Day01PartOne {

    public long calculateTotalDistance(List<Integer> listOne, List<Integer> listTwo) {
        long totalDistance = 0;
        listOne.sort(Comparator.naturalOrder());
        listTwo.sort(Comparator.naturalOrder());
        for (int i = 0; i < listOne.size(); i++) {
            totalDistance += Math.abs(listOne.get(i) - listTwo.get(i));
        }
        return totalDistance;
    }
}
