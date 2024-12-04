package edu.learning.solutions.competition.aoc2024.day04;

import edu.learning.solutions.competition.aoc2024.FileUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class Solution {

    public static void main(String[] args) {
        DataHandlerImpl dataHandler = new DataHandlerImpl();
        FileUtils.readFile("competition/aoc2024/day04/data.txt", dataHandler);
        char[][] wordGrid = dataHandler.getWordGrid();
        PartOne partOne = new PartOne();
        int wordSearchCount = partOne.wordSearchCount(wordGrid, "XMAS");
        log.info("The word 'XMAS' count in word grid is {}", wordSearchCount);
        PartTwo partTwo = new PartTwo();
        int wordSearchCountMas = partTwo.wordSearchCount(wordGrid, "MAS");
        log.info("The word 'X-MAS' count in word grid is {}", wordSearchCountMas);
    }
}
