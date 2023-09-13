package io.github.waujito.eventdilm.core.manager.exceptions;

/**
 * Throws when the registration of a listener has failed.
 */
public class ListenerRegistrationFailedException extends Exception {
    public ListenerRegistrationFailedException() {
    }

    public ListenerRegistrationFailedException(String message) {
        super(message);
    }
}