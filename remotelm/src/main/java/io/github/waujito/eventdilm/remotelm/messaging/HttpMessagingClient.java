package io.github.waujito.eventdilm.remotelm.messaging;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

/**
 * A MessagingClient implementation through HTTP protocol
 */
public class HttpMessagingClient implements MessagingClient {
    private final HttpClient httpClient;
    private final URI listenerURI;

    /**
     * Constructs a class with a custom HttpClient
     */
    public HttpMessagingClient(URI listenerURI, HttpClient httpClient) {
        this.httpClient = httpClient;
        this.listenerURI = listenerURI;
    }

    /**
     * Constructs a class with the default HttpClient
     */
    public HttpMessagingClient(URI listenerURI) {
        this.listenerURI = listenerURI;
        this.httpClient = HttpClient.newHttpClient();
    }


    /**
     * Sends the event to the client and receives the response
     *
     * @param event Event
     * @return ProcessStatus
     */
    @Override
    public String message(String event) {
        var eventBody = HttpRequest.BodyPublishers.ofString(event, StandardCharsets.UTF_8);

        var request = HttpRequest
                .newBuilder(listenerURI)
                .POST(eventBody)
                .build();

        var bodyHandler = HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8);

        try {
            return httpClient.send(request, bodyHandler).body();
        } catch (IOException | InterruptedException e) {
            throw new MessagingException(e);
        }
    }
}