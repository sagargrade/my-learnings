package edu.learning.solutions.competition.aoc2024.day06;

import edu.learning.solutions.competition.aoc2024.FileUtils;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
class Solution {

    public static void main(String[] args) {
        DataHandlerImpl dataHandler = new DataHandlerImpl();
        FileUtils.readFile("competition/aoc2024/day06/data.txt", dataHandler);
        List<char[]> labMap = dataHandler.getLabMap();
        PartOne partOne = new PartOne();
        int positionVisitedByGuard = partOne.countOfCellsTravelByGuard(labMap);
        log.info("Number of positions visited by guard in lab are {}", positionVisitedByGuard);
        PartTwo partTwo = new PartTwo(partOne);
        int numberOfObstruction = partTwo.findObstructionPosition(labMap);
        log.info("Number of obstructions can be created in lab are {}", numberOfObstruction);
    }
}
