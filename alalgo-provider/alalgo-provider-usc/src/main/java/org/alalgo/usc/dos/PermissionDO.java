package org.alalgo.usc.dos;

import java.sql.Date;

public class PermissionDO {
    private Integer permissionId;  
    private String permissionName;  
    private String allowUrl;  
    private String details;
	private Date createTime;
	private Date updateTime;

	
	public Integer getPermissionId() {
		return permissionId;
	}
	public void setPermissionId(Integer permissionId) {
		this.permissionId = permissionId;
	}
	public String getPermissionName() {
		return permissionName;
	}
	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}
	public String getAllowUrl() {
		return allowUrl;
	}
	public void setAllowUrl(String allowUrl) {
		this.allowUrl = allowUrl;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
}
