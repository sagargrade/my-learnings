package edu.learning.solutions.competition.aoc2024.day10;

import edu.learning.solutions.competition.aoc2024.lib.Direction;
import edu.learning.solutions.competition.aoc2024.lib.Point;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class PartTwo {

    public long sumOfRatingOfAllTrailhead(List<List<Integer>> map, List<Point> startPoints) {
        int rows = map.size();
        int columns = map.get(0).size();
        long totalSumOfRating = 0;
        for (Point startPoint : startPoints) {
            totalSumOfRating += depthFirstSearch(map, startPoint, rows, columns);
        }
        return totalSumOfRating;
    }

    private long depthFirstSearch(List<List<Integer>> map, Point startPoint, int rows, int columns) {
        Deque<Point> stack = new ArrayDeque<>();
        Set<Point> reachableNines = new HashSet<>();
        int pathCount = 0;

        stack.offerFirst(startPoint);

        while (!stack.isEmpty()) {
            Point currentPoint = stack.pollLast();
            if (map.get(currentPoint.row()).get(currentPoint.column()) == 9) {
                pathCount++;
                continue;
            }
            for (Direction direction : Direction.values()) {
                if (isValidDirection(direction)) {
                    Point nextPoint = new Point(currentPoint.row() + direction.getRow(), currentPoint.column() + direction.getColumn());
                    if (isValidPoint(nextPoint, rows, columns)) {
                        if (map.get(nextPoint.row()).get(nextPoint.column()) == map.get(currentPoint.row()).get(currentPoint.column()) + 1) {
                            stack.offerFirst(nextPoint);
                        }
                    }
                }
            }
        }
        return pathCount;
    }

    private boolean isValidDirection(Direction direction) {
        return direction.equals(Direction.TOP) || direction.equals(Direction.RIGHT) || direction.equals(Direction.BOTTOM) || direction.equals(Direction.LEFT);
    }

    private boolean isValidPoint(Point point, int rows, int colmuns) {
        return point.row() >= 0 && point.row() < rows && point.column() >= 0 && point.column() < colmuns;
    }

}
