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
public class AuditEventReciever5 {

    // Order: 4th
    public void receive(@Observes @Priority(5000) AuditEvent auditEvent) {
        System.out.println("Priority: 5000 " +
                auditEvent.getPriority() + " " + auditEvent.getMessage());
    }

}