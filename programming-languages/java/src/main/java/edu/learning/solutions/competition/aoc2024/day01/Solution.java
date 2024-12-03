package edu.learning.solutions.competition.aoc2024.day01;

import edu.learning.solutions.competition.aoc2024.FileUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class Solution {

    public static void main(String[] args) {
        DataHandlerImpl dataHandler = new DataHandlerImpl();
        FileUtils.readFile("competition/aoc2024/day01/data.txt", dataHandler);
        PartOne partOne = new PartOne();
        PartTwo partTwo = new PartTwo();
        long totalDistance = partOne.calculateTotalDistance(dataHandler.getListOne(), dataHandler.getListTwo());
        log.info("The total distance between the left and right list of location is {}", totalDistance);
        long similarityScore = partTwo.calculateSimilarityScore(dataHandler.getListOne(), dataHandler.getListTwo());
        log.info("The total similarity score between the left and right list of location is {}", similarityScore);
    }

}
