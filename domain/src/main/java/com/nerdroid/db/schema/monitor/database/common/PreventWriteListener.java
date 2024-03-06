package com.nerdroid.db.schema.monitor.database.common;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreRemove;
import jakarta.persistence.PreUpdate;

public class PreventWriteListener {
    @PreUpdate
    @PrePersist
    @PreRemove
    public void writeListener(Object entity) throws IllegalAccessException {
        throw new IllegalAccessException("This entity is not writable");
    }
}
