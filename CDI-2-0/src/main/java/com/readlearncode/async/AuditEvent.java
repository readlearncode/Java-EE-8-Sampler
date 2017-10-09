package com.readlearncode.async;

import java.util.Objects;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class AuditEvent {

    public enum Priority { HIGH, LOW }

    public AuditEvent() {
    }

    public AuditEvent(String message, Priority priority) {
        this.message = message;
        this.priority = priority;
    }

    private String message;
    private Priority priority = Priority.LOW;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuditEvent that = (AuditEvent) o;
        return Objects.equals(message, that.message) &&
                priority == that.priority;
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, priority);
    }

    @Override
    public String toString() {
        return "AuditEvent{" +
                "message='" + message + '\'' +
                ", async=" + priority +
                '}';
    }
}