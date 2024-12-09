package edu.learning.solutions.competition.aoc2024.day07;

import lombok.Getter;

@Getter
public enum Operator {
    PLUS('+'),
    MULTIPLY('x'),
    CONCATENATE('|');

    private final char sign;

    private Operator(char sign) {
        this.sign = sign;
    }
}
