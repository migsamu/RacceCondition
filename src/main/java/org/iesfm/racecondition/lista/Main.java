package org.iesfm.racecondition.lista;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);


    public static void main(String[] args) {

        List<Integer> lista = new Vector<>();
        List<Thread> threads = new LinkedList<>();
        for (int i = 0; i < 100; i++) {
            Thread t = new Thread(new AddToListTask(lista, 100000));
            t.start();
            threads.add(t);
        }

        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        log.info("Hay " + lista.size() + " elementos en la lista");
    }
}
