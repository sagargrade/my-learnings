package edu.learning.datastructure.intervaltree;

public class IntervalTree {
    private IntervalNode root;

    public void insert(Interval interval) {
        root = insert(root, interval);
    }
    public boolean isPointInRange(int point) {
        return isPointInRange(root, point);
    }

    private IntervalNode insert(IntervalNode node, Interval interval) {
        if (node == null) {
            return new IntervalNode(interval);
        }
        if (interval.getStart() < node.getInterval().getStart()) {
            node.setLeft(insert(node.getLeft(), interval));
        } else {
            node.setRight(insert(node.getRight(), interval));
        }
        node.setMax(Math.max(node.getMax(), interval.getEnd()));
        return node;
    }

    private boolean isPointInRange(IntervalNode node, int point) {
        if (node == null) {
            return false;
        }
        if (point >= node.getInterval().getStart() && point <= node.getInterval().getEnd()) {
            return true;
        }
        if (node.getLeft() != null && point <= node.getLeft().getMax()) {
            return isPointInRange(node.getLeft(), point);
        }
        return isPointInRange(node.getRight(), point);
    }
}
