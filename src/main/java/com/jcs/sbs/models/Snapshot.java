package com.jcs.sbs.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "backups")
public class Snapshot {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "volume_id")
    private String volumeId;

    @Column(name = "project_id")
    private String project_id;

    @Column(name = "size")
    private long volumeSize;

    @Column(name = "status")
    private String status;

    @Column(name = "encrypted")
    private boolean encrypted;

    @Column(name = "fail_reason")
    private String failReason;

    @Column(name = "created_at")
    private Date createdAt;
    
    @Column(name = "updated_at")
    private Date updatedAt;

    public Snapshot() {
        super();
    }

    public Snapshot(String id, String volumeId, String project_id, long volumeSize, String status, boolean encrypted,
            String failReason, Date createdAt, Date updatedAt) {
        super();
        this.id = id;
        this.volumeId = volumeId;
        this.project_id = project_id;
        this.volumeSize = volumeSize;
        this.status = status;
        this.encrypted = encrypted;
        this.failReason = failReason;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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

    public String getProject_id() {
        return project_id;
    }

    public void setProject_id(String project_id) {
        this.project_id = project_id;
    }

    public long getVolumeSize() {
        return volumeSize;
    }

    public void setVolumeSize(long volumeSize) {
        this.volumeSize = volumeSize;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isEncrypted() {
        return encrypted;
    }

    public void setEncrypted(boolean encrypted) {
        this.encrypted = encrypted;
    }

    public String getFailReason() {
        return failReason;
    }

    public void setFailReason(String failReason) {
        this.failReason = failReason;
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

    @Override
    public String toString() {
        return "Snapshot [id=" + id + ", volumeId=" + volumeId + ", project_id=" + project_id + ", volumeSize="
                + volumeSize + ", status=" + status + ", encrypted=" + encrypted + ", failReason=" + failReason
                + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
    }

    
}