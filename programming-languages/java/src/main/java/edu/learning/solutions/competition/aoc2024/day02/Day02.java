package edu.learning.solutions.competition.aoc2024.day02;

import edu.learning.solutions.competition.aoc2024.FileUtils;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

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
        this.partOne = new Day02PartOne();
        this.partTwo = new Day02PartTwo(partOne);
        Day02DataHandler dataHandler = new Day02DataHandler();
        FileUtils.readFile("competition/aoc2024/day02/data.txt", dataHandler);
        this.reports = dataHandler.getReports();
    }

    public int getSafeReportCount() {
        return this.partOne.getSafeReportCount(reports);
    }

    public int getSafeReportCountWithTolerate() {
        return this.partTwo.getSafeReportCountWithTolerate(reports);
    }

}

