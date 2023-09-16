package io.github.waujito.eventdilm.core.listener;

import io.github.waujito.eventdilm.core.event.Event;

/**
 * Represents registered instance of the listener.
 */
public interface ListenerInstance<UEvent extends Event> {

    /**
     * Id of the listener
     */
    Long id();

    EventListener<UEvent> eventListener();
}