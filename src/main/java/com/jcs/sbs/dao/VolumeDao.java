package com.jcs.sbs.dao;

import java.util.List;
import java.util.Map;

import com.jcs.sbs.models.Volume;
import com.jcs.sbs.result.AccountSummaryResult;
import com.jcs.sbs.result.ResultCount;

public interface VolumeDao {

    public List<AccountSummaryResult> getAccountSummary(String search, String sortBy, String sortDirection, int offset,
            int limit, String filter);

    public ResultCount accountSummaryResultCount(String search, String filter);

    public List<Volume> getAllVolumes(String search, String sortBy, String sortDirection, int offset, int limit,
            String filter, List<String> optionalParams);

    public ResultCount allVolumesResultCount(String search, String filter, List<String> optionalParams);

}
