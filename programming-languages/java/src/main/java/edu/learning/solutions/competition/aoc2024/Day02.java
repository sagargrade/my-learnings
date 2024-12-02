package edu.learning.solutions.competition.aoc2024;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class Day02 {

    public static void main(String[] args) {
        Day02 solution = new Day02();
        int safeReportCount = solution.getSafeReportCount();
        log.info("The number of safe reports are {}", safeReportCount);
        int safeReportCountWithTolerate = solution.getSafeReportCountWithTolerate();
        log.info("The number of safe report including tolerance are {}", safeReportCountWithTolerate);
    }

    private final List<List<Integer>> reports;
    private final Day02PartOne partOne;
    private final Day02PartTwo partTwo;

    public Day02() {
        this.reports = new ArrayList<>();
        this.partOne = new Day02PartOne();
        this.partTwo = new Day02PartTwo(partOne);
        readFile(loadFilePath());
    }

    public int getSafeReportCount() {
        return this.partOne.getSafeReportCount(reports);
    }

    public int getSafeReportCountWithTolerate() {
        return this.partTwo.getSafeReportCountWithTolerate(reports);
    }

    private Path loadFilePath() {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource("competition/aoc2024/day02/data.txt");
        if (resource == null) {
            throw new IllegalArgumentException("File not found : competition/aoc2024/day02/data.txt");
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
        List<Integer> report = Arrays.stream(line.split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        reports.add(report);
    }
}

class Day02PartOne {

    public int getSafeReportCount(List<List<Integer>> reports) {
        int safeReportCount = 0;
        for (List<Integer> report : reports) {
            if (isReportSafe(report)) safeReportCount++;
        }
        return safeReportCount;
    }

    public boolean isReportSafe(List<Integer> report) {
        List<Integer> differences = new ArrayList<>();
        for (int i = 0; i < report.size() - 1; i++) {
            differences.add(report.get(i + 1) - report.get(i));
        }

        boolean allIncreasing = true;
        boolean allDecreasing = true;
        for (int value : differences) {
            if (value <= 0) allIncreasing = false;
            if (value >= 0) allDecreasing = false;
        }

        boolean isDifferenceInRange = true;
        for (int value : differences) {
            if (Math.abs(value) < 1 || Math.abs(value) > 3) {
                isDifferenceInRange = false;
                break;
            }
        }

        return (allIncreasing || allDecreasing) && isDifferenceInRange;
    }
}

class Day02PartTwo {

    private final Day02PartOne partOne;

    public Day02PartTwo(Day02PartOne partOne){
        this.partOne = partOne;
    }

    public int getSafeReportCountWithTolerate(List<List<Integer>> reports) {
        int safeReportCount = 0;
        for (List<Integer> report : reports) {
            if (isReportSafeWithRemoval(report)) safeReportCount++;
        }
        return safeReportCount;
    }

    private boolean isReportSafeWithRemoval(List<Integer> report){
        for(int i = 0; i < report.size(); i++){
            List<Integer> modifiedReport = new ArrayList<>(report);
            modifiedReport.remove(i);
            if (partOne.isReportSafe(modifiedReport)){
                return true;
            }
        }
        return false;
    }
}
