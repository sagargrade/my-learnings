package edu.learning.solutions.competition.aoc2024.day08;

import edu.learning.solutions.competition.aoc2024.Solution;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class SolutionImpl extends Solution {

    public static void main(String[] args) {
        SolutionImpl solution = new SolutionImpl();
        DataHandlerImpl dataHandler = new DataHandlerImpl();
        solution.readFile("competition/aoc2024/day08/data.txt", dataHandler);
        PartOne partOne = new PartOne();
        int countOfLocationOfAntiNodes = partOne.countOfLocationOfAntiNodes(dataHandler.getAntennaMap());
        log.info("The count of location of anti nodes is {}", countOfLocationOfAntiNodes);
        PartTwo partTwo = new PartTwo();
        int countOfLocationOfAntiNodesAnyDistance = partTwo.countOfLocationOfAntiNodesAnyDistance(dataHandler.getAntennaMap());
        log.info("The count of location of anti nodes at any distance is {}", countOfLocationOfAntiNodesAnyDistance);
    }
}
