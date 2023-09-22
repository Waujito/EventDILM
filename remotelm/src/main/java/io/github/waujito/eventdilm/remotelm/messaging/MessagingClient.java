package io.github.waujito.eventdilm.remotelm.messaging;

/**
 * Sends and receives messages from the remote listener
 */
public interface MessagingClient {
    /**
     * Sends the event to the client and receives the response
     *
     * @param event Event
     * @return ProcessStatus
     */
    String message(String event);
}