package com.nerdroid.db.schema.monitor.database.pg;

import com.nerdroid.db.schema.monitor.database.pg.entity.PgIndex;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PgIndexService {

    private final PgIndexRepository pgIndexRepository;


    @Transactional(readOnly = true)
    public List<PgIndex> getPgIndexes(Collection<Long> indexrelids) {
        return pgIndexRepository.findAllByIndexrelidIn(indexrelids);
    }

}
