package edu.learning.solutions.competition.aoc2024.day08;

import edu.learning.solutions.competition.aoc2024.lib.Point;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PartTwo {

    public int countOfLocationOfAntiNodesAnyDistance(List<char[]> antennaMap) {
        Map<Character, List<Point>> antennaPositionMap = new LinkedHashMap<>();
        int rows = antennaMap.size();
        int columns = antennaMap.get(0).length;
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < columns; y++) {
                char cell = antennaMap.get(x)[y];
                if (Character.isLetterOrDigit(cell)) {
                    antennaPositionMap.computeIfAbsent(cell, k -> new ArrayList<>()).add(new Point(x, y));
                }
            }
        }
        Set<String> uniqueAntiNodes = new HashSet<>();
        for (Map.Entry<Character, List<Point>> entry : antennaPositionMap.entrySet()) {
            List<Point> antennaPosition = entry.getValue();
            for (int i = 0; i < antennaPosition.size(); i++) {
                for (int j = i + 1; j < antennaPosition.size(); j++) {
                    Point first = antennaPosition.get(i);
                    Point second = antennaPosition.get(j);

                    int differenceX = second.row() - first.row();
                    int differenceY = second.column() - first.column();

                    int currentRow = first.row();
                    int currentColumn = first.column();
                    while (currentRow != second.row() || currentColumn != second.column()) {
                        addAntiNode(currentRow, currentColumn, antennaMap, uniqueAntiNodes);
                        currentRow += differenceX;
                        currentColumn += differenceY;
                    }
                    addAntiNode(second.row(), second.column(), antennaMap, uniqueAntiNodes);

                    int firstAntiNodeRow = first.row() - differenceX;
                    int firstAntiNodeColumn = first.column() - differenceY;

                    while (firstAntiNodeRow >= 0 && firstAntiNodeRow < rows && firstAntiNodeColumn >= 0 && firstAntiNodeColumn < columns) {
                        addAntiNode(firstAntiNodeRow, firstAntiNodeColumn, antennaMap, uniqueAntiNodes);
                        firstAntiNodeRow = firstAntiNodeRow - differenceX;
                        firstAntiNodeColumn = firstAntiNodeColumn - differenceY;
                    }

                    int secondAntiNodeRow = second.row() + differenceX;
                    int secondAntiNodeColumn = second.column() + differenceY;

                    while (secondAntiNodeRow >= 0 && secondAntiNodeRow < rows && secondAntiNodeColumn >= 0 && secondAntiNodeColumn < columns) {
                        addAntiNode(secondAntiNodeRow, secondAntiNodeColumn, antennaMap, uniqueAntiNodes);
                        secondAntiNodeRow = secondAntiNodeRow + differenceX;
                        secondAntiNodeColumn = secondAntiNodeColumn + differenceY;
                    }
                }
            }
        }
        return uniqueAntiNodes.size();
    }

    private void addAntiNode(int row, int column, List<char[]> antennaMap, Set<String> uniqueAntiNodes) {
        if (row >= 0 && row < antennaMap.size() && column >= 0 && column < antennaMap.get(0).length) {
            uniqueAntiNodes.add(row + " - " + column);
        }
    }
}
