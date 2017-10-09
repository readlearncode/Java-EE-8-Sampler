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
public class AuditEventReciever1 {

    // Order: 2nd
    public void receive(@Observes @Priority(1000) AuditEvent auditEvent) {
        System.out.println("Priority: 1000 " +
                auditEvent.getPriority() + " " + auditEvent.getMessage());
    }

}