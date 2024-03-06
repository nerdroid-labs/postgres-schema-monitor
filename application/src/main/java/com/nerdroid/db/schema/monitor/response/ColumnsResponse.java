package com.nerdroid.db.schema.monitor.response;

import com.nerdroid.db.schema.monitor.database.schema.entity.Columns;
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
public class ColumnsResponse {

    private String schemaName;
    private List<TableColumnResponse> tables;

    public static ColumnsResponse from(String schemaName, List<Columns> columns) {
        Map<String/*schemaName*/, Map<String/*tableName*/, List<ColumnResponse>>> columnsBySchema = columns.stream()
            .collect(Collectors.groupingBy(
                Columns::getTableSchema,
                Collectors.groupingBy(Columns::getTableName, Collectors.mapping(ColumnResponse::new, Collectors.toList()))
            ));

        return new ColumnsResponse(
            schemaName,
            columnsBySchema.get(schemaName).entrySet().stream()
                .map(entry /* tableName, columnResponses */ -> new TableColumnResponse(entry.getKey(), entry.getValue()))
                .toList()
        );
    }

    @Getter
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class TableColumnResponse {
        private String tableName;
        private List<ColumnResponse> columns;
    }

    @Getter
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class ColumnResponse {
        private String columnName;
        private String dataType;
        private String characterMaximumLength;
        private String isNullable;
        private String columnDefault;

        private ColumnResponse(Columns columns) {
            this(
                columns.getColumnName(),
                columns.getDataType(),
                columns.getCharacterMaximumLength(),
                columns.getIsNullable(),
                columns.getColumnDefault()
            );
        }
    }
}
