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

import com.jcs.sbs.result.ResultCount;

@Entity
@Table(name = "backups")
@NamedNativeQueries({

        @NamedNativeQuery(name = "allSnapshots", query = "select * from snapshots s where s.deleted = false"
                + " and s.?6 like ?1" + " ORDER BY ?2 ?3 LIMIT ?4, ?5", resultClass = Snapshot.class),

        @NamedNativeQuery(name = "allSnapshotsResultCount", query = "select count(*) as totalResults from snapshots s where s.deleted = false"
                + " and s.?6 like ?1", resultClass = ResultCount.class) })

public class Snapshot {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "volume_id")
    private String volumeId;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "project_id")
    private String project_id;

    @Column(name = "host")
    private String host;

    @Column(name = "availability_zone")
    private String availabilityZone;

    @Column(name = "size")
    private long volumeSize;

    @Column(name = "display_name")
    private String displayName;

    @Column(name = "display_description")
    private String displayDescription;

    @Column(name = "encryption_id")
    private String encryptionId;

    @Column(name = "volume_type_id")
    private String volumeTypeId;

    @Column(name = "status")
    private String status;

    @Column(name = "deleted")
    private boolean deleted;

    @Column(name = "encrypted")
    private boolean encrypted;

    @Column(name = "container")
    private String container;

    @Column(name = "fail_reason")
    private String failReason;

    @Column(name = "service_metadata")
    private String serviceMetadata;

    @Column(name = "service")
    private String service;

    @Column(name = "object_count")
    private Integer objectCount;

    @Column(name = "parent_id")
    private String parentId;

    @Column(name = "time_stamp")
    private String timestamp;

    @Column(name = "version")
    private String version;

    @Column(name = "actual_size")
    private String actualSize;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(name = "deleted_at")
    private Date deletedAt;

    public Snapshot() {
        super();
    }

    public Snapshot(String id, String volumeId, String userId, String project_id, String host, String availabilityZone,
            long volumeSize, String displayName, String displayDescription,
            String encryptionId, String volumeTypeId, String status, boolean deleted, boolean encrypted,
            String container, String failReason, String serviceMetadata, String service, Integer objectCount,
            String parentId, String timestamp, String version, String actualSize, Date createdAt, Date updatedAt,
            Date deletedAt) {
        super();
        this.id = id;
        this.volumeId = volumeId;
        this.userId = userId;
        this.project_id = project_id;
        this.host = host;
        this.availabilityZone = availabilityZone;
        this.volumeSize = volumeSize;
        this.displayName = displayName;
        this.displayDescription = displayDescription;
        this.encryptionId = encryptionId;
        this.volumeTypeId = volumeTypeId;
        this.status = status;
        this.deleted = deleted;
        this.encrypted = encrypted;
        this.container = container;
        this.failReason = failReason;
        this.serviceMetadata = serviceMetadata;
        this.service = service;
        this.objectCount = objectCount;
        this.parentId = parentId;
        this.timestamp = timestamp;
        this.version = version;
        this.actualSize = actualSize;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVolumeId() {
        return volumeId;
    }

    public void setVolumeId(String volumeId) {
        this.volumeId = volumeId;
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

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getAvailabilityZone() {
        return availabilityZone;
    }

    public void setAvailabilityZone(String availabilityZone) {
        this.availabilityZone = availabilityZone;
    }

    public long getVolumeSize() {
        return volumeSize;
    }

    public void setVolumeSize(long volumeSize) {
        this.volumeSize = volumeSize;
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

    public String getEncryptionId() {
        return encryptionId;
    }

    public void setEncryptionId(String encryptionId) {
        this.encryptionId = encryptionId;
    }

    public String getVolumeTypeId() {
        return volumeTypeId;
    }

    public void setVolumeTypeId(String volumeTypeId) {
        this.volumeTypeId = volumeTypeId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public boolean isEncrypted() {
        return encrypted;
    }

    public void setEncrypted(boolean encrypted) {
        this.encrypted = encrypted;
    }

    public String getContainer() {
        return container;
    }

    public void setContainer(String container) {
        this.container = container;
    }

    public String getFailReason() {
        return failReason;
    }

    public void setFailReason(String failReason) {
        this.failReason = failReason;
    }

    public String getServiceMetadata() {
        return serviceMetadata;
    }

    public void setServiceMetadata(String serviceMetadata) {
        this.serviceMetadata = serviceMetadata;
    }

    public Integer isObjectCount() {
        return objectCount;
    }

    public void setObjectCount(Integer objectCount) {
        this.objectCount = objectCount;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getActualSize() {
        return actualSize;
    }

    public void setActualSize(String actualSize) {
        this.actualSize = actualSize;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
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

    @Override
    public String toString() {
        return "Snapshot [id=" + id + ", volumeId=" + volumeId + ", userId=" + userId + ", project_id=" + project_id
                + ", host=" + host + ", availabilityZone=" + availabilityZone + ", volumeSize=" + volumeSize
                + ", displayName=" + displayName + ", displayDescription=" + displayDescription + ", encryptionId=" + encryptionId + ", volumeTypeId=" + volumeTypeId + ", status="
                + status + ", deleted=" + deleted + ", encrypted=" + encrypted + ", container=" + container
                + ", failReason=" + failReason + ", serviceMetadata=" + serviceMetadata + ", service=" + service
                + ", objectCount=" + objectCount + ", parentId=" + parentId + ", timestamp=" + timestamp + ", version="
                + version + ", actualSize=" + actualSize + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
                + ", deletedAt=" + deletedAt + "]";
    }

}
