package com.readlearncode.async;

import com.readlearncode.priority.AuditEvent;

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

    public void receive(@Observes @Priority(10) AuditEvent auditEvent) {
        System.out.println(
                auditEvent.getPriority() + " " + auditEvent.getMessage());
    }

}