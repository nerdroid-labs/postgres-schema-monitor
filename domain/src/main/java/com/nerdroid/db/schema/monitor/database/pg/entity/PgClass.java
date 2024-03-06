package com.nerdroid.db.schema.monitor.database.pg.entity;

import com.nerdroid.db.schema.monitor.database.common.PreventWriteListener;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "pg_class")
@EntityListeners({PreventWriteListener.class})
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
public class PgClass {

    @Id
    @Column(name = "oid", insertable=false, updatable=false)
    private Long oid;

    @Column(name = "relnamespace", insertable=false, updatable=false)
    private Long relnamespace;

    @Column(name = "relname", insertable=false, updatable=false)
    private String relname;

}
