package com.nerdroid.db.schema.monitor.database.pg;

import com.nerdroid.db.schema.monitor.database.pg.entity.PgNameSpace;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PgNameSpaceRepository extends JpaRepository<PgNameSpace, Long> {

    Optional<PgNameSpace> findByNspname(String nspname);

}
