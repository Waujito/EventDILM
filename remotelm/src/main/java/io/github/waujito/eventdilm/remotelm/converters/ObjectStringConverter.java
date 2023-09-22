package io.github.waujito.eventdilm.remotelm.converters;

/**
 * Converts an object into a string that can be easily sent over the Internet and then back to a POJO
 */
public interface ObjectStringConverter<T> {
    /**
     * Converts an event to a string
     */
    String convertToString(T obj);

    /**
     * Converts a string to an event
     */
    T convertToPOJO(String string);
}