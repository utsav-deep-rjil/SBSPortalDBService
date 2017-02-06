package com.jcs.sbs.common;

public class QueryTemplates {
    public static final String ACCOUNT_SUMMARY = "select A.project_id as project_id,totalSize,totalVolumes,"
            + " stdVolumesGB,ssdVolumesGB,stdVolumes,ssdVolumes,bootableVolumes,userVolumes,encryptedVolumes,"
            + " plaintextVolumes,volumeLimit,gbLimit,snapshotLimit,perVolumeGBLimit,coalesce(B.totalSnapshots,0) as totalSnapshots from "
            + " (select v.project_id, sum(v.size) as totalSize, count(v.id) as totalVolumes,"
            + " sum(CASE WHEN v.volume_type_id = 1 OR v.volume_type_id IS NULL THEN v.size ELSE 0 END) as stdVolumesGB,"
            + " sum(CASE WHEN v.volume_type_id = 2 THEN v.size ELSE 0 END) as ssdVolumesGB,"
            + " sum(CASE WHEN v.volume_type_id = 1 OR v.volume_type_id IS NULL THEN 1 ELSE 0 END) as stdVolumes,"
            + " sum(CASE WHEN v.volume_type_id = 2 THEN 1 ELSE 0 END) as ssdVolumes,"
            + " count(CASE WHEN v.bootable = 1 THEN 1 END) as bootableVolumes, count(CASE WHEN v.bootable = 0 THEN 1 END) as userVolumes,"
            + " count(CASE WHEN v.encrypted = 1 THEN 1 END) as encryptedVolumes, count(CASE WHEN v.encrypted = 0 THEN 1 END) as plaintextVolumes,"
            + " coalesce((select hard_limit from quotas q where q.project_id=v.project_id and q.resource='volumes' and q.deleted=0),"
            + " (select qc.hard_limit from quota_classes qc where qc.resource='volumes' and qc.deleted=0)) as volumeLimit,"
            + " coalesce((select hard_limit from quotas q where q.project_id=v.project_id and q.resource='gigabytes' and q.deleted=0),"
            + " (select qc.hard_limit from quota_classes qc where qc.resource='gigabytes' and qc.deleted=0)) as gbLimit,"
            + " coalesce((select hard_limit from quotas q where q.project_id=v.project_id and q.resource='backups' and q.deleted=0),"
            + " (select qc.hard_limit from quota_classes qc where qc.resource='snapshots' and qc.deleted=0)) as snapshotLimit,"
            + " coalesce((select hard_limit from quotas q where q.project_id=v.project_id and q.resource='per_volume_gigabytes' and q.deleted=0),"
            + " (select qc.hard_limit from quota_classes qc where qc.resource='per_volume_gigabytes' and qc.deleted=0)) as perVolumeGBLimit"
            + " from volumes v where v.deleted = 0 and v.project_id IS NOT NULL group by v.project_id) A left join"
            + " (select count(b.id) as totalSnapshots,b.project_id from backups b where b.deleted = 0 and b.project_id IS NOT NULL group by b.project_id)"
            + " B on A.project_id = B.project_id where %s like ?1 ORDER BY %s %s limit %s, %s";

    public static final String ACCOUNT_SUMMARY_RESULTS = "select count(A.project_id) as totalResults from "
            + "(select A.project_id as project_id,totalSize,totalVolumes, stdVolumesGB,ssdVolumesGB,stdVolumes,ssdVolumes,bootableVolumes,"
            + " userVolumes,encryptedVolumes,plaintextVolumes,volumeLimit,gbLimit,snapshotLimit,perVolumeGBLimit,coalesce(B.totalSnapshots,0) as totalSnapshots"
            + " from (select v.project_id, sum(v.size) as totalSize, count(v.id) as totalVolumes,"
            + " sum(CASE WHEN v.volume_type_id = 1 OR v.volume_type_id IS NULL THEN v.size ELSE 0 END) as stdVolumesGB,"
            + " sum(CASE WHEN v.volume_type_id = 2 THEN v.size ELSE 0 END) as ssdVolumesGB,"
            + " sum(CASE WHEN v.volume_type_id = 1 OR v.volume_type_id IS NULL THEN 1 ELSE 0 END) as stdVolumes,"
            + " sum(CASE WHEN v.volume_type_id = 2 THEN 1 ELSE 0 END) as ssdVolumes,"
            + " count(CASE WHEN v.bootable = 1 THEN 1 END) as bootableVolumes, count(CASE WHEN v.bootable = 0 THEN 1 END) as userVolumes,"
            + " count(CASE WHEN v.encrypted = 1 THEN 1 END) as encryptedVolumes, count(CASE WHEN v.encrypted = 0 THEN 1 END) as plaintextVolumes,"
            + " coalesce((select hard_limit from quotas q where q.project_id=v.project_id and q.resource='volumes' and q.deleted=0),"
            + " (select qc.hard_limit from quota_classes qc where qc.resource='volumes' and qc.deleted=0)) as volumeLimit,"
            + " coalesce((select hard_limit from quotas q where q.project_id=v.project_id and q.resource='gigabytes' and q.deleted=0),"
            + " (select qc.hard_limit from quota_classes qc where qc.resource='gigabytes' and qc.deleted=0)) as gbLimit,"
            + " coalesce((select hard_limit from quotas q where q.project_id=v.project_id and q.resource='backups' and q.deleted=0),"
            + " (select qc.hard_limit from quota_classes qc where qc.resource='snapshots' and qc.deleted=0)) as snapshotLimit,"
            + " coalesce((select hard_limit from quotas q where q.project_id=v.project_id and q.resource='per_volume_gigabytes' and q.deleted=0),"
            + " (select qc.hard_limit from quota_classes qc where qc.resource='per_volume_gigabytes' and qc.deleted=0)) as perVolumeGBLimit"
            + " from volumes v where v.deleted = 0 and v.project_id IS NOT NULL group by v.project_id) A left join"
            + " (select count(b.id) as totalSnapshots,b.project_id from backups b where b.deleted = 0 and b.project_id IS NOT NULL group by b.project_id)"
            + " B on A.project_id = B.project_id where %s like ?1) A";

    public static final String VOLUMES = "select * from (select v.id,v.project_id,v.size,v.snapshot_id,v.status,v.bootable,v.encrypted,"
            + "(COALESCE((select vt.name from volume_types vt where vt.id=v.volume_type_id),'standard')) as volume_type,"
            + "v.created_at,v.updated_at,v.scheduled_at,v.launched_at,v.terminated_at from volumes v where v.deleted = 0) v1 where v1.";

    public static final String VOLUMES_COUNT = "select count(v1.id) as totalResults from (select v.id,v.project_id,v.size,v.snapshot_id,v.status,"
            + "v.bootable,v.encrypted,(COALESCE((select vt.name from volume_types vt where vt.id=v.volume_type_id),'standard')) as volume_type,"
            + "v.created_at,v.updated_at,v.scheduled_at,v.launched_at,v.terminated_at from volumes v where v.deleted = 0) v1 where v1.";

    public static final String SNAPSHOTS = "select b.id,b.volume_id,b.project_id,b.size,b.status,b.encrypted,"
            + "b.fail_reason,b.created_at,b.updated_at from backups b where b.deleted = 0";

    public static final String SNAPSHOTS_COUNT = "select count(b.id) as totalResults from backups b where b.deleted = 0";

}
