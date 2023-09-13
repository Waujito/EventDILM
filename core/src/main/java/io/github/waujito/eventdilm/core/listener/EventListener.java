package io.github.waujito.eventdilm.core.listener;

import io.github.waujito.eventdilm.core.event.Event;
import io.github.waujito.eventdilm.core.event.ProcessStatus;

/**
 * Represents the event listener.
 */
public interface EventListener {
    ProcessStatus onEvent(Event event);
}