package edu.learning.solutions.competition.aoc2024.day05;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@AllArgsConstructor
class PartTwo {

    private final PartOne partOne;

    public int sumOfMiddleElementOfCorrectedList(List<List<Integer>> updates, List<List<Integer>> rules) {
        int sumOfMiddleElement = 0;
        for (List<Integer> update : updates) {
            if (!partOne.isUpdateValid(update, rules)) {
                List<Integer> correctUpdate = getCorrectedUpdate(update, rules);
                sumOfMiddleElement += partOne.findMiddleElement(correctUpdate);
            }
        }
        return sumOfMiddleElement;
    }

    private List<Integer> getCorrectedUpdate(List<Integer> update, List<List<Integer>> rules) {
        Set<Integer> pages = new HashSet<>(update);
        Map<Integer, List<Integer>> dependencies = new HashMap<>();
        for (List<Integer> rule : rules) {
            if (pages.contains(rule.get(0)) && pages.contains(rule.get(1))) {
                dependencies.computeIfAbsent(rule.get(0), k -> new ArrayList<>()).add(rule.get(1));
            }
        }
        List<Integer> correctedUpdate = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        for (Integer page : update) {
            if (!visited.contains(page)) {
                dfs(page, dependencies, visited, correctedUpdate);
            }
        }
        return correctedUpdate;
    }

    private void dfs(Integer page, Map<Integer, List<Integer>> dependencies, Set<Integer> visited, List<Integer> sortedPages) {
        visited.add(page);
        if (dependencies.containsKey(page)) {
            for (Integer dep : dependencies.get(page)) {
                if (!visited.contains(dep)) {
                    dfs(dep, dependencies, visited, sortedPages);
                }
            }
        }
        sortedPages.add(page);
    }

}
