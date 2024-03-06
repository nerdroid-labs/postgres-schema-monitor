package com.nerdroid.db.schema.monitor.database.pg;


import com.nerdroid.db.schema.monitor.database.pg.entity.PgClass;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PgClassService {

    private final PgClassRepository pgClassRepository;

    @Transactional(readOnly = true)

    public List<PgClass> getPgClasses(Long relnamespace) {
        return pgClassRepository.findAllByRelnamespace(relnamespace);
    }

}
