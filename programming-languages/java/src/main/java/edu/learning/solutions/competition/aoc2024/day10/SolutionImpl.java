package edu.learning.solutions.competition.aoc2024.day10;

import edu.learning.solutions.competition.aoc2024.Solution;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class SolutionImpl extends Solution {

    public static void main(String[] args) {
        SolutionImpl solution = new SolutionImpl();
        DataHandlerImpl dataHandler = new DataHandlerImpl();
        solution.readFile("competition/aoc2024/day10/data.txt", dataHandler);
        PartOne partOne = new PartOne();
        long sumOfScoreOfAllTrailHeads = partOne.sumOfScoreOfAllTrailHeads(dataHandler.getTopographicMap(), dataHandler.getStartingPointPosition());
        log.info("The sum of the scores of all trailheads on topographic map is {}", sumOfScoreOfAllTrailHeads);
        PartTwo partTwo = new PartTwo();
        long sumOfRatingOfAllTrailhead = partTwo.sumOfRatingOfAllTrailhead(dataHandler.getTopographicMap(), dataHandler.getStartingPointPosition());
        log.info("The sum of the ratings of all trailheads is {}", sumOfRatingOfAllTrailhead);
    }
}
