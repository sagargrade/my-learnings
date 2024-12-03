package edu.learning.solutions.competition.aoc2024.day03;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class PartOne {

    public long sumOfMultiplication(List<String> memory){
        long sumOfMultiply = 0;
        String regularExp = "mul\\((\\d{1,3}),(\\d{1,3})\\)";
        Pattern pattern = Pattern.compile(regularExp);
        for(String line: memory){
            Matcher matcher = pattern.matcher(line);
            while(matcher.find()){
                long firstValue = Long.parseLong(matcher.group(1));
                long secondvalue = Long.parseLong(matcher.group(2));
                sumOfMultiply += (firstValue * secondvalue);
            }
        }
        return sumOfMultiply;
    }
}
