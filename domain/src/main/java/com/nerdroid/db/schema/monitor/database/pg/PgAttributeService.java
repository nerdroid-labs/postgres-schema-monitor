package com.nerdroid.db.schema.monitor.database.pg;


import com.nerdroid.db.schema.monitor.database.pg.entity.PgAttribute;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PgAttributeService {

    private final PgAttributeRepository pgAttributeRepository;


    public List<PgAttribute> getPgAttributes(Collection<Long> attrelids) {
        return pgAttributeRepository.findAllByAttrelidIn(attrelids);
    }

}
