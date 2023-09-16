package implementations.chain;

import helpers.events.EventOne;
import helpers.listeners.ListenerWithCounter;
import io.github.waujito.eventdilm.core.managers.chain.ChainEventManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests ChainEventManager
 */
public class TestChainManager {

    /**
     * Tests that the manager calls listener on event properly
     */
    @Test
    void ChainManagerCallsListener() {
        var eventManager = new ChainEventManager<>();
        var event = new EventOne();
        var listener1 = new ListenerWithCounter<>();
        var listener2 = new ListenerWithCounter<>();

        eventManager.registerListener(listener1);
        eventManager.registerListener(listener2);

        for (int i = 0; i < 10; i++) {
            eventManager.onEvent(event);
        }

        assertEquals(10, listener1.getCounter());
        assertEquals(10, listener2.getCounter());
    }

    /**
     * Tests that the manager unregisters listeners properly
     */
    @Test
    void ChainManagerUnregistersListener() {
        var eventManager = new ChainEventManager<>();
        var event = new EventOne();
        var listener1 = new ListenerWithCounter<>();
        var listener2 = new ListenerWithCounter<>();

        var listenerInstance1 = eventManager.registerListener(listener1);
        var listenerInstance2 = eventManager.registerListener(listener2);


        eventManager.onEvent(event);
        eventManager.unregisterListener(listenerInstance1);
        eventManager.onEvent(event);


        assertEquals(1, listener1.getCounter());
        assertEquals(2, listener2.getCounter());
    }

}