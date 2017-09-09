package com.readlearncode.async;

import com.readlearncode.priority.AuditEvent;

import javax.enterprise.event.Event;
import javax.inject.Inject;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class AuditEventSender {

    @Inject
    private Event<AuditEvent> event;

    public void send(AuditEvent auditEvent) {
        event.fire(auditEvent);
    }
}