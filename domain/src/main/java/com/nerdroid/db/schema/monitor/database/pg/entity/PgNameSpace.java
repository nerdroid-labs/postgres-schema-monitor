package com.nerdroid.db.schema.monitor.database.pg.entity;

import com.nerdroid.db.schema.monitor.database.common.PreventWriteListener;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "pg_namespace")
@EntityListeners({PreventWriteListener.class})
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
public class PgNameSpace {

    @Id
    @Column(name = "oid", insertable=false, updatable=false)
    private Long oid;

    @Column(name = "nspname", insertable=false, updatable=false)
    private String nspname;

}
