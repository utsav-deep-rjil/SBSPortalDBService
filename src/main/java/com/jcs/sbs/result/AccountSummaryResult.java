package com.jcs.sbs.result;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AccountSummaryResult {
	@Id
	private String project_id;
	private int totalSize;
	private int totalVolumes;
    private int stdVolumesGB;
    private int ssdVolumesGB;
    private int stdVolumes;
    private int ssdVolumes;
	private int encryptedVolumes;
	private int bootableVolumes;
	private int plaintextVolumes;
	private int withMultiAttach;
	private int totalSnapshots;
	private int volumeLimit;
	private int gbLimit;
	private int snapshotLimit;
	private int perVolumeGBLimit;
	
	
	
    public int getPerVolumeGBLimit() {
        return perVolumeGBLimit;
    }

    public void setPerVolumeGBLimit(int perVolumeGBLimit) {
        this.perVolumeGBLimit = perVolumeGBLimit;
    }

    public AccountSummaryResult() {
        super();
    }
    

    public AccountSummaryResult(String project_id, int totalSize, int totalVolumes, int stdVolumesGB, int ssdVolumesGB,
            int stdVolumes, int ssdVolumes, int encryptedVolumes, int bootableVolumes, int plaintextVolumes,
            int withMultiAttach, int totalSnapshots, int volumeLimit, int gbLimit, int snapshotLimit,
            int perVolumeGBLimit) {
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
        this.plaintextVolumes = plaintextVolumes;
        this.withMultiAttach = withMultiAttach;
        this.totalSnapshots = totalSnapshots;
        this.volumeLimit = volumeLimit;
        this.gbLimit = gbLimit;
        this.snapshotLimit = snapshotLimit;
        this.perVolumeGBLimit = perVolumeGBLimit;
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
        this.withMultiAttach = that.withMultiAttach;
        this.totalSnapshots = that.totalSnapshots;
        this.volumeLimit = that.volumeLimit;
        this.gbLimit = that.gbLimit;
        this.snapshotLimit = that.snapshotLimit;
        this.perVolumeGBLimit = that.perVolumeGBLimit;
    }

    public String getProject_id() {
        return project_id;
    }
    public void setProject_id(String project_id) {
        this.project_id = project_id;
    }
    public int getTotalSize() {
        return totalSize;
    }
    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }
    public int getTotalVolumes() {
        return totalVolumes;
    }
    public void setTotalVolumes(int totalVolumes) {
        this.totalVolumes = totalVolumes;
    }
    public int getStdVolumesGB() {
        return stdVolumesGB;
    }
    public void setStdVolumesGB(int stdVolumesGB) {
        this.stdVolumesGB = stdVolumesGB;
    }
    public int getSsdVolumesGB() {
        return ssdVolumesGB;
    }
    public void setSsdVolumesGB(int ssdVolumesGB) {
        this.ssdVolumesGB = ssdVolumesGB;
    }
    public int getStdVolumes() {
        return stdVolumes;
    }
    public void setStdVolumes(int stdVolumes) {
        this.stdVolumes = stdVolumes;
    }
    public int getSsdVolumes() {
        return ssdVolumes;
    }
    public void setSsdVolumes(int ssdVolumes) {
        this.ssdVolumes = ssdVolumes;
    }
    public int getEncryptedVolumes() {
        return encryptedVolumes;
    }
    public void setEncryptedVolumes(int encryptedVolumes) {
        this.encryptedVolumes = encryptedVolumes;
    }
    public int getBootableVolumes() {
        return bootableVolumes;
    }
    public void setBootableVolumes(int bootableVolumes) {
        this.bootableVolumes = bootableVolumes;
    }
    public int getPlaintextVolumes() {
        return plaintextVolumes;
    }
    public void setPlaintextVolumes(int plaintextVolumes) {
        this.plaintextVolumes = plaintextVolumes;
    }
    public int getWithMultiAttach() {
        return withMultiAttach;
    }
    public void setWithMultiAttach(int withMultiAttach) {
        this.withMultiAttach = withMultiAttach;
    }
    public int getTotalSnapshots() {
        return totalSnapshots;
    }
    public void setTotalSnapshots(int totalSnapshots) {
        this.totalSnapshots = totalSnapshots;
    }
    public int getVolumeLimit() {
        return volumeLimit;
    }
    public void setVolumeLimit(int volumeLimit) {
        this.volumeLimit = volumeLimit;
    }
    public int getGbLimit() {
        return gbLimit;
    }
    public void setGbLimit(int gbLimit) {
        this.gbLimit = gbLimit;
    }
    public int getSnapshotLimit() {
        return snapshotLimit;
    }
    public void setSnapshotLimit(int snapshotLimit) {
        this.snapshotLimit = snapshotLimit;
    }
	
	


}
