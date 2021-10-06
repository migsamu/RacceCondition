package org.iesfm.racecondition.increment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        Accumulator accumulator = new Accumulator();

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(new IncrementTask(accumulator, 10000000));
            thread.start();
            threads.add(thread);
        }

        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        log.info("Incrementa un total de " + accumulator.getTotalTimes() + " veces");

    }
}
