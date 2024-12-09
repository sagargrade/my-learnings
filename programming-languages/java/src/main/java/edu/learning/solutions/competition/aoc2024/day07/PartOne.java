package edu.learning.solutions.competition.aoc2024.day07;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class PartOne {

    private long totalCalibration;

    public long getTotalCalibrationResult(Map<Long, List<Long>> equationMap) {

        totalCalibration = 0;
        equationMap.forEach((result, values) -> {
            if (isEquationValid(values, result)) {
                totalCalibration += result;
            }
        });
        return totalCalibration;
    }

    private boolean isEquationValid(List<Long> values, Long result) {
        List<char[]> operatorCombination = determineOperatorCombination(values.size() - 1);
        for (char[] combination : operatorCombination) {
            long calculatedValue = values.get(0);
            for (int i = 1; i < values.size(); i++) {
                if (combination[i - 1] == Operator.PLUS.getSign()) {
                    calculatedValue += values.get(i);
                } else {
                    calculatedValue *= values.get(i);
                }
            }
            if (calculatedValue == result) {
                return true;
            }
        }
        return false;
    }

    private List<char[]> determineOperatorCombination(int numberOfOperators) {
        List<char[]> operatorCombination = new ArrayList<>();
        char[] operators = new char[]{Operator.PLUS.getSign(), Operator.MULTIPLY.getSign()};
        getAllPossiblePermutationWithRepetition(operators, "", numberOfOperators, operatorCombination);
        return operatorCombination;
    }

    public void getAllPossiblePermutationWithRepetition(char[] operators, String prefix, int count, List<char[]> operatorCombinations) {
        if (count == 0) {
            operatorCombinations.add(prefix.toCharArray());
            return;
        }
        for (char operator : operators) {
            getAllPossiblePermutationWithRepetition(operators, prefix + operator, count - 1, operatorCombinations);
        }
    }
}
