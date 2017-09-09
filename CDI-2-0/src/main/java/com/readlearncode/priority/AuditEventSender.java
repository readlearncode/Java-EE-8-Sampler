package com.readlearncode.priority;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import java.util.concurrent.CompletionStage;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class AuditEventSender {

    @Inject
    private Event<AuditEvent> event;

    public CompletionStage<AuditEvent> sendAsync(AuditEvent auditEvent) {
        System.out.println("Sending async");
        CompletionStage<AuditEvent> stage = event.fireAsync(auditEvent)
                .handle((event, ex) -> {
                    if (event != null) {
                        return event;
                    } else {
                        for (Throwable t : ex.getSuppressed()) {}
                        return auditEvent;
                    }
                });

        return stage;
    }
}