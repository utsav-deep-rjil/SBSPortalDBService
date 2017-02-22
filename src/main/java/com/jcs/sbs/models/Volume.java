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
public class Volume {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "project_id")
    private String project_id;

    @Column(name = "size")
    private long size;

    @Column(name = "snapshot_id")
    private String snapshotId;

    @Column(name = "volume_type")
    private String volumeType;

    @Column(name = "status")
    private String status;

    @Column(name = "bootable")
    private boolean bootable;

    @Column(name = "encrypted")
    private boolean encrypted;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(name = "scheduled_at")
    private Date scheduledAt;

    @Column(name = "launched_at")
    private Date launchedAt;

    @Column(name = "terminated_at")
    private Date terminatedAt;

    public Volume() {
        super();
    }

    public Volume(String id, String project_id, long size, String snapshotId, String volumeType, String status,
            boolean bootable, boolean encrypted, Date createdAt, Date updatedAt, Date scheduledAt, Date launchedAt,
            Date terminatedAt) {
        super();
        this.id = id;
        this.project_id = project_id;
        this.size = size;
        this.snapshotId = snapshotId;
        this.volumeType = volumeType;
        this.status = status;
        this.bootable = bootable;
        this.encrypted = encrypted;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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

    public String getProject_id() {
        return project_id;
    }

    public void setProject_id(String project_id) {
        this.project_id = project_id;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getSnapshotId() {
        return snapshotId;
    }

    public void setSnapshotId(String snapshotId) {
        this.snapshotId = snapshotId;
    }

    public String getVolumeType() {
        return volumeType;
    }

    public void setVolumeType(String volumeType) {
        this.volumeType = volumeType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isBootable() {
        return bootable;
    }

    public void setBootable(boolean bootable) {
        this.bootable = bootable;
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
        return "Volume [id=" + id + ", project_id=" + project_id + ", size=" + size + ", snapshotId=" + snapshotId
                + ", volumeType=" + volumeType + ", status=" + status + ", bootable=" + bootable + ", encrypted="
                + encrypted + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", scheduledAt=" + scheduledAt
                + ", launchedAt=" + launchedAt + ", terminatedAt=" + terminatedAt + "]";
    }


}
