package com.readlearncode.reactive;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.sse.SseEventSource;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class ClientAPIExample {

    public void ClientAPIExample() {

        WebTarget target = ClientBuilder.newClient().target("http://localhost:8080/jax-rs-2-1/sse/");
        try (SseEventSource source = SseEventSource.target(target).build()) {
            source.register(System.out::println);
            source.open();
        }

    }
}