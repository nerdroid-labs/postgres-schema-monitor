package com.nerdroid.db.schema.monitor.database.pg.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Embeddable
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
public class PgAttributePk implements Serializable {

    @Column(name = "attrelid", insertable=false, updatable=false)
    private Long attrelid;

    @Column(name = "attnum", insertable=false, updatable=false)
    private Short attnum;

    public static PgAttributePk of(Long attrelid, Short attnum) {
        return new PgAttributePk(attrelid, attnum);
    }

}
