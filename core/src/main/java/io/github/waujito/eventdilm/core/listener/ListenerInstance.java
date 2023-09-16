package io.github.waujito.eventdilm.core.listener;

import io.github.waujito.eventdilm.core.event.Event;
import io.github.waujito.eventdilm.core.event.ProcessStatus;

/**
 * Represents registered instance of the listener.
 */
public interface ListenerInstance<UEvent extends Event, UProcessStatus extends ProcessStatus> {

    /**
     * Id of the listener
     */
    String getId();

    EventListener<UEvent, UProcessStatus> getEventListener();
}