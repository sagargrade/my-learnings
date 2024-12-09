package edu.learning.solutions.competition.aoc2024.day06;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
class PartTwo {

    private final PartOne partOne;
    private boolean loopFound;

    private final int[][] DIRECTION = {
            {-1, 0}, // up
            {0, 1}, // right
            {1, 0}, // down
            {0, -1} // left
    };

    public int findObstructionPosition(List<char[]> labMap) {
        Set<Set<Position>> uniqueLoops = new HashSet<>();
        int rows = labMap.size();
        int cols = labMap.get(0).length;
        int[] guardPosition = partOne.findGuard(labMap);
        int startX = guardPosition[0];
        int startY = guardPosition[1];
        int directionIndex = guardPosition[2];
        labMap.get(startX)[startY] = '.';
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                if (labMap.get(x)[y] == '.') {
                    labMap.get(x)[y] = '#';
                    loopFound = false;
                    Set<Position> loop = getLoop(labMap, startX, startY, directionIndex);
                    if (loopFound) {
                        if (loop.size() < rows * cols) uniqueLoops.add(loop);
                    }
                    labMap.get(x)[y] = '.';
                }
            }
        }
        return uniqueLoops.size();
    }

    private Set<Position> getLoop(List<char[]> listMap, int startX, int startY, int directionIndex) {
        Set<Position> positions = new HashSet<>();
        int rows = listMap.size();
        int cols = listMap.get(0).length;
        int nextX = startX;
        int nextY = startY;
        while (directionIndex != -1) {
            if (listMap.get(nextX)[nextY] == '#') {
                // Move one step back
                nextX = nextX - DIRECTION[directionIndex][0];
                nextY = nextY - DIRECTION[directionIndex][1];
                // Go for next direction
                directionIndex = (directionIndex + 1) % 4;
                nextX = nextX + DIRECTION[directionIndex][0];
                nextY = nextY + DIRECTION[directionIndex][1];
            } else {
                if (!positions.add(new Position(nextX, nextY, directionIndex))) {
                    loopFound = true;
                    break;
                }
                if (nextX == 0 || nextX == rows - 1 || nextY == 0 || nextY == cols - 1) {
                    directionIndex = -1;
                } else {
                    nextX = nextX + DIRECTION[directionIndex][0];
                    nextY = nextY + DIRECTION[directionIndex][1];
                }
            }
        }
        return positions;
    }
}

@EqualsAndHashCode
@AllArgsConstructor
@ToString
class Position {
    int x;
    int y;
    int directionIndex;
}
