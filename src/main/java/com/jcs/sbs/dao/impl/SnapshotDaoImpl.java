package com.jcs.sbs.dao.impl;

import java.util.List;

import javax.persistence.Query;

import com.jcs.sbs.common.EntityManagerSingleton;
import com.jcs.sbs.common.QueryTemplates;
import com.jcs.sbs.common.ServiceUtil;
import com.jcs.sbs.dao.SnapshotDao;
import com.jcs.sbs.models.Snapshot;
import com.jcs.sbs.result.ResultCount;

public class SnapshotDaoImpl implements SnapshotDao {
    public List<Snapshot> getAllSnapshots(String search, String sortBy, String sortDirection, int offset, int limit,
            String filter, List<String> optionalParams) {

        StringBuilder builder = new StringBuilder(QueryTemplates.SNAPSHOTS);
        if(optionalParams != null) {
            for (String condition : optionalParams) {
                builder.append(" and b.").append(condition);
            }
        }
        builder.append(" and b.").append(ServiceUtil.getColumnName(Snapshot.class, filter)).append(" like ?1");
        builder.append(" ORDER BY b.").append(ServiceUtil.getColumnName(Snapshot.class, sortBy)).append(" ")
                .append(sortDirection);
        
        
        Query query = EntityManagerSingleton.getInstance().createNativeQuery(builder.toString(), Snapshot.class);
        query.setParameter(1, search);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return query.getResultList();
    }

    public ResultCount allSnapshotsResultCount(String search, String filter, List<String> optionalParams) {

        StringBuilder builder = new StringBuilder(QueryTemplates.SNAPSHOTS_COUNT);
        if(optionalParams != null) {
            for (String condition : optionalParams) {
                builder.append(" and b.").append(condition);
            }
        }
        builder.append(" and b.").append(ServiceUtil.getColumnName(Snapshot.class, filter)).append(" like ?1");
        
        Query query = EntityManagerSingleton.getInstance().createNativeQuery(builder.toString(), ResultCount.class);
        query.setParameter(1, search);
        List<ResultCount> queryResult = query.getResultList();
        return queryResult.get(0);
    }
}
