package com.jcs.sbs.service.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;

import com.jcs.sbs.dao.SnapshotDao;
import com.jcs.sbs.dao.impl.SnapshotDaoImpl;
import com.jcs.sbs.result.ResultCount;
import com.jcs.sbs.service.CommonService;

public class SnapshotServiceImpl implements CommonService {

    private SnapshotDao snapshotDao = new SnapshotDaoImpl();
    
    public List getResult(String search, String sortBy, String sortDirection, int offset, int limit, String filter, List<String> optionalParams)
            throws HibernateException {
        return snapshotDao.getAllSnapshots("%" + search + "%", sortBy, sortDirection, offset, limit, filter, optionalParams);

    }

    public ResultCount getTotalResultCount(String search, String filter, List<String> optionalParams) {
        return snapshotDao.allSnapshotsResultCount("%" + search + "%", filter, optionalParams);

    }

}
