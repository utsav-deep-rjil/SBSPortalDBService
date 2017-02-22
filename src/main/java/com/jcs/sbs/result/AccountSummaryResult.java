package com.jcs.sbs.result;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AccountSummaryResult {
    @Id
    @Column(name="project_id")
    private String project_id;
    private Integer totalSize;
    private Integer totalVolumes;
    private Integer stdVolumesGB;
    private Integer ssdVolumesGB;
    private Integer stdVolumes;
    private Integer ssdVolumes;
    private Integer encryptedVolumes;
    private Integer bootableVolumes;
    private Integer userVolumes;
    private Integer plaintextVolumes;
    private Integer totalSnapshots;
    private Integer volumeLimit;
    private Integer gbLimit;
    private Integer snapshotLimit;
    private Integer perVolumeGBLimit;
    private Integer volumeQuotaUsages;
    private Integer gbQuotaUsages;
    private Integer snapshotQuotaUsages;

    public Integer getPerVolumeGBLimit() {
        return perVolumeGBLimit;
    }

    public void setPerVolumeGBLimit(Integer perVolumeGBLimit) {
        this.perVolumeGBLimit = perVolumeGBLimit;
    }

    public AccountSummaryResult() {
        super();
    }


    public AccountSummaryResult(String project_id, Integer totalSize, Integer totalVolumes, Integer stdVolumesGB, Integer ssdVolumesGB,
            Integer stdVolumes, Integer ssdVolumes, Integer encryptedVolumes, Integer bootableVolumes, Integer userVolumes,
            Integer plaintextVolumes, Integer totalSnapshots, Integer volumeLimit, Integer gbLimit, Integer snapshotLimit,
            Integer perVolumeGBLimit, Integer volumeQuotaUsages, Integer gbQuotaUsages, Integer snapshotQuotaUsages) {
        super();
        this.project_id = project_id;
        this.totalSize = totalSize;
        this.totalVolumes = totalVolumes;
        this.stdVolumesGB = stdVolumesGB;
        this.ssdVolumesGB = ssdVolumesGB;
        this.stdVolumes = stdVolumes;
        this.ssdVolumes = ssdVolumes;
        this.encryptedVolumes = encryptedVolumes;
        this.bootableVolumes = bootableVolumes;
        this.userVolumes = userVolumes;
        this.plaintextVolumes = plaintextVolumes;
        this.totalSnapshots = totalSnapshots;
        this.volumeLimit = volumeLimit;
        this.gbLimit = gbLimit;
        this.snapshotLimit = snapshotLimit;
        this.perVolumeGBLimit = perVolumeGBLimit;
        this.volumeQuotaUsages = volumeQuotaUsages;
        this.gbQuotaUsages = gbQuotaUsages;
        this.snapshotQuotaUsages = snapshotQuotaUsages;
    }

    public AccountSummaryResult(AccountSummaryResult that) {
        super();
        this.project_id = that.project_id;
        this.totalSize = that.totalSize;
        this.totalVolumes = that.totalVolumes;
        this.stdVolumesGB = that.stdVolumesGB;
        this.ssdVolumesGB = that.ssdVolumesGB;
        this.stdVolumes = that.stdVolumes;
        this.ssdVolumes = that.ssdVolumes;
        this.encryptedVolumes = that.encryptedVolumes;
        this.bootableVolumes = that.bootableVolumes;
        this.plaintextVolumes = that.plaintextVolumes;
        this.totalSnapshots = that.totalSnapshots;
        this.volumeLimit = that.volumeLimit;
        this.gbLimit = that.gbLimit;
        this.snapshotLimit = that.snapshotLimit;
        this.perVolumeGBLimit = that.perVolumeGBLimit;
        this.userVolumes = that.userVolumes;
        this.volumeQuotaUsages = that.volumeQuotaUsages;
        this.gbQuotaUsages = that.gbQuotaUsages;
        this.snapshotQuotaUsages = that.snapshotQuotaUsages;
    }

    public String getProject_id() {
        return project_id;
    }

    public void setProject_id(String project_id) {
        this.project_id = project_id;
    }

    public Integer getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(Integer totalSize) {
        this.totalSize = totalSize;
    }

    public Integer getTotalVolumes() {
        return totalVolumes;
    }

    public void setTotalVolumes(Integer totalVolumes) {
        this.totalVolumes = totalVolumes;
    }

    public Integer getStdVolumesGB() {
        return stdVolumesGB;
    }

    public void setStdVolumesGB(Integer stdVolumesGB) {
        this.stdVolumesGB = stdVolumesGB;
    }

    public Integer getSsdVolumesGB() {
        return ssdVolumesGB;
    }

    public void setSsdVolumesGB(Integer ssdVolumesGB) {
        this.ssdVolumesGB = ssdVolumesGB;
    }

    public Integer getStdVolumes() {
        return stdVolumes;
    }

    public void setStdVolumes(Integer stdVolumes) {
        this.stdVolumes = stdVolumes;
    }

    public Integer getSsdVolumes() {
        return ssdVolumes;
    }

    public void setSsdVolumes(Integer ssdVolumes) {
        this.ssdVolumes = ssdVolumes;
    }

    public Integer getEncryptedVolumes() {
        return encryptedVolumes;
    }

    public void setEncryptedVolumes(Integer encryptedVolumes) {
        this.encryptedVolumes = encryptedVolumes;
    }

    public Integer getBootableVolumes() {
        return bootableVolumes;
    }

    public void setBootableVolumes(Integer bootableVolumes) {
        this.bootableVolumes = bootableVolumes;
    }

    public Integer getPlaintextVolumes() {
        return plaintextVolumes;
    }

    public void setPlaintextVolumes(Integer plaintextVolumes) {
        this.plaintextVolumes = plaintextVolumes;
    }

    public Integer getTotalSnapshots() {
        return totalSnapshots;
    }

    public void setTotalSnapshots(Integer totalSnapshots) {
        this.totalSnapshots = totalSnapshots;
    }

    public Integer getVolumeLimit() {
        return volumeLimit;
    }

    public void setVolumeLimit(Integer volumeLimit) {
        this.volumeLimit = volumeLimit;
    }

    public Integer getGbLimit() {
        return gbLimit;
    }

    public void setGbLimit(Integer gbLimit) {
        this.gbLimit = gbLimit;
    }

    public Integer getSnapshotLimit() {
        return snapshotLimit;
    }

    public void setSnapshotLimit(Integer snapshotLimit) {
        this.snapshotLimit = snapshotLimit;
    }

    public Integer getUserVolumes() {
        return userVolumes;
    }

    public void setUserVolumes(Integer userVolumes) {
        this.userVolumes = userVolumes;
    }

    public Integer getVolumeQuotaUsages() {
        return volumeQuotaUsages;
    }

    public void setVolumeQuotaUsages(Integer volumeQuotaUsages) {
        this.volumeQuotaUsages = volumeQuotaUsages;
    }

    public Integer getGbQuotaUsages() {
        return gbQuotaUsages;
    }

    public void setGbQuotaUsages(Integer gbQuotaUsages) {
        this.gbQuotaUsages = gbQuotaUsages;
    }

    public Integer getSnapshotQuotaUsages() {
        return snapshotQuotaUsages;
    }

    public void setSnapshotQuotaUsages(Integer snapshotQuotaUsages) {
        this.snapshotQuotaUsages = snapshotQuotaUsages;
    }

    @Override
    public String toString() {
        return "AccountSummaryResult [project_id=" + project_id + ", totalSize=" + totalSize + ", totalVolumes="
                + totalVolumes + ", stdVolumesGB=" + stdVolumesGB + ", ssdVolumesGB=" + ssdVolumesGB + ", stdVolumes="
                + stdVolumes + ", ssdVolumes=" + ssdVolumes + ", encryptedVolumes=" + encryptedVolumes
                + ", bootableVolumes=" + bootableVolumes + ", userVolumes=" + userVolumes + ", plaintextVolumes="
                + plaintextVolumes + ", totalSnapshots=" + totalSnapshots + ", volumeLimit=" + volumeLimit
                + ", gbLimit=" + gbLimit + ", snapshotLimit=" + snapshotLimit + ", perVolumeGBLimit=" + perVolumeGBLimit
                + ", volumeQuotaUsages=" + volumeQuotaUsages + ", gbQuotaUsages=" + gbQuotaUsages
                + ", snapshotQuotaUsages=" + snapshotQuotaUsages + "]";
    }


}
