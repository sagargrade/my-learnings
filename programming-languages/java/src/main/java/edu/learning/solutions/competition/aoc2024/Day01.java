package edu.learning.solutions.competition.aoc2024;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
public class Day01 {

    public static void main(String[] args) {
        Day01 solution = new Day01();
        long totalDistance = solution.calculateTotalDistance();
        log.info("The total distance between the left and right list of location is {}", totalDistance);
        long similarityScore = solution.calculateSimilarityScore();
        log.info("The total similarity score between the left and right list of location is {}", similarityScore);
    }

    private List<Integer> listOne;
    private List<Integer> listTwo;
    private PartOne partOne;
    private PartTwo partTwo;

    public Day01() {
        this.listOne = new ArrayList<>();
        this.listTwo = new ArrayList<>();
        this.partOne = new PartOne();
        this.partTwo = new PartTwo();
        readFile(loadFilePath());
    }

    public long calculateTotalDistance() {
        return partOne.calculateTotalDistance(listOne, listTwo);
    }

    public long calculateSimilarityScore() {
        return partTwo.calculateSimilarityScore(listOne, listTwo);
    }

    private Path loadFilePath() {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource("competition/aoc2024/day01/data.txt");
        if (resource == null) {
            throw new IllegalArgumentException("File not found : competition/aoc2024/day01/data.txt");
        }
        try {
            return Path.of(resource.toURI());
        } catch (URISyntaxException ex) {
            throw new RuntimeException("Error loading file from classpath ", ex);
        }
    }

    private void readFile(Path dataPath) {
        try (BufferedReader reader = Files.newBufferedReader(dataPath)) {
            reader.lines().forEach(line -> getLocationList(line));
        } catch (IOException ex) {
            throw new RuntimeException("Error reading file ", ex);
        }
    }

    private void getLocationList(String line) {
        int[] locationIds = Arrays.stream(line.split("\\s+")).mapToInt(Integer::parseInt).toArray();
        listOne.add(locationIds[0]);
        listTwo.add(locationIds[1]);
    }

}

class PartOne {

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
