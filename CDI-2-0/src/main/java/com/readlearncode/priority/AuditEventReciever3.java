package com.readlearncode.priority;

import com.readlearncode.async.AuditEvent;

import javax.annotation.Priority;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

import static javax.interceptor.Interceptor.Priority.APPLICATION;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
@ApplicationScoped
public class AuditEventReciever3 {

    // Order: 3rd
    public void receive(@Observes @Priority(APPLICATION + 500) AuditEvent auditEvent) {
        System.out.println("Priority: " + (APPLICATION + 500) + " " +
                auditEvent.getPriority() + " " + auditEvent.getMessage());
    }

}