package com.nerdroid.db.schema.monitor.response;

import com.nerdroid.db.schema.monitor.database.pg.vo.PgIndexVo;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PgIndexesResponse {

    private String schemaName;
    private List<TableIndexesResponse> tables;

    public static PgIndexesResponse from(String schemaName, List<PgIndexVo> pgIndexes) {
        Map<String, List<PgIndexVo>> pgIndexesByTableName = pgIndexes.stream().collect(
            Collectors.groupingBy(PgIndexVo::getTableName));

        return new PgIndexesResponse(
            schemaName,
            pgIndexesByTableName.keySet().stream()
                .map(tableName -> new TableIndexesResponse(
                    tableName,
                    pgIndexesByTableName.get(tableName).stream()
                        .map(IndexResponse::new)
                        .toList()
                )).toList()
        );
    }

    @Getter
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class TableIndexesResponse {
        private String tableName;
        private List<IndexResponse> indexes;
    }

    @Getter
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class IndexResponse {
        private String indexName;
        private Boolean isUniqueIndex;
        private List<String> columnNames;

        private IndexResponse(PgIndexVo pgIndex) {
            this(pgIndex.getIndexName(), pgIndex.getIsUniqueIndex(), pgIndex.getColumnNames());
        }
    }
}
