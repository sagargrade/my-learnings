package edu.learning.datastructure.intervaltree;

import lombok.Getter;
import lombok.Setter;

@Getter
public class IntervalNode {
    private final Interval interval;
    @Setter
    private int max;
    @Setter
    private IntervalNode left, right;

    public IntervalNode(Interval interval){
        this.interval = interval;
        this.max = interval.getEnd();
    }

}
