package edu.learning.solutions.competition.aoc2024.day02;

import java.util.ArrayList;
import java.util.List;

class PartTwo {

    private final PartOne partOne;

    public PartTwo(PartOne partOne) {
        this.partOne = partOne;
    }

    public int getSafeReportCountWithTolerate(List<List<Integer>> reports) {
        int safeReportCount = 0;
        for (List<Integer> report : reports) {
            if (isReportSafeWithRemoval(report)) safeReportCount++;
        }
        return safeReportCount;
    }

    private boolean isReportSafeWithRemoval(List<Integer> report) {
        for (int i = 0; i < report.size(); i++) {
            List<Integer> modifiedReport = new ArrayList<>(report);
            modifiedReport.remove(i);
            if (partOne.isReportSafe(modifiedReport)) {
                return true;
            }
        }
        return false;
    }
}
