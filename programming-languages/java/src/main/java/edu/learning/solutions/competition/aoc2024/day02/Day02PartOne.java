package edu.learning.solutions.competition.aoc2024.day02;

import java.util.ArrayList;
import java.util.List;

public class Day02PartOne {

    public int getSafeReportCount(List<List<Integer>> reports) {
        int safeReportCount = 0;
        for (List<Integer> report : reports) {
            if (isReportSafe(report)) safeReportCount++;
        }
        return safeReportCount;
    }

    public boolean isReportSafe(List<Integer> report) {
        List<Integer> differences = new ArrayList<>();
        for (int i = 0; i < report.size() - 1; i++) {
            differences.add(report.get(i + 1) - report.get(i));
        }

        boolean allIncreasing = true;
        boolean allDecreasing = true;
        for (int value : differences) {
            if (value <= 0) allIncreasing = false;
            if (value >= 0) allDecreasing = false;
        }

        boolean isDifferenceInRange = true;
        for (int value : differences) {
            if (Math.abs(value) < 1 || Math.abs(value) > 3) {
                isDifferenceInRange = false;
                break;
            }
        }

        return (allIncreasing || allDecreasing) && isDifferenceInRange;
    }
}
