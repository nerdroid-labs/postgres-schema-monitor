package com.nerdroid.db.schema.monitor.database.pg;

import com.nerdroid.db.schema.monitor.database.pg.entity.PgAttribute;
import com.nerdroid.db.schema.monitor.database.pg.entity.PgAttributePk;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface PgAttributeRepository extends JpaRepository<PgAttribute, PgAttributePk> {

    List<PgAttribute> findAllByAttrelidIn(Collection<Long> attrelids);

}
