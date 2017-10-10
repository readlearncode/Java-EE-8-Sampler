package com.readlearncode.priority;

import com.readlearncode.async.AuditEvent;

import javax.annotation.Priority;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.ObservesAsync;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
@ApplicationScoped
public class AuditEventReciever4 {

    // Order: Doesn't fire
    public void receive(@ObservesAsync @Priority(1) AuditEvent auditEvent) {
                System.out.println("Priority: no (ObservesAsync) " +
                auditEvent.getPriority() + " " + auditEvent.getMessage());
    }

}