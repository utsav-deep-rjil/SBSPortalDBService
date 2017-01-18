package com.jcs.sbs.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

import com.jcs.sbs.result.AccountSummaryResult;
import com.jcs.sbs.result.ResultCount;

@Entity
@Table(name = "volumes")
@NamedNativeQueries({

        @NamedNativeQuery(name = "accountSummary", query = "select * from (select v.project_id,"
                + " SUM(v.size) as totalSize," + " COUNT(*) as totalVolumes,"
                + " COUNT(CASE WHEN v.encrypted = true THEN 1 END) as encryptedVolumes,"
                + " COUNT(CASE WHEN v.bootable = true THEN 1 END) as bootableVolumes,"
                + " COUNT(CASE WHEN v.encrypted = false THEN 1 END) as plaintextVolumes,"
                + " COUNT(CASE WHEN v.multiattach = true THEN 1 END) as withMultiAttach"
                + " from volumes v where v.deleted = false group by project_id) A where A.?6 like ?1"
                + " ORDER BY ?2 ?3 LIMIT ?4, ?5", resultClass = AccountSummaryResult.class),

        @NamedNativeQuery(name = "accountSummaryResultCount", query = "select count(*) as totalResults from (select v.project_id,"
                + " SUM(v.size) as totalSize, COUNT(*) as totalVolumes,"
                + " COUNT(CASE WHEN v.encrypted = true THEN 1 END) as encryptedVolumes,"
                + " COUNT(CASE WHEN v.bootable = true THEN 1 END) as bootableVolumes,"
                + " COUNT(CASE WHEN v.encrypted = false THEN 1 END) as plaintextVolumes,"
                + " COUNT(CASE WHEN v.multiattach = true THEN 1 END) as withMultiAttach"
                + " from volumes v where v.deleted = false group by project_id) A where A.?6 like ?1", resultClass = ResultCount.class),

        @NamedNativeQuery(name = "allVolumes", query = "select * from volumes v where v.deleted = false"
                + " and v.?6 like ?1"
                + " ORDER BY ?2 ?3 LIMIT ?4, ?5", resultClass = Volume.class),

        @NamedNativeQuery(name = "allVolumesResultCount", query = "select count(*) as totalResults from volumes v where v.deleted = false"
                + " and v.?6 like ?1", resultClass = ResultCount.class) })

@SqlResultSetMapping(name = "resultMapping", classes = {

        @ConstructorResult(targetClass = com.jcs.sbs.result.AccountSummaryResult.class, columns = {
                @ColumnResult(name = "project_id"), @ColumnResult(name = "totalSize"),
                @ColumnResult(name = "totalVolumes"), @ColumnResult(name = "encryptedVolumes"),
                @ColumnResult(name = "bootableVolumes"), @ColumnResult(name = "plaintextVolumes"),
                @ColumnResult(name = "withMultiAttach") }),

         })

public class Volume {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "ec2_id")
    private String ec2Id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "project_id")
    private String project_id;

    @Column(name = "host")
    private String host;

    @Column(name = "size")
    private long size;

    @Column(name = "availability_zone")
    private String availabilityZone;

    @Column(name = "display_name")
    private String displayName;

    @Column(name = "display_description")
    private String displayDescription;

    @Column(name = "provider_location")
    private String providerLocation;

    @Column(name = "provider_auth")
    private String providerAuth;

    @Column(name = "snapshot_id")
    private String snapshotId;

    @Column(name = "volume_type_id")
    private String volumeTypeId;

    @Column(name = "source_volid")
    private String sourceVolId;

    @Column(name = "provider_geometry")
    private String providerGeometry;

    @Column(name = "_name_id")
    private String _nameId;

    @Column(name = "encryption_key_id")
    private String encryptionKeyId;

    @Column(name = "status")
    private String status;

    @Column(name = "attach_status")
    private String attachStatus;

    @Column(name = "migration_status")
    private String migrationStatus;

    @Column(name = "replication_status")
    private String replicationStatus;

    @Column(name = "replication_extended_status")
    private String replicationExtendedStatus;

    @Column(name = "replication_driver_data")
    private String replicationDriverData;

    @Column(name = "consistencygroup_id")
    private String consistencyGroupId;

    @Column(name = "provider_id")
    private String providerId;

    @Column(name = "miscellaneous")
    private String miscellaneous;

    @Column(name = "encryption_id")
    private String encryptionId;

    @Column(name = "deleted")
    private boolean deleted;

    @Column(name = "bootable")
    private boolean bootable;

    @Column(name = "multiattach")
    private boolean multiattach;

    @Column(name = "encrypted")
    private boolean encrypted;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(name = "deleted_at")
    private Date deletedAt;

    @Column(name = "scheduled_at")
    private Date scheduledAt;

    @Column(name = "launched_at")
    private Date launchedAt;

    @Column(name = "terminated_at")
    private Date terminatedAt;

    public Volume() {
        super();
    }

    public Volume(String id, String ec2Id, String userId, String project_id, String host, long size,
            String availabilityZone, String displayName, String displayDescription, String providerLocation,
            String providerAuth, String snapshotId, String volumeTypeId, String sourceVolId, String providerGeometry,
            String _nameId, String encryptionKeyId, String status, String attachStatus, String migrationStatus,
            String replicationStatus, String replicationExtendedStatus, String replicationDriverData,
            String consistencyGroupId, String providerId, String miscellaneous, String encryptionId, boolean deleted,
            boolean bootable, boolean multiattach, boolean encrypted, Date createdAt, Date updatedAt, Date deletedAt,
            Date scheduledAt, Date launchedAt, Date terminatedAt) {
        super();
        this.id = id;
        this.ec2Id = ec2Id;
        this.userId = userId;
        this.project_id = project_id;
        this.host = host;
        this.size = size;
        this.availabilityZone = availabilityZone;
        this.displayName = displayName;
        this.displayDescription = displayDescription;
        this.providerLocation = providerLocation;
        this.providerAuth = providerAuth;
        this.snapshotId = snapshotId;
        this.volumeTypeId = volumeTypeId;
        this.sourceVolId = sourceVolId;
        this.providerGeometry = providerGeometry;
        this._nameId = _nameId;
        this.encryptionKeyId = encryptionKeyId;
        this.status = status;
        this.attachStatus = attachStatus;
        this.migrationStatus = migrationStatus;
        this.replicationStatus = replicationStatus;
        this.replicationExtendedStatus = replicationExtendedStatus;
        this.replicationDriverData = replicationDriverData;
        this.consistencyGroupId = consistencyGroupId;
        this.providerId = providerId;
        this.miscellaneous = miscellaneous;
        this.encryptionId = encryptionId;
        this.deleted = deleted;
        this.bootable = bootable;
        this.multiattach = multiattach;
        this.encrypted = encrypted;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
        this.scheduledAt = scheduledAt;
        this.launchedAt = launchedAt;
        this.terminatedAt = terminatedAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEc2Id() {
        return ec2Id;
    }

    public void setEc2Id(String ec2Id) {
        this.ec2Id = ec2Id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProject_id() {
        return project_id;
    }

    public void setProject_id(String project_id) {
        this.project_id = project_id;
    }

    public String getHoString() {
        return host;
    }

    public void setHoString(String hoString) {
        this.host = hoString;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getAvailabilityZone() {
        return availabilityZone;
    }

    public void setAvailabilityZone(String availabilityZone) {
        this.availabilityZone = availabilityZone;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayDescription() {
        return displayDescription;
    }

    public void setDisplayDescription(String displayDescription) {
        this.displayDescription = displayDescription;
    }

    public String getProviderLocation() {
        return providerLocation;
    }

    public void setProviderLocation(String providerLocation) {
        this.providerLocation = providerLocation;
    }

    public String getProviderAuth() {
        return providerAuth;
    }

    public void setProviderAuth(String providerAuth) {
        this.providerAuth = providerAuth;
    }

    public String getSnapshotId() {
        return snapshotId;
    }

    public void setSnapshotId(String snapshotId) {
        this.snapshotId = snapshotId;
    }

    public String getVolumeTypeId() {
        return volumeTypeId;
    }

    public void setVolumeTypeId(String volumeTypeId) {
        this.volumeTypeId = volumeTypeId;
    }

    public String getSourceVolId() {
        return sourceVolId;
    }

    public void setSourceVolId(String sourceVolId) {
        this.sourceVolId = sourceVolId;
    }

    public String getProviderGeometry() {
        return providerGeometry;
    }

    public void setProviderGeometry(String providerGeometry) {
        this.providerGeometry = providerGeometry;
    }

    public String get_nameId() {
        return _nameId;
    }

    public void set_nameId(String _nameId) {
        this._nameId = _nameId;
    }

    public String getEncryptionKeyId() {
        return encryptionKeyId;
    }

    public void setEncryptionKeyId(String encryptionKeyId) {
        this.encryptionKeyId = encryptionKeyId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAttachStatus() {
        return attachStatus;
    }

    public void setAttach_status(String attachStatus) {
        this.attachStatus = attachStatus;
    }

    public String getMigrationStatus() {
        return migrationStatus;
    }

    public void setMigrationStatus(String migrationStatus) {
        this.migrationStatus = migrationStatus;
    }

    public String getReplicationStatus() {
        return replicationStatus;
    }

    public void setReplicationStatus(String replicationStatus) {
        this.replicationStatus = replicationStatus;
    }

    public String getReplicationExtendedStatus() {
        return replicationExtendedStatus;
    }

    public void setReplicationExtendedStatus(String replicationExtendedStatus) {
        this.replicationExtendedStatus = replicationExtendedStatus;
    }

    public String getReplicationDriverData() {
        return replicationDriverData;
    }

    public void setReplicationDriverData(String replicationDriverData) {
        this.replicationDriverData = replicationDriverData;
    }

    public String getConsistencyGroupId() {
        return consistencyGroupId;
    }

    public void setConsistencyGroupId(String consistencyGroupId) {
        this.consistencyGroupId = consistencyGroupId;
    }

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    public String getMiscellaneous() {
        return miscellaneous;
    }

    public void setMiscellaneous(String miscellaneous) {
        this.miscellaneous = miscellaneous;
    }

    public String getEncryptionId() {
        return encryptionId;
    }

    public void setEncryptionId(String encryptionId) {
        this.encryptionId = encryptionId;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public boolean isBootable() {
        return bootable;
    }

    public void setBootable(boolean bootable) {
        this.bootable = bootable;
    }

    public boolean isMultiattach() {
        return multiattach;
    }

    public void setMultiattach(boolean multiattach) {
        this.multiattach = multiattach;
    }

    public boolean isEncrypted() {
        return encrypted;
    }

    public void setEncrypted(boolean encrypted) {
        this.encrypted = encrypted;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    public Date getScheduledAt() {
        return scheduledAt;
    }

    public void setScheduledAt(Date scheduledAt) {
        this.scheduledAt = scheduledAt;
    }

    public Date getLaunchedAt() {
        return launchedAt;
    }

    public void setLaunchedAt(Date launchedAt) {
        this.launchedAt = launchedAt;
    }

    public Date getTerminatedAt() {
        return terminatedAt;
    }

    public void setTerminatedAt(Date terminatedAt) {
        this.terminatedAt = terminatedAt;
    }

    @Override
    public String toString() {
        return "Volume [id=" + id + ", ec2Id=" + ec2Id + ", userId=" + userId + ", project_id=" + project_id + ", host="
                + host + ", size=" + size + ", availabilityZone=" + availabilityZone + ", displayName=" + displayName
                + ", displayDescription=" + displayDescription + ", providerLocation=" + providerLocation
                + ", providerAuth=" + providerAuth + ", snapshotId=" + snapshotId + ", volumeTypeId=" + volumeTypeId
                + ", sourceVolId=" + sourceVolId + ", providerGeometry=" + providerGeometry + ", _nameId=" + _nameId
                + ", encryptionKeyId=" + encryptionKeyId + ", status=" + status + ", attachStatus=" + attachStatus
                + ", migrationStatus=" + migrationStatus + ", replicationStatus=" + replicationStatus
                + ", replicationExtendedStatus=" + replicationExtendedStatus + ", replicationDriverData="
                + replicationDriverData + ", consistencyGroupId=" + consistencyGroupId + ", providerId=" + providerId
                + ", miscellaneous=" + miscellaneous + ", encryptionId=" + encryptionId + ", deleted=" + deleted
                + ", bootable=" + bootable + ", multiattach=" + multiattach + ", encrypted=" + encrypted
                + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", deletedAt=" + deletedAt
                + ", scheduledAt=" + scheduledAt + ", launchedAt=" + launchedAt + ", terminatedAt=" + terminatedAt
                + "]";
    }
    

}
