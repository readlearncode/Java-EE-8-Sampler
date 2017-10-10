package com.readlearncode.priority;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class ObserverEvent {

    /*
    The CDI 2.0 API introduces the @Priority annotation that allows
    the order of observer methods.

    When the fire method is called in what order are the observer
    methods executed.
     */
    

//    // Order: 2nd
//    public void observe1(@Observes @Priority(1000) AuditEvent auditEvent) {}
//
//    // Order: 1st
//    public void observe2(@Observes @Priority(100) AuditEvent auditEvent) {}
//
//    // Order: 3rd
//    public void observe3(@Observes @Priority(APPLICATION + 500) AuditEvent auditEvent) {}
//
//    // Order: Doesn't fire
//    public void observe4(@ObservesAsync  @Priority(1) AuditEvent auditEvent) {}
//
//    // Order: 4th
//    public void observe5(@Observes @Priority(5000) AuditEvent auditEvent) {}
}