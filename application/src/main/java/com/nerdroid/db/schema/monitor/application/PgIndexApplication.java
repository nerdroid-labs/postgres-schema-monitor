package com.nerdroid.db.schema.monitor.application;

import com.nerdroid.db.schema.monitor.database.pg.PgAttributeService;
import com.nerdroid.db.schema.monitor.database.pg.PgClassService;
import com.nerdroid.db.schema.monitor.database.pg.PgIndexService;
import com.nerdroid.db.schema.monitor.database.pg.PgNameSpaceService;
import com.nerdroid.db.schema.monitor.database.pg.entity.PgAttributePk;
import com.nerdroid.db.schema.monitor.database.pg.entity.PgIndex;
import com.nerdroid.db.schema.monitor.database.pg.entity.PgNameSpace;
import com.nerdroid.db.schema.monitor.database.pg.entity.PgClass;
import com.nerdroid.db.schema.monitor.database.pg.entity.PgAttribute;
import com.nerdroid.db.schema.monitor.database.pg.vo.PgIndexVo;
import com.nerdroid.db.schema.monitor.response.PgIndexesResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PgIndexApplication {

    private final PgNameSpaceService pgNameSpaceService;
    private final PgAttributeService pgAttributeService;
    private final PgClassService pgClassService;
    private final PgIndexService pgIndexService;


    public PgIndexesResponse getPgIndexes(String schemaName) {
        PgNameSpace targetNameSpace = pgNameSpaceService.getPgNameSpace(schemaName);

        Map<Long, String> namesByOid = pgClassService.getPgClasses(targetNameSpace.getOid())
            .stream()
            .collect(Collectors.toMap(PgClass::getOid, PgClass::getRelname));
        Map<PgAttributePk, String> attNamesByPk = pgAttributeService.getPgAttributes(namesByOid.keySet())
            .stream()
            .collect(Collectors.toMap(PgAttribute::getId, PgAttribute::getAttname));
        List<PgIndex> targetIndexes = pgIndexService.getPgIndexes(namesByOid.keySet());

        return PgIndexesResponse.from(
            schemaName,
            getPgIndexes(targetIndexes, namesByOid, attNamesByPk)
        );
    }

    private List<PgIndexVo> getPgIndexes(List<PgIndex> pgIndexes, Map<Long, String> namesByOid, Map<PgAttributePk, String> attNamesByPk) {
        return pgIndexes.stream()
            .map(pgIndex -> new PgIndexVo(
                namesByOid.get(pgIndex.getIndrelid()),
                namesByOid.get(pgIndex.getIndexrelid()),
                pgIndex.getIndkey().stream()
                    .map(attnum -> attNamesByPk.get(PgAttributePk.of(pgIndex.getIndrelid(), attnum)))
                    .toList(),
                pgIndex.getIndisunique()
            )).toList();
    }

}
