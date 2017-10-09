package com.readlearncode.priority;

import com.readlearncode.async.AuditEvent;

import javax.annotation.PostConstruct;
import javax.ejb.Startup;
import javax.ejb.Singleton;
import javax.enterprise.event.Event;
import javax.inject.Inject;

import static com.readlearncode.async.AuditEvent.Priority.HIGH;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
@Singleton
@Startup
public class AuditEventSender {


    @Inject
    private Event<AuditEvent> event;

    @PostConstruct
    public void send() {
        event.fire(new AuditEvent("Security Violation", HIGH));
    }


}