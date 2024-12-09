package edu.learning.solutions.competition.aoc2024.day07;

import edu.learning.solutions.competition.aoc2024.FileUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class Solution {

    public static void main(String[] args) {
        DataHandlerImpl dataHandler = new DataHandlerImpl();
        FileUtils.readFile("competition/aoc2024/day07/data.txt", dataHandler);
        PartOne partOne = new PartOne();
        long calibrationResult = partOne.getTotalCalibrationResult(dataHandler.getEquationMap());
        log.info("The total calibration result is {}", calibrationResult);
        PartTwo partTwo = new PartTwo();
        long calibrationResultWithConcat = partTwo.getTotalCalibrationResult(dataHandler.getEquationMap());
        log.info("The total calibration result with concat is {}", calibrationResultWithConcat);
    }

}
