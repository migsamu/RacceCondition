package org.iesfm.racecondition.increment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IncrementTask implements Runnable {

    private static final Logger log = LoggerFactory.getLogger(IncrementTask.class);

    private Accumulator accumulator;
    private int times;

    public IncrementTask(Accumulator accumulator, int times) {
        this.accumulator = accumulator;
        this.times = times;
    }

    @Override
    public void run() {
        for (int i = 0; i < times; i++) {
            accumulator.inc();
        }
    }

    public Accumulator getAccumulator() {
        return accumulator;
    }

    public int getTimes() {
        return times;
    }
}
