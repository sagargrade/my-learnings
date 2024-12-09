package edu.learning.solutions.competition.aoc2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

public abstract class Solution {

    public void readFile(String fileLocation, DataHandler dataHandler) {
        try (BufferedReader reader = Files.newBufferedReader(loadFilePath(fileLocation))) {
            reader.lines().forEach(dataHandler::getLocationList);
        } catch (IOException ex) {
            throw new RuntimeException("Error reading file ", ex);
        }
    }

    private Path loadFilePath(String fileLocation) {
        ClassLoader classLoader = FileUtils.class.getClassLoader();
        URL resource = classLoader.getResource(fileLocation);
        if (resource == null) {
            throw new IllegalArgumentException("File not found : " + fileLocation);
        }
        try {
            return Path.of(resource.toURI());
        } catch (URISyntaxException ex) {
            throw new RuntimeException("Error loading file from classpath ", ex);
        }
    }
}
