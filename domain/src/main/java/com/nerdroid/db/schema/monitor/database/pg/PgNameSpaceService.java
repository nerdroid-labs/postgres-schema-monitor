package com.nerdroid.db.schema.monitor.database.pg;

import com.nerdroid.db.schema.monitor.database.pg.entity.PgNameSpace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;


@Service
@RequiredArgsConstructor
public class PgNameSpaceService {

    private static final String NAMESPACE_NOT_FOUND = "존재하지 않는 네임스페이스입니다.";
    private final PgNameSpaceRepository pgNameSpaceRepository;


    @Transactional(readOnly = true)
    public PgNameSpace getPgNameSpace(String namespace) {
        return pgNameSpaceRepository.findByNspname(namespace)
            .orElseThrow(() -> new NoSuchElementException(NAMESPACE_NOT_FOUND));
    }

}
