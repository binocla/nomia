package org.example;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.List;

@Slf4j
public class ActionCounter {

    private final List<Integer> storage;

    public ActionCounter() {
        log.debug(
                """
                "storage" initialized
                """
        );
        storage = new LinkedList<>();
    }

    public void call(int timestamp) {
        log.debug("Incoming timestamp is: {}", timestamp);
        storage.add(timestamp);
    }

    public int getActions(int timestamp) {
        log.debug("Current storage is: {}", timestamp);
        while (!storage.isEmpty() && timestamp - storage.getFirst() >= 300) {
            storage.removeFirst();
        }
        return storage.size();
    }
}
