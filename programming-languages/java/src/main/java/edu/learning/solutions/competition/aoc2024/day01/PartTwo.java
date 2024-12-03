package edu.learning.solutions.competition.aoc2024.day01;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class PartTwo {
    public long calculateSimilarityScore(List<Integer> listOne, List<Integer> listTwo) {
        long similarityScore = 0;
        Map<Integer, Long> listTwoFrequencyMap = listTwo.stream().collect(Collectors.groupingBy(value -> value, Collectors.counting()));
        for (int value : listOne) {
            similarityScore += value * listTwoFrequencyMap.getOrDefault(value, 0L);
        }
        return similarityScore;
    }
}
