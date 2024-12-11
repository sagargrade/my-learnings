package edu.learning.solutions.competition.aoc2024.day09;

import edu.learning.solutions.competition.aoc2024.Solution;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class SolutionImpl extends Solution {

    public static void main(String[] args) {
        SolutionImpl solution = new SolutionImpl();
        DataHandlerImpl dataHandler = new DataHandlerImpl();
        solution.readFile("competition/aoc2024/day09/data.txt", dataHandler);
        PartOne partOne = new PartOne();
        long fileSystemCheckSum = partOne.calculateFileSystemCheckSum(dataHandler.getDiskMap());
        log.info("The file system check sum is {}", fileSystemCheckSum);
        PartTwo partTwo = new PartTwo();
        long wholeFileSystemCheckSum = partTwo.calculateWholeFileSystemCheckSum(dataHandler.getDiskMap());
        log.info("The file system check sum in another way is {}", wholeFileSystemCheckSum);
    }
}
