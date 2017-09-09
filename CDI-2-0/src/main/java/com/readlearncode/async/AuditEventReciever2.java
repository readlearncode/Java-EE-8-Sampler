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
public class AuditEventReciever2 {

    public void receive(@Observes @Priority(100) AuditEvent auditEvent) {
        System.out.println(
                auditEvent.getPriority() + " " + auditEvent.getMessage());
    }

}