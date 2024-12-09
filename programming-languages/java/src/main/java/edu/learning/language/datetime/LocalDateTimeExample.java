package edu.learning.language.datetime;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class LocalDateTimeExample {

    public static void main(String[] args) {
        LocalDate currentDate = LocalDate.now();
        System.out.println(currentDate.getDayOfWeek().equals(DayOfWeek.THURSDAY));
    }
}
