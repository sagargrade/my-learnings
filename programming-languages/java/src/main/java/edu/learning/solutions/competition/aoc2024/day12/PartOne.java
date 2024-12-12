package edu.learning.solutions.competition.aoc2024.day12;

import edu.learning.solutions.competition.aoc2024.lib.Direction;
import edu.learning.solutions.competition.aoc2024.lib.Point;

import java.util.LinkedList;
import java.util.Queue;

class PartOne {

    public long totalPriceOfFencingAllRegion(char[][] map) {
        long totalPrice = 0;
        int rows = map.length;
        int columns = map[0].length;
        boolean[][] visited = new boolean[rows][columns];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                if (!visited[row][col]) {
                    Point point = new Point(row, col);
                    totalPrice += calculatePriceOfRegion(map, point, visited, rows, columns);
                }
            }
        }
        return totalPrice;
    }

    private long calculatePriceOfRegion(char[][] map, Point point, boolean[][] visited, int rows, int columns) {
        char currPlant = map[point.row()][point.column()];
        Queue<Point> queue = new LinkedList<>();
        queue.offer(point);
        visited[point.row()][point.column()] = true;
        long area = 0;
        long perimeter = 0;

        while (!queue.isEmpty()) {
            Point currPoint = queue.poll();
            area++;
            for (Direction direction : Direction.values()) {
                if (isValidDirection(direction)) {
                    Point nextPoint = new Point(currPoint.row() + direction.getRow(), currPoint.column() + direction.getColumn());
                    if (isValidPoint(nextPoint, rows, columns)) {
                        if (map[nextPoint.row()][nextPoint.column()] == currPlant) {
                            if (!visited[nextPoint.row()][nextPoint.column()]) {
                                queue.offer(nextPoint);
                                visited[nextPoint.row()][nextPoint.column()] = true;
                            }
                        } else {
                            perimeter++;
                        }
                    } else {
                        perimeter++;
                    }
                }

            }
        }
        return area * perimeter;
    }

    private boolean isValidDirection(Direction direction) {
        return direction.equals(Direction.TOP) || direction.equals(Direction.RIGHT) || direction.equals(Direction.BOTTOM) || direction.equals(Direction.LEFT);
    }

    private boolean isValidPoint(Point point, int rows, int colmuns) {
        return point.row() >= 0 && point.row() < rows && point.column() >= 0 && point.column() < colmuns;
    }
}
