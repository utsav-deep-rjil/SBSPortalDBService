package com.jcs.sbs.common;

public class QueryTemplates {
    public static final String ACCOUNT_SUMMARY = "select * from "
            + "(select v.project_id, sum(v.size) as totalSize, count(v.id) as totalVolumes,"
            + " sum(CASE WHEN v.volume_type_id = 1 OR v.volume_type_id IS NULL THEN v.size ELSE 0 END) as stdVolumesGB,"
            + " sum(CASE WHEN v.volume_type_id = 2 THEN v.size ELSE 0 END) as ssdVolumesGB,"
            + " sum(CASE WHEN v.volume_type_id = 1 OR v.volume_type_id IS NULL THEN 1 ELSE 0 END) as stdVolumes,"
            + " sum(CASE WHEN v.volume_type_id = 2 THEN 1 ELSE 0 END) as ssdVolumes,"
            + " count(CASE WHEN v.bootable = 1 THEN 1 END) as bootableVolumes,"
            + " count(CASE WHEN v.bootable = 0 THEN 1 END) as storageVolumes,"
            + " count(CASE WHEN v.encrypted = 1 THEN 1 END) as encryptedVolumes,"
            + " count(CASE WHEN v.encrypted = 0 THEN 1 END) as plaintextVolumes,"
            + " (select count(b.id) from backups b where b.deleted = 0 and b.project_id=v.project_id) as totalSnapshots,"
            + " (CASE when (@volumeLimit\\:=(select hard_limit from quotas q where q.project_id=v.project_id and q.resource='volumes' and q.deleted=0))"
            + " then @volumeLimit else"
            + " (select qc.hard_limit from quota_classes qc where qc.resource='volumes' and qc.deleted=0) end) as volumeLimit,"
            + " (CASE when (@gbLimit\\:=(select hard_limit from quotas q where q.project_id=v.project_id and q.resource='gigabytes' and q.deleted=0)) then @gbLimit"
            + " else (select qc.hard_limit from quota_classes qc where qc.resource='gigabytes' and qc.deleted=0) end) as gbLimit,"
            + " (CASE when (@snapshotLimit\\:=(select hard_limit from quotas q where q.project_id=v.project_id and q.resource='backups' and q.deleted=0))"
            + " then @snapshotLimit else"
            + " (select qc.hard_limit from quota_classes qc where qc.resource='snapshots' and qc.deleted=0) end) as snapshotLimit,"
            + " (CASE when (@perVolGBLimit\\:=(select hard_limit from quotas q where q.project_id=v.project_id and q.resource='per_volume_gigabytes' and q.deleted=0))"
            + " then @perVolGBLimit else"
            + " (select qc.hard_limit from quota_classes qc where qc.resource='per_volume_gigabytes' and qc.deleted=0) end) as perVolumeGBLimit"
            + " from volumes v where v.deleted = 0 group by v.project_id)"
            + " A where A.%s like ?1 ORDER BY A.%s %s limit %s, %s";

    public static final String ACCOUNT_SUMMARY_RESULTS = "select count(v.project_id) as totalResults from volumes v where v.deleted = 0 and v.%s like ?1";

    public static final String VOLUMES = "select id,project_id,size,snapshot_id,status,bootable,encrypted,"
            + "COALESCE((select vt.name from volume_types vt where vt.id=volume_type_id),'standard') as volume_type,"
            + "created_at,updated_at,scheduled_at,launched_at,terminated_at from volumes where deleted = 0";

    public static final String VOLUMES_COUNT = "select count(v.id) as totalResults from volumes v where v.deleted = 0";

    public static final String SNAPSHOTS = "select b.id,b.volume_id,b.project_id,b.size,b.status,b.encrypted,"
            + "b.fail_reason,b.created_at,b.updated_at from backups b where b.deleted = 0";

    public static final String SNAPSHOTS_COUNT = "select count(b.id) as totalResults from backups b where b.deleted = 0";

}
