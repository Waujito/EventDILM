package helpers.listeners;

import io.github.waujito.eventdilm.core.event.BaseProcessStatus;
import io.github.waujito.eventdilm.core.event.Event;
import io.github.waujito.eventdilm.core.event.ProcessStatus;
import io.github.waujito.eventdilm.core.listener.EventListener;

/**
 * Counts how many times it was called
 */
public class ListenerWithCounter<UEvent extends Event> implements EventListener<UEvent, ProcessStatus> {
    private int counter = 0;

    public int getCounter() {
        return counter;
    }

    @Override
    public ProcessStatus onEvent(UEvent event) {
        counter++;

        return new BaseProcessStatus();
    }
}