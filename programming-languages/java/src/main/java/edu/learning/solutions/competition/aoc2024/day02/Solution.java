package edu.learning.solutions.competition.aoc2024.day02;

import edu.learning.solutions.competition.aoc2024.FileUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class Solution {

    public static void main(String[] args) {
        DataHandlerImpl dataHandler = new DataHandlerImpl();
        FileUtils.readFile("competition/aoc2024/day02/data.txt", dataHandler);
        PartOne partOne = new PartOne();
        PartTwo partTwo = new PartTwo(partOne);
        int safeReportCount = partOne.getSafeReportCount(dataHandler.getReports());
        log.info("The number of safe reports are {}", safeReportCount);
        int safeReportCountWithTolerate = partTwo.getSafeReportCountWithTolerate(dataHandler.getReports());
        log.info("The number of safe report including tolerance are {}", safeReportCountWithTolerate);
    }
}

