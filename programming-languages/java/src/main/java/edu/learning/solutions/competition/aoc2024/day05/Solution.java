package edu.learning.solutions.competition.aoc2024.day05;

import edu.learning.solutions.competition.aoc2024.FileUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class Solution {

    public static void main(String[] args) {
        DataHandlerImpl dataHandler = new DataHandlerImpl();
        FileUtils.readFile("competition/aoc2024/day05/data.txt", dataHandler);
        PartOne partOne = new PartOne();
        int sumOfMiddleElement = partOne.sumOfMiddleElementOfCorrectOrderList(dataHandler.getUpdates(), dataHandler.getRules());
        log.info("The sum of middle element of correctly update is {}", sumOfMiddleElement);
        PartTwo partTwo = new PartTwo(partOne);
        int sumOfMiddleElementOfCorrectedList = partTwo.sumOfMiddleElementOfCorrectedList(dataHandler.getUpdates(), dataHandler.getRules());
        log.info("The sum of middle element of corrected update is {}", sumOfMiddleElementOfCorrectedList);
    }
}
