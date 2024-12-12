package edu.learning.solutions.competition.aoc2024.day12;

import edu.learning.solutions.competition.aoc2024.lib.Direction;
import edu.learning.solutions.competition.aoc2024.lib.Point;

import java.util.LinkedList;
import java.util.Queue;

class PartTwo {
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
        long corners = 0;

        while (!queue.isEmpty()) {
            Point currPoint = queue.poll();
            area++;
            corners = getCorners(map, rows, columns, currPoint, corners);

            for (Direction direction : Direction.values()) {
                if (isValidDirection(direction)) {
                    Point nextPoint = new Point(currPoint.row() + direction.getRow(), currPoint.column() + direction.getColumn());
                    if (isValidPoint(nextPoint, rows, columns)) {
                        if (map[nextPoint.row()][nextPoint.column()] == currPlant) {
                            if (!visited[nextPoint.row()][nextPoint.column()]) {
                                queue.offer(nextPoint);
                                visited[nextPoint.row()][nextPoint.column()] = true;
                            }
                        }
                    }
                }

            }
        }
        return area * corners;
    }

    private long getCorners(char[][] map, int rows, int columns, Point currPoint, long corners) {
        Point pointTop = getNeighbour(map, currPoint, Direction.TOP, rows, columns);
        Point pointRight = getNeighbour(map, currPoint, Direction.RIGHT, rows, columns);
        Point pointBottom = getNeighbour(map, currPoint, Direction.BOTTOM, rows, columns);
        Point pointLeft = getNeighbour(map, currPoint, Direction.LEFT, rows, columns);
        Point pointTopRight = getNeighbour(map, currPoint, Direction.TOP_RIGHT, rows, columns);
        Point pointBottomRight = getNeighbour(map, currPoint, Direction.BOTTOM_RIGHT, rows, columns);
        Point pointTopLeft = getNeighbour(map, currPoint, Direction.TOP_LEFT, rows, columns);
        Point pointBottomLeft = getNeighbour(map, currPoint, Direction.BOTTOM_LEFT, rows, columns);

        if (pointTop == null && pointRight == null) corners++;
        if (pointRight == null && pointBottom == null) corners++;
        if (pointBottom == null && pointLeft == null) corners++;
        if (pointLeft == null && pointTop == null) corners++;
        if (pointTopRight == null && pointTop != null && pointRight != null) corners++;
        if (pointBottomRight == null && pointBottom != null && pointRight != null) corners++;
        if (pointTopLeft == null && pointTop != null && pointLeft != null) corners++;
        if (pointBottomLeft == null && pointBottom != null && pointLeft != null) corners++;
        return corners;
    }

    private Point getNeighbour(char[][] map, Point currPoint, Direction direction, int rows, int columns) {
        Point pointInDir = new Point(currPoint.row() + direction.getRow(), currPoint.column() + direction.getColumn());
        if (isValidPoint(pointInDir, rows, columns)) {
            return (map[currPoint.row()][currPoint.column()] == map[pointInDir.row()][pointInDir.column()]) ? pointInDir : null;
        } else {
            return null;
        }
    }

    private boolean isValidDirection(Direction direction) {
        return direction.equals(Direction.TOP) || direction.equals(Direction.RIGHT) || direction.equals(Direction.BOTTOM) || direction.equals(Direction.LEFT);
    }

    private boolean isValidPoint(Point point, int rows, int colmuns) {
        return point.row() >= 0 && point.row() < rows && point.column() >= 0 && point.column() < colmuns;
    }

}
