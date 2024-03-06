package com.nerdroid.db.schema.monitor.database.schema;

import com.nerdroid.db.schema.monitor.database.schema.entity.Columns;
import com.nerdroid.db.schema.monitor.database.schema.entity.ColumnsPK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ColumnsRepository extends JpaRepository<Columns, ColumnsPK> {
    List<Columns> getColumnsByTableSchema(String tableSchema);
}
