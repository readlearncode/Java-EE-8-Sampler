package com.readlearncode.priority;

import com.readlearncode.async.AuditEvent;

import javax.annotation.Priority;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
@ApplicationScoped
public class AuditEventReciever2 {

    // Order: 1st
    public void receive(@Observes @Priority(100) AuditEvent auditEvent) {
        System.out.println("Priority: 100 " +
                auditEvent.getPriority() + " " + auditEvent.getMessage());
    }

}