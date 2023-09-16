package io.github.waujito.eventdilm.core.managers.chain;

import io.github.waujito.eventdilm.core.event.BaseProcessStatus;
import io.github.waujito.eventdilm.core.event.Event;
import io.github.waujito.eventdilm.core.managers.AbstractEventManager;

/**
 * Processes events through all the registered listeners.
 * <b>The order of the listeners in the chain may vary.</b>
 */
public class ChainEventManager<UEvent extends Event>
        extends AbstractEventManager<UEvent> {

    public ChainEventManager() {
        super();
    }

    /**
     * Process an event through the listeners.
     *
     * @return Status of the processing
     */
    @Override
    public BaseProcessStatus onEvent(UEvent event) {
        for (var listenerInstance : this.listeners.values()) {
            listenerInstance.eventListener().onEvent(event);
        }

        return new BaseProcessStatus();
    }
}