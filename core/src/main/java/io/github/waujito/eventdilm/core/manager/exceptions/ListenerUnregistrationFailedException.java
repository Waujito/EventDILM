package io.github.waujito.eventdilm.core.manager.exceptions;

public class ListenerUnregistrationFailedException extends RuntimeException {
    public ListenerUnregistrationFailedException() {
    }

    public ListenerUnregistrationFailedException(String message) {
        super(message);
    }
}