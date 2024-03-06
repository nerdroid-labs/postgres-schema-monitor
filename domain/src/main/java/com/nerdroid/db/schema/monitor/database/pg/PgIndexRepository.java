package com.nerdroid.db.schema.monitor.database.pg;

import com.nerdroid.db.schema.monitor.database.pg.entity.PgIndex;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface PgIndexRepository extends JpaRepository<PgIndex, Long> {

    List<PgIndex> findAllByIndexrelidIn(Collection<Long> indexrelids);

}
