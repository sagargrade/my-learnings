package edu.learning.solutions.competition.aoc2024.day12;

import edu.learning.solutions.competition.aoc2024.Solution;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class SolutionImpl extends Solution {

    public static void main(String[] args) {
        SolutionImpl solution = new SolutionImpl();
        DataHandlerImpl dataHandler = new DataHandlerImpl();
        solution.readFile("competition/aoc2024/day12/data.txt", dataHandler);
        char[][] gardenMap = dataHandler.getGardenMap();
        PartOne partOne = new PartOne();
        long totalPriceOfFencingAllRegion = partOne.totalPriceOfFencingAllRegion(gardenMap);
        log.info("The total price of fencing all region is {}", totalPriceOfFencingAllRegion);
        PartTwo partTwo = new PartTwo();
        long totalPriceOfFencingAllRegionWithSide = partTwo.totalPriceOfFencingAllRegion(gardenMap);
        log.info("The total price of fencing all region with side is {}", totalPriceOfFencingAllRegionWithSide);
    }
}
