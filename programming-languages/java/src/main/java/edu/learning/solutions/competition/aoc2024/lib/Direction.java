package edu.learning.solutions.competition.aoc2024.lib;

import lombok.Getter;

@Getter
public enum Direction {
    TOP(-1, 0),
    RIGHT(0, 1),
    BOTTOM(1, 0),
    LEFT(0, -1);

    private final int row;
    private final int column;

    private Direction(int row, int column) {
        this.row = row;
        this.column = column;
    }
}
