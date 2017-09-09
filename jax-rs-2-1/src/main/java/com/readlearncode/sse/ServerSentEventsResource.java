package com.readlearncode.sse;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.sse.Sse;
import javax.ws.rs.sse.SseEventSink;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
@Path("sse")
public class ServerSentEventsResource {

    private final Object outputLock = new Object();
    private volatile SseEventSink eventSink;

    private ScheduledExecutorService executorService = Executors.newScheduledThreadPool(10);

    @Context
    private Sse sse;

    @GET
    @Produces(MediaType.SERVER_SENT_EVENTS)
    public void getMessageQueue(@Context SseEventSink eventSink) {
        synchronized (outputLock) {
            if (this.eventSink != null) {
                throw new IllegalStateException("Server sink already served.");
            }
            this.eventSink = eventSink;
        }
    }

    @POST
    public void addMessage(final String message) throws IOException {
        if (eventSink == null) {
            throw new IllegalStateException("No client connected.");
        }
        eventSink.send(sse.newEvent("custom-message: " + message));
    }

    @DELETE
    public void close() throws IOException {
        synchronized (outputLock) {
            if (eventSink != null) {
                eventSink.close();
                eventSink = null;
            }
        }
    }

    @POST
    @Path("domains/{id}")
    @Produces(MediaType.SERVER_SENT_EVENTS)
    public void startDomain(@PathParam("id") final String id, @Context SseEventSink eventSink) {

        executorService.submit(() -> {
            try {
                eventSink.send(sse.newEventBuilder().name("domain-progress").data(String.class, "starting domain " + id + " ...").build());
                Thread.sleep(200);
                eventSink.send(sse.newEvent("domain-progress", "50%"));
                Thread.sleep(200);
                eventSink.send(sse.newEvent("domain-progress", "60%"));
                Thread.sleep(200);
                eventSink.send(sse.newEvent("domain-progress", "70%"));
                Thread.sleep(200);
                eventSink.send(sse.newEvent("domain-progress", "99%"));
                Thread.sleep(200);
                eventSink.send(sse.newEvent("domain-progress", "Done."));
                eventSink.close();
            } catch (final InterruptedException e) {
                e.printStackTrace();
            }
        });
    }


    @POST
    @Path("progress/{report_id}")
    @Produces(MediaType.SERVER_SENT_EVENTS)
    public void eventStream(@PathParam("report_id") final String id,
                            @Context SseEventSink es,
                            @Context Sse sse) {
        executorService.execute(() -> {
            try {
                eventSink.send(sse.newEventBuilder().name("report-progress")
                        .data(String.class, "Commencing process for report " + id + " ...").build());
                es.send(sse.newEvent("Progress", "25%"));
                Thread.sleep(500);
                es.send(sse.newEvent("Progress", "50%"));
                Thread.sleep(500);
                es.send(sse.newEvent("Progress", "75%"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

}