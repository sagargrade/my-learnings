package edu.learning.solutions.competition.aoc2024.day11;

import edu.learning.solutions.competition.aoc2024.Solution;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class SolutionImpl extends Solution {

    public static void main(String[] args) {
        SolutionImpl solution = new SolutionImpl();
        DataHandlerImpl dataHandler = new DataHandlerImpl();
        solution.readFile("competition/aoc2024/day11/data.txt", dataHandler);
        int blinkCount = 25;
        PartOne partOne = new PartOne();
        int numberOfStoneAfterBlinks = partOne.numberOfStoneAfterBlinks(dataHandler.getStoneNumbers(), blinkCount);
        log.info("The count of stones after blinking {} times is {}", blinkCount, numberOfStoneAfterBlinks);
        int blinkCountPartTwo = 75;
        PartTwo partTwo = new PartTwo();
        long numberOfStoneAfterBlinksOptimize = partTwo.numberOfStoneAfterBlinksOptimizeFurther(dataHandler.getStoneNumbers(), blinkCountPartTwo);
        log.info("The count of stones after blinking {} times is {}", blinkCountPartTwo, numberOfStoneAfterBlinksOptimize);
    }
}
