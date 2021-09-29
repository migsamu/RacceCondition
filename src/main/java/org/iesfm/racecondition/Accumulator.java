package org.iesfm.racecondition;

public class Accumulator {

    private int totalTimes;

    public Accumulator() {
        this.totalTimes = 0;
    }

    public synchronized void inc() {
        totalTimes++;
    }

    public int getTotalTimes() {
        return totalTimes;
    }
}
