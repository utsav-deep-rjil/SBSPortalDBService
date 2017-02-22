package com.jcs.sbs.service.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;

import com.jcs.sbs.dao.VolumeDao;
import com.jcs.sbs.dao.impl.VolumeDaoImpl;
import com.jcs.sbs.result.ResultCount;
import com.jcs.sbs.service.CommonService;

public class VolumeServiceImpl implements CommonService {

    private VolumeDao volumeDao = new VolumeDaoImpl();

    public List getResult(String search, String sortBy, String sortDirection, int offset, int limit, String filter, List<String> optionalParams)
            throws HibernateException {
        return volumeDao.getAllVolumes("%" + search + "%", sortBy, sortDirection, offset, limit, filter, optionalParams);

    }

    public ResultCount getTotalResultCount(String search, String filter, List<String> optionalParams) {
        return volumeDao.allVolumesResultCount("%" + search + "%", filter, optionalParams);

    }

}
