package edu.learning.language.stream;

import lombok.extern.slf4j.Slf4j;

import java.util.stream.Stream;

@Slf4j
public class StreamExample {

    public static void main(String[] args) {

    }

    private void createStream(){
        Stream<String> stream = Stream.of("one", "two", "three");
        log.info(stream.toString());
    }
}
