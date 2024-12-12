package edu.learning.solutions.competition.aoc2024.day11;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class PartTwo {
    private final Map<String, Long> stoneNumberMap = new HashMap<>();

    public int numberOfStoneAfterBlinksOptimize(List<Long> stoneNumber, int numberOfBlink) {
        Queue<Long> stoneNumberQueue = new LinkedList<>(stoneNumber);
        for (int blink = 0; blink < numberOfBlink; blink++) {
            int initialSize = stoneNumberQueue.size();
            for (int index = 0; index < initialSize; index++) {
                Long currentStone = stoneNumberQueue.poll();
                if (currentStone == 0) {
                    stoneNumberQueue.offer(1L);
                } else {
                    String stringFormat = currentStone.toString();
                    if (stringFormat.length() % 2 == 0) {
                        int mid = stringFormat.length() / 2;
                        stoneNumberQueue.offer(Long.parseLong(stringFormat.substring(0, mid)));
                        stoneNumberQueue.offer(Long.parseLong(stringFormat.substring(mid)));
                    } else {
                        stoneNumberQueue.offer(currentStone * 2024);
                    }
                }
            }
        }
        return stoneNumberQueue.size();
    }

    public long numberOfStoneAfterBlinksOptimizeFurther(List<Long> stoneNumber, int numberOfBlink) {
        long totalSize = 0;
        for (Long stone : stoneNumber) {
            totalSize += calculateSize(stone, numberOfBlink);
        }
        return totalSize;
    }

    private long calculateSize(long stoneNumber, int blinkCount) {
        String key = blinkCount + "-" + stoneNumber;
        if (stoneNumberMap.containsKey(key)) {
            return stoneNumberMap.get(key);
        }

        if (blinkCount == 0) return 1;
        if (stoneNumber == 0) {
            long calculatedSize = calculateSize(1L, blinkCount - 1);
            stoneNumberMap.put(key, calculatedSize);
            return calculatedSize;
        }
        String stoneNumberString = String.valueOf(stoneNumber);
        if (stoneNumberString.length() % 2 == 0) {
            int mid = stoneNumberString.length() / 2;
            long leftPart = Long.parseLong(stoneNumberString.substring(0, mid));
            long rightPart = Long.parseLong(stoneNumberString.substring(mid));
            long calculatedSize = calculateSize(leftPart, blinkCount - 1) + calculateSize(rightPart, blinkCount - 1);
            stoneNumberMap.put(key, calculatedSize);
            return calculatedSize;
        }
        long calculatedSize = calculateSize(stoneNumber * 2024, blinkCount - 1);
        stoneNumberMap.put(key, calculatedSize);
        return calculatedSize;
    }

}
