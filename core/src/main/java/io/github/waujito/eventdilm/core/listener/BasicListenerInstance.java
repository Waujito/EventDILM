package io.github.waujito.eventdilm.core.listener;

import io.github.waujito.eventdilm.core.event.Event;

/**
 * General implementation of the ListenerInstance
 */
public record BasicListenerInstance<UEvent extends Event>(EventListener<UEvent> eventListener, Long id)
        implements ListenerInstance<UEvent> {
}