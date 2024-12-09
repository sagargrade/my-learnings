package edu.learning.solutions.competition.aoc2024.day06;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class PartOne {

    private final int[][] DIRECTION = {
            {-1, 0}, // up
            {0, 1}, // right
            {1, 0}, // down
            {0, -1} // left
    };

    public int countOfCellsTravelByGuard(List<char[]> listMap) {
        int[] guardPosition = findGuard(listMap);
        int startX = guardPosition[0];
        int startY = guardPosition[1];
        int directionIndex = guardPosition[2];
        Set<List<Integer>> visitedPositions = countCells(listMap, startX, startY, directionIndex);
        return visitedPositions.size();
    }

    public int[] findGuard(List<char[]> listMap) {
        for (int x = 0; x < listMap.size(); x++) {
            for (int y = 0; y < listMap.get(x).length; y++) {
                char cell = listMap.get(x)[y];
                if (cell == '^') return new int[]{x, y, 0};
                if (cell == '>') return new int[]{x, y, 1};
                if (cell == 'v') return new int[]{x, y, 2};
                if (cell == '<') return new int[]{x, y, 3};
            }
        }
        throw new IllegalStateException("Guard not found");
    }

    private Set<List<Integer>> countCells(List<char[]> listMap, int startX, int startY, int directionIndex) {
        Set<List<Integer>> visitedPosition = new HashSet<>();
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
                visitedPosition.add(List.of(nextX, nextY));
                if (nextX == 0 || nextX == rows - 1 || nextY == 0 || nextY == cols - 1) {
                    directionIndex = -1;
                } else {
                    nextX = nextX + DIRECTION[directionIndex][0];
                    nextY = nextY + DIRECTION[directionIndex][1];
                }
            }
        }
        return visitedPosition;
    }
}
