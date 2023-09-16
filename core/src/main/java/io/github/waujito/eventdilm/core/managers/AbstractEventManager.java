package io.github.waujito.eventdilm.core.managers;

import io.github.waujito.eventdilm.core.event.Event;
import io.github.waujito.eventdilm.core.event.ProcessStatus;
import io.github.waujito.eventdilm.core.listener.BasicListenerInstance;
import io.github.waujito.eventdilm.core.listener.EventListener;
import io.github.waujito.eventdilm.core.listener.ListenerInstance;
import io.github.waujito.eventdilm.core.manager.EventManager;
import io.github.waujito.eventdilm.core.manager.exceptions.ListenerAlreadyRegisteredException;
import io.github.waujito.eventdilm.core.manager.exceptions.ListenerDoesNotExistException;
import io.github.waujito.eventdilm.core.manager.exceptions.ListenerRegistrationFailedException;
import io.github.waujito.eventdilm.core.manager.exceptions.ListenerUnregistrationFailedException;

import java.util.HashMap;

/**
 * Abstract event manager that implements most general of the EventManager methods
 */
public abstract class AbstractEventManager<UEvent extends Event>
        implements EventManager<UEvent> {

    /**
     * Collects all registered event listeners
     */
    protected final HashMap<Long, ListenerInstance<UEvent>> listeners;

    private Long i = 0L;

    protected AbstractEventManager() {
        this.listeners = new HashMap<>();
    }

    /**
     * Registers the event listener.
     *
     * @param listener Event listener
     * @return id of the listener
     * @throws ListenerRegistrationFailedException Registration of the listener has failed.
     * @throws ListenerAlreadyRegisteredException  Listener is already registered
     */
    @Override
    public ListenerInstance<UEvent> registerListener(EventListener<UEvent> listener) {
        var id = i++;

        var listenerInstance = new BasicListenerInstance<>(listener, id);
        listeners.put(id, listenerInstance);

        return listenerInstance;
    }

    /**
     * Unregisters the event listener
     *
     * @param listenerInstance Registered event listener
     * @throws ListenerUnregistrationFailedException Deletion of the listener has failed.
     * @throws ListenerDoesNotExistException         The listener is not registered
     */
    @Override
    public void unregisterListener(ListenerInstance<UEvent> listenerInstance) {
        listeners.remove(listenerInstance.id());
    }

    /**
     * Process an event through the listeners.
     *
     * @return Status of the processing
     */
    @Override
    public abstract ProcessStatus onEvent(UEvent event);
}