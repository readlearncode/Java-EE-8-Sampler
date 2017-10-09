package com.readlearncode.async;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.ObservesAsync;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
@ApplicationScoped
public class AuditEventReciever {

    public void receiveAsync(@ObservesAsync AuditEvent auditEvent) {

        System.out.println(auditEvent.getPriority() + " " + auditEvent.getMessage());

        try {
            // Simulate some amount of work
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}