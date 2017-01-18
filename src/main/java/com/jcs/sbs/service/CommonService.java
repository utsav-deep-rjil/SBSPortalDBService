package com.jcs.sbs.service;

import java.util.List;
import java.util.Map;

import com.jcs.sbs.result.ResultCount;

public interface CommonService {

    public List getResult(String search, String sortBy, String sortDirection, int offset, int limit, String filter, List<String> optionalParams);

    public ResultCount getTotalResultCount(String search, String filter, List<String> optionalParams);
}
