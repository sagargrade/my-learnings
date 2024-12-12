package edu.learning.language.datetime;

import lombok.extern.slf4j.Slf4j;

import java.time.Clock;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.temporal.TemporalAdjusters;

@Slf4j
public class LocalDateExample {

    public static void main(String[] args) {
        LocalDateExample dateExample = new LocalDateExample();
        Clock clock = dateExample.getCloak();
        log.info("The current clock is {}", clock);
        LocalDate clockDate = dateExample.getClockDate(clock);
        log.info("The cloak data is {}", clockDate);
        LocalDate nextMondayDate = clockDate.with(TemporalAdjusters.nextOrSame(DayOfWeek.MONDAY));
        log.info("The next monday date from cloak date is {}", nextMondayDate);
        LocalDate dateAfterTenDays = clockDate.plusDays(10);
        log.info("The date after 10 days is {}", dateAfterTenDays);
    }

    private Clock getCloak() {
        return Clock.fixed(Instant.now(), ZoneOffset.UTC);
    }

    private LocalDate getClockDate(Clock clock) {
        return LocalDate.now(clock);
    }
}
