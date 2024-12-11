package edu.learning.solutions.competition.aoc2024.day10;

import edu.learning.solutions.competition.aoc2024.lib.Direction;
import edu.learning.solutions.competition.aoc2024.lib.Point;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class PartOne {

    public long sumOfScoreOfAllTrailHeads(List<List<Integer>> map, List<Point> startPoints) {
        int rows = map.size();
        int columns = map.get(0).size();
        long totalScore = 0;
        for (Point startPoint : startPoints) {
            totalScore += breadthFirstSearch(map, startPoint, rows, columns);
        }
        return totalScore;
    }

    private long breadthFirstSearch(List<List<Integer>> map, Point startPoint, int rows, int columns) {
        boolean[][] visited = new boolean[rows][columns];
        Queue<Point> queue = new LinkedList<>();
        Set<Point> reachableNines = new HashSet<>();

        queue.offer(startPoint);
        visited[startPoint.row()][startPoint.column()] = true;

        while (!queue.isEmpty()) {
            Point currentPoint = queue.poll();
            if (map.get(currentPoint.row()).get(currentPoint.column()) == 9) {
                reachableNines.add(currentPoint);
            }
            for (Direction direction : Direction.values()) {
                if (isValidDirection(direction)) {
                    Point nextPoint = new Point(currentPoint.row() + direction.getRow(), currentPoint.column() + direction.getColumn());
                    if (isValidPoint(nextPoint, rows, columns) && !visited[nextPoint.row()][nextPoint.column()]) {
                        if (map.get(nextPoint.row()).get(nextPoint.column()) == map.get(currentPoint.row()).get(currentPoint.column()) + 1) {
                            queue.offer(nextPoint);
                            visited[nextPoint.row()][nextPoint.column()] = true;
                        }
                    }
                }
            }
        }
        return reachableNines.size();
    }

    private boolean isValidDirection(Direction direction) {
        return direction.equals(Direction.TOP) || direction.equals(Direction.RIGHT) || direction.equals(Direction.BOTTOM) || direction.equals(Direction.LEFT);
    }

    private boolean isValidPoint(Point point, int rows, int colmuns) {
        return point.row() >= 0 && point.row() < rows && point.column() >= 0 && point.column() < colmuns;
    }
}
