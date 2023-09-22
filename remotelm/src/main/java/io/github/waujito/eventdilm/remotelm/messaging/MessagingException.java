package io.github.waujito.eventdilm.remotelm.messaging;

/**
 * Throws when the exception occurs in the messaging bridge (for example IOException)
 */
public class MessagingException extends RuntimeException {
    public MessagingException(Throwable cause) {
        super(cause);
    }
}