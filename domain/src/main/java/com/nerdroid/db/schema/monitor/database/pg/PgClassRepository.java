package com.nerdroid.db.schema.monitor.database.pg;

import com.nerdroid.db.schema.monitor.database.pg.entity.PgClass;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PgClassRepository extends JpaRepository<PgClass, Long> {

    List<PgClass> findAllByRelnamespace(Long relnamespace);

}
