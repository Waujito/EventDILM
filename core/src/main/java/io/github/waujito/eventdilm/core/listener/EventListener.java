package io.github.waujito.eventdilm.core.listener;

import io.github.waujito.eventdilm.core.event.Event;
import io.github.waujito.eventdilm.core.event.ProcessStatus;

/**
 * Represents the event listener.
 */
public interface EventListener<UEvent extends Event> {
    ProcessStatus onEvent(UEvent event);
}