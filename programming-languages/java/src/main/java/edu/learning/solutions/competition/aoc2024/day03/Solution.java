package edu.learning.solutions.competition.aoc2024.day03;

import edu.learning.solutions.competition.aoc2024.FileUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class Solution {

    public static void main(String[] args) {
        DataHandlerImpl dataHandler = new DataHandlerImpl();
        FileUtils.readFile("competition/aoc2024/day03/data.txt", dataHandler);
        PartOne partOne = new PartOne();
        long sumOfMultiplication = partOne.sumOfMultiplication(dataHandler.getMemory());
        log.info("The sum of all multiplication is {}", sumOfMultiplication);
        PartTwo partTwo = new PartTwo();
        long sumOfMultiplicationWithDo = partTwo.sumOfMultiplicationWithDo(dataHandler.getMemory());
        log.info("The sum of multiplication with do is {}", sumOfMultiplicationWithDo);
    }
}
