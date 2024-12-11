package edu.learning.solutions.competition.aoc2024.day09;

import java.util.ArrayList;
import java.util.List;

class PartOne {

    public long calculateFileSystemCheckSum(String diskMap) {
        long fileSystemCheckSum = 0;
        List<Long> fileIdMap = prepareFileIdMap(diskMap);
        List<Long> shiftedFiles = shiftFiles(fileIdMap);
        fileSystemCheckSum = calculateFileCheckSum(shiftedFiles);
        return fileSystemCheckSum;
    }

    private List<Long> prepareFileIdMap(String diskMap) {
        List<Long> fileIdMap = new ArrayList<>();
        boolean isFile = true;
        long fileId = 0;
        for (char value : diskMap.toCharArray()) {
            int count = Integer.parseInt(String.valueOf(value));
            while (count > 0) {
                if (isFile) {
                    fileIdMap.add(fileId);
                } else {
                    fileIdMap.add(-1L);

                }
                count--;
            }
            isFile = !isFile;
            if (isFile) fileId++;
        }
        return fileIdMap;
    }

    private List<Long> shiftFiles(List<Long> fileIdMap) {
        int startPosition = 0;
        int endPosition = fileIdMap.size() - 1;
        while (startPosition < endPosition) {
            if (fileIdMap.get(startPosition) == -1L && fileIdMap.get(endPosition) != -1L) {
                fileIdMap.set(startPosition, fileIdMap.get(endPosition));
                fileIdMap.set(endPosition, -1L);
                startPosition++;
                endPosition--;
            } else if (fileIdMap.get(endPosition) == -1L) {
                endPosition--;
            } else {
                startPosition++;
            }
        }
        return fileIdMap;
    }

    private long calculateFileCheckSum(List<Long> shiftedFiles) {
        long checkSum = 0;
        for(int fileId =0; fileId < shiftedFiles.size(); fileId++){
            if (shiftedFiles.get(fileId) != -1){
                checkSum += fileId * shiftedFiles.get(fileId);
            }
        }
        return checkSum;
    }
}
