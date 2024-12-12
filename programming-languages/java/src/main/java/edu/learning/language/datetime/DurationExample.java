package edu.learning.language.datetime;

import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class DurationExample {

    public static void main(String[] args) {
        List<Duration> durationList = Arrays.asList(
                Duration.ofSeconds(100),
                Duration.ofSeconds(200),
                Duration.ofSeconds(300)
        );
        Duration runningTotal = Duration.ZERO;
        Duration largestDuration = Duration.ofSeconds(Long.MIN_VALUE);
        for (Duration duration : durationList) {
            runningTotal = runningTotal.plus(duration);
            largestDuration = largestDuration.compareTo(duration) > 0 ? largestDuration : duration;
        }
        log.info("The running total is {}", runningTotal);
        log.info("The running total in seconds is {}", runningTotal.getSeconds());
        log.info("The running total in nano seconds is {}", runningTotal.getNano());
        log.info("The running total unit is {}", runningTotal.getUnits());

        long hours = runningTotal.toHours();
        long minutes = runningTotal.minusHours(hours).toMinutes();
        log.info("The running total is {} hrs and {} minutes", hours, minutes);

        log.info("The largest duration is {}", largestDuration);
        log.info("The largest duration in seconds is {}", largestDuration.getSeconds());
        log.info("The largest duration in nano seconds is {}", largestDuration.getNano());
        log.info("The largest duration unit is {}", largestDuration.getUnits());
    }
}
