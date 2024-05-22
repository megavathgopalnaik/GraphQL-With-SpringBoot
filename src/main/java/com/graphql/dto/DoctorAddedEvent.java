package com.graphql.dto;

import java.time.LocalDateTime;

public class DoctorAddedEvent {
    private LocalDateTime timestamp;

    public DoctorAddedEvent(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
