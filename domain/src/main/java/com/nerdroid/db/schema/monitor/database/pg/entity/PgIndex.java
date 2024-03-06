package com.nerdroid.db.schema.monitor.database.pg.entity;

import com.nerdroid.db.schema.monitor.database.common.PreventWriteListener;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@Getter
@Entity
@Table(name = "pg_index")
@EntityListeners({PreventWriteListener.class})
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
public class PgIndex {

    @Id
    @Column(name = "indexrelid", insertable=false, updatable=false)
    private Long indexrelid;

    @Column(name = "indrelid", insertable=false, updatable=false)
    private Long indrelid;

    @Column(name = "indkey", insertable=false, updatable=false)
    private String indkey;

    @Column(name = "indisunique", insertable=false, updatable=false)
    private Boolean indisunique;


    public List<Short> getIndkey() {
        return Arrays.stream(this.indkey.split(" ")).sequential()
            .map(Short::parseShort)
            .toList();
    }

}