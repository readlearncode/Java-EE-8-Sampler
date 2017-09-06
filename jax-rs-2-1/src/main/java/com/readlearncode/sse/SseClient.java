package com.readlearncode.sse;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.sse.SseEventSource;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class SseClient {

    public static WebTarget target;

    public static void main(String[] args) {
        target = ClientBuilder.newClient().target(args[0]);
        consumeEventsViaSubscription();
    }

    private static void consumeEventsViaSubscription() {
        try (final SseEventSource eventSource =
                     SseEventSource.target(target)
                             .build()) {

            eventSource.register(System.out::println);
            eventSource.open();

            for (int counter = 0; counter < 5; counter++) {
                target.request().post(Entity.text("message " + counter));
            }

            Thread.sleep(1000); // make sure all the events have time to arrive
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}