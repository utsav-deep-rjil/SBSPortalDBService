package com.jcs.sbs.dao;

import java.util.List;

import com.jcs.sbs.models.Snapshot;
import com.jcs.sbs.result.ResultCount;

public interface SnapshotDao {

    public List<Snapshot> getAllSnapshots(String search, String sortBy, String sortDirection, int offset, int limit,
            String filter, List<String> optionalParams);

    public ResultCount allSnapshotsResultCount(String search, String filter, List<String> optionalParams);

}
