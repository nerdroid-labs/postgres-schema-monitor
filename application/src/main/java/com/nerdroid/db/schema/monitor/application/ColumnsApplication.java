package com.nerdroid.db.schema.monitor.application;

import com.nerdroid.db.schema.monitor.database.schema.ColumnsService;
import com.nerdroid.db.schema.monitor.response.ColumnsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ColumnsApplication {

    private final ColumnsService columnsService;

    public ColumnsResponse getColumns(String schemaName) {
        return ColumnsResponse.from(
            schemaName,
            columnsService.getColumns(schemaName)
        );
    }

}
