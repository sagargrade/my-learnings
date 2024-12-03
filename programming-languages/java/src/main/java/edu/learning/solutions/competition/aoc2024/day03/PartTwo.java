package edu.learning.solutions.competition.aoc2024.day03;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class PartTwo {

    public long sumOfMultiplicationWithDo(List<String> memory) {
        long sumOfMultiply = 0;
        String regularExp = "mul\\((\\d{1,3}),(\\d{1,3})\\)";
        String doRegularExp = "do\\(\\)";
        String dontRegularExp = "don't\\(\\)";
        Pattern pattern = Pattern.compile(regularExp + "|" + doRegularExp + "|" + dontRegularExp);
        boolean performMultiplication = true;
        for (String line : memory) {
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                if (matcher.group(1) != null) {
                    if (performMultiplication) {
                        long firstValue = Long.parseLong(matcher.group(1));
                        long secondvalue = Long.parseLong(matcher.group(2));
                        sumOfMultiply += (firstValue * secondvalue);
                    }
                }
                if (matcher.group(0).equals("do()")) {
                    performMultiplication = true;
                }
                if (matcher.group(0).equals("don't()")) {
                    performMultiplication = false;
                }
            }
        }
        return sumOfMultiply;
    }
}
