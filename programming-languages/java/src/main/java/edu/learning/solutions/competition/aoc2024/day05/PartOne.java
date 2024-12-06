package edu.learning.solutions.competition.aoc2024.day05;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class PartOne {

    public int sumOfMiddleElementOfCorrectOrderList(List<List<Integer>> updates, List<List<Integer>> rules) {
        int sumOfMiddleElement = 0;
        for (List<Integer> update : updates) {
            if (isUpdateValid(update, rules)) {
                sumOfMiddleElement += findMiddleElement(update);
            }
        }
        return sumOfMiddleElement;
    }

    public boolean isUpdateValid(List<Integer> update, List<List<Integer>> rules) {
        Map<Integer, Integer> pageIndex = new HashMap<>();
        for (int i = 0; i < update.size(); i++) {
            pageIndex.put(update.get(i), i);
        }

        for (List<Integer> rule : rules) {
            int x = rule.get(0);
            int y = rule.get(1);
            if (pageIndex.containsKey(x) && pageIndex.containsKey(y)) {
                if (pageIndex.get(x) >= pageIndex.get(y)) {
                    return false;
                }
            }
        }
        return true;
    }

    public int findMiddleElement(List<Integer> update) {
        return update.get(update.size() / 2);
    }

}
