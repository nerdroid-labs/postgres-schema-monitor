package com.nerdroid.db.schema.monitor.database.schema.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class ColumnsPK implements Serializable {
    @Column(name = "table_schema", insertable=false, updatable=false)
    private String tableSchema;

    @Column(name = "table_name", insertable=false, updatable=false)
    private String tableName;

    @Column(name = "column_name", insertable=false, updatable=false)
    private String columnName;
}
