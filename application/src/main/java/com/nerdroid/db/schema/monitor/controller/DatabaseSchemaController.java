package com.nerdroid.db.schema.monitor.controller;

import com.nerdroid.db.schema.monitor.application.ColumnsApplication;
import com.nerdroid.db.schema.monitor.application.PgIndexApplication;
import com.nerdroid.db.schema.monitor.response.ColumnsResponse;
import com.nerdroid.db.schema.monitor.response.PgIndexesResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/api/database/{schemaName}")
@RestController
@RequiredArgsConstructor
public class DatabaseSchemaController {
    private final ColumnsApplication columnsApplication;
    private final PgIndexApplication pgIndexApplication;

    @GetMapping("/columns")
    public ColumnsResponse getColumns(@PathVariable String schemaName) {
        return columnsApplication.getColumns(schemaName);
    }

    @GetMapping("/indexes")
    public PgIndexesResponse getIndexes(@PathVariable String schemaName) {
        return pgIndexApplication.getPgIndexes(schemaName);
    }
}
