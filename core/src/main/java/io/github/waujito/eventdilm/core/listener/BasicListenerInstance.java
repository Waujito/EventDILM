package io.github.waujito.eventdilm.core.listener;

/**
 * General implementation of the ListenerInstance
 */
public record BasicListenerInstance<UEventListener extends EventListener<?, ?>>(UEventListener eventListener, Long id)
        implements ListenerInstance<UEventListener> {
}