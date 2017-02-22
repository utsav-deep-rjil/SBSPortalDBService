package com.jcs.sbs.dao.impl;

import java.util.List;

import javax.persistence.Query;

import com.jcs.sbs.common.EntityManagerSingleton;
import com.jcs.sbs.common.QueryTemplates;
import com.jcs.sbs.common.ServiceUtil;
import com.jcs.sbs.dao.VolumeDao;
import com.jcs.sbs.models.Volume;
import com.jcs.sbs.result.AccountSummaryResult;
import com.jcs.sbs.result.ResultCount;

public class VolumeDaoImpl implements VolumeDao {

    public List<AccountSummaryResult> getAccountSummary(String search, String sortBy, String sortDirection, int offset,
            int limit, String filter) {
        if(filter.equals("project_id")){
            filter="A.project_id";
        }
        if(sortBy.equals("project_id")){
            sortBy="A.project_id";
        }
        Query query = EntityManagerSingleton.getInstance().createNativeQuery(
                String.format(QueryTemplates.ACCOUNT_SUMMARY, filter, sortBy, sortDirection, offset, limit),
                AccountSummaryResult.class);
        query.setParameter(1, search);
        return query.getResultList();
    }

    public ResultCount accountSummaryResultCount(String search, String filter) {
        if(filter.equals("project_id")){
            filter="A.project_id";
        }
        Query query = EntityManagerSingleton.getInstance()
                .createNativeQuery(String.format(QueryTemplates.ACCOUNT_SUMMARY_RESULTS, filter), ResultCount.class);
        query.setParameter(1, search);
        List<ResultCount> queryResult = query.getResultList();
        return queryResult.get(0);
    }

    public List<Volume> getAllVolumes(String search, String sortBy, String sortDirection, int offset, int limit,
            String filter, List<String> optionalParams) {

        StringBuilder builder = new StringBuilder(QueryTemplates.VOLUMES);
        builder.append(ServiceUtil.getColumnName(Volume.class, filter)).append(" like ?1");
        if (optionalParams != null) {
            for (String condition : optionalParams) {
                builder.append(" and (v1.").append(condition).append(")");
            }
        }

        builder.append(" ORDER BY v1.").append(ServiceUtil.getColumnName(Volume.class, sortBy)).append(" ")
                .append(sortDirection);

        Query query = EntityManagerSingleton.getInstance().createNativeQuery(builder.toString(), Volume.class);
        query.setParameter(1, search);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return query.getResultList();
    }

    public ResultCount allVolumesResultCount(String search, String filter, List<String> optionalParams) {

        StringBuilder builder = new StringBuilder(QueryTemplates.VOLUMES_COUNT);
        builder.append(ServiceUtil.getColumnName(Volume.class, filter)).append(" like ?1");
        if (optionalParams != null) {
            for (String condition : optionalParams) {
                builder.append(" and (v1.").append(condition).append(")");
            }
        }

        Query query = EntityManagerSingleton.getInstance().createNativeQuery(builder.toString(), ResultCount.class);

        query.setParameter(1, search);

        List<ResultCount> queryResult = query.getResultList();
        return queryResult.get(0);
    }

}
