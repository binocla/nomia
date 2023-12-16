package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ActionCounterTest {

    private static ActionCounter counter;

    @BeforeAll
    static void init() {
        counter = new ActionCounter();
    }

    @Test
    void testGetActions() {
        counter.call(1);
        counter.call(2);
        counter.call(2);
        assertEquals(3, counter.getActions(4));

        counter.call(300);
        assertEquals(4, counter.getActions(300));
        assertEquals(3, counter.getActions(301));
        assertEquals(1, counter.getActions(302));
    }
}
