package io.github.waujito.eventdilm.core.listener;

/**
 * Represents registered instance of the listener.
 */
public interface ListenerInstance<UEventListener extends EventListener<?, ?>> {

    /**
     * Id of the listener
     */
    Long id();

    UEventListener eventListener();
}