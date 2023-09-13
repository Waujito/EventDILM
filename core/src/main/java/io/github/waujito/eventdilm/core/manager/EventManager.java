package io.github.waujito.eventdilm.core.manager;

import io.github.waujito.eventdilm.core.event.Event;
import io.github.waujito.eventdilm.core.event.ProcessStatus;
import io.github.waujito.eventdilm.core.listener.EventListener;
import io.github.waujito.eventdilm.core.listener.ListenerInstance;
import io.github.waujito.eventdilm.core.manager.exceptions.ListenerAlreadyRegisteredException;
import io.github.waujito.eventdilm.core.manager.exceptions.ListenerDoesNotExistException;
import io.github.waujito.eventdilm.core.manager.exceptions.ListenerRegistrationFailedException;
import io.github.waujito.eventdilm.core.manager.exceptions.ListenerUnregistartionFailedException;

/**
 * Operates with event listeners.
 * The main interface of DILM abstraction.
 * <p>
 * Extends {@link EventListener} to make it possible to use this manager as listener with other managers.
 */
public interface EventManager extends EventListener {

    /**
     * Registers the event listener.
     *
     * @param listener Event listener
     * @return id of the listener
     * @throws ListenerRegistrationFailedException Registration of the listener has failed.
     * @throws ListenerAlreadyRegisteredException  Listener is already registered
     */
    ListenerInstance registerListener(EventListener listener) throws ListenerAlreadyRegisteredException, ListenerRegistrationFailedException;

    /**
     * Unregisters the event listener
     *
     * @param listenerInstance Registered event listener
     * @throws ListenerUnregistartionFailedException Deletion of the listener has failed.
     * @throws ListenerDoesNotExistException         The listener is not registered
     */
    void unregisterListener(ListenerInstance listenerInstance) throws ListenerUnregistartionFailedException;

    /**
     * Process an event through the listeners.
     *
     * @return Status of the processing
     */
    @Override
    ProcessStatus onEvent(Event event);
}