package edu.learning.solutions.competition.aoc2024.day09;

class PartTwo {

    public long calculateWholeFileSystemCheckSum(String diskMap) {

        int[] fileSystem = new int[diskMap.length()];
        for (int i = 0; i < fileSystem.length; i++) {
            fileSystem[i] = diskMap.charAt(i) - '0';
        }
        long fileSystemCheckSum = 0;

        int[] fileIndex = new int[fileSystem.length];
        fileIndex[0] = 0;
        for (int i = 1; i < fileSystem.length; i++) {
            fileIndex[i] = fileIndex[i - 1] + fileSystem[i - 1];
        }

        for (int right = fileSystem.length - 1; right >= 0; right -= 2) {
            boolean found = false;
            for (int left = 1; left < right; left += 2) {
                if (fileSystem[left] >= fileSystem[right]) {
                    for (int i = 0; i < fileSystem[right]; i++) {
                        fileSystemCheckSum += (long) (right / 2) * (fileIndex[left] + i);
                    }
                    fileSystem[left] -= fileSystem[right];
                    fileIndex[left] += fileSystem[right];
                    found = true;
                    break;
                }
            }
            if (!found) {
                for (int i = 0; i < fileSystem[right]; i++) {
                    fileSystemCheckSum += (long) (right / 2) * (fileIndex[right] + i);
                }
            }
        }
        return fileSystemCheckSum;
    }
}
