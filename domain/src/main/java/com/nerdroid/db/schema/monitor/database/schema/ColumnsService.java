package com.nerdroid.db.schema.monitor.database.schema;

import com.nerdroid.db.schema.monitor.database.schema.entity.Columns;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ColumnsService {

    private final ColumnsRepository columnsRepository;

    public List<Columns> getColumns(String schemaName) {
        return columnsRepository.getColumnsByTableSchema(schemaName);
    }

}
