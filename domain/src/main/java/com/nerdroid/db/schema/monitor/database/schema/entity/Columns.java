package com.nerdroid.db.schema.monitor.database.schema.entity;

import com.nerdroid.db.schema.monitor.database.common.PreventWriteListener;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(schema = "information_schema", name = "columns")
@EntityListeners({PreventWriteListener.class})
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
public class Columns {

    @EmbeddedId
    private ColumnsPK id;

    @Column(name = "table_schema", insertable=false, updatable=false)
    private String tableSchema;

    @Column(name = "table_name", insertable=false, updatable=false)
    private String tableName;

    @Column(name = "column_name", insertable=false, updatable=false)
    private String columnName;

    @Column(name = "data_type", insertable=false, updatable=false)
    private String dataType;

    @Column(name = "column_default", insertable=false, updatable=false)
    private String columnDefault;

    @Column(name = "is_nullable", insertable=false, updatable=false)
    private String isNullable;

    @Column(name = "character_maximum_length", insertable=false, updatable=false)
    private String characterMaximumLength;

}