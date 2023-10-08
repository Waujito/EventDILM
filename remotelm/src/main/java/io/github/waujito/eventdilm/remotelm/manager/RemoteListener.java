package io.github.waujito.eventdilm.remotelm.manager;

import io.github.waujito.eventdilm.core.event.Event;
import io.github.waujito.eventdilm.core.event.ProcessStatus;
import io.github.waujito.eventdilm.core.listener.EventListener;
import io.github.waujito.eventdilm.remotelm.converters.ObjectStringConverter;
import io.github.waujito.eventdilm.remotelm.messaging.MessagingClient;

public class RemoteListener<UEvent extends Event, UStatus extends ProcessStatus>
        implements EventListener<UEvent, UStatus> {
    private final ObjectStringConverter<UEvent> eventConverter;
    private final ObjectStringConverter<UStatus> statusConverter;
    private final MessagingClient messagingClient;

    public RemoteListener(
            MessagingClient messagingClient,
            ObjectStringConverter<UEvent> eventConverter,
            ObjectStringConverter<UStatus> statusConverter
    ) {
        this.eventConverter = eventConverter;
        this.messagingClient = messagingClient;
        this.statusConverter = statusConverter;
    }

    @Override
    public UStatus onEvent(UEvent event) {
        String stringEvent = eventConverter.convertToString(event);

        String response = messagingClient.message(stringEvent);

        return statusConverter.convertToPOJO(response);
    }
}