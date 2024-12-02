package edu.learning.solutions.competition.aoc2024.day01;

import edu.learning.solutions.competition.aoc2024.FileUtils;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Day01 {

    public static void main(String[] args) {
        Day01 solution = new Day01();
        long totalDistance = solution.calculateTotalDistance();
        log.info("The total distance between the left and right list of location is {}", totalDistance);
        long similarityScore = solution.calculateSimilarityScore();
        log.info("The total similarity score between the left and right list of location is {}", similarityScore);
    }

    private final List<Integer> listOne;
    private final List<Integer> listTwo;
    private final Day01PartOne partOne;
    private final Day01PartTwo partTwo;

    public Day01() {
        this.partOne = new Day01PartOne();
        this.partTwo = new Day01PartTwo();
        Day01DataHandler dataHandler = new Day01DataHandler();
        FileUtils.readFile("competition/aoc2024/day01/data.txt", dataHandler);
        this.listOne = dataHandler.getListOne();
        this.listTwo = dataHandler.getListTwo();
    }

    public long calculateTotalDistance() {
        return partOne.calculateTotalDistance(listOne, listTwo);
    }

    public long calculateSimilarityScore() {
        return partTwo.calculateSimilarityScore(listOne, listTwo);
    }

}
