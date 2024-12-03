package edu.learning.datastructure.intervaltree;

import lombok.Getter;

@Getter
public class Interval {

    private final int start, end;
    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
