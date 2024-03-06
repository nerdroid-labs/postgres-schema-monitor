package com.nerdroid.db.schema.monitor.database.pg.vo;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PgIndexVo {

    private String tableName;
    private String indexName;
    private List<String> columnNames;
    private Boolean isUniqueIndex;

}
