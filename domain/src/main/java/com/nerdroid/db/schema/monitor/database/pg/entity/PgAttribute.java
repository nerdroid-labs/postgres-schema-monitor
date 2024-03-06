package com.nerdroid.db.schema.monitor.database.pg.entity;

import com.nerdroid.db.schema.monitor.database.common.PreventWriteListener;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;



@Getter
@Entity
@Table(name = "pg_attribute")
@EntityListeners({PreventWriteListener.class})
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
public class PgAttribute {

    @EmbeddedId
    private PgAttributePk id;

    @Column(name = "attrelid", insertable=false, updatable=false)
    private Long attrelid;

    @Column(name = "attnum", insertable=false, updatable=false)
    private Short attnum;

    @Column(name = "attname", insertable=false, updatable=false)
    private String attname;

}
