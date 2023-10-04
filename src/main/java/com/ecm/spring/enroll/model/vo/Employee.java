package com.ecm.spring.enroll.model.vo;

public class Employee {
	private String userId;
	private String orgCd;
	private String enrUserId;//최초등록사번
	private String enrDtm;//최초등록일자
	private String changeEnrUserId;//최종등록사번
	private String changeEnrDtm;//최종등록일자
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getOrgCd() {
		return orgCd;
	}
	public void setOrgCd(String orgCd) {
		this.orgCd = orgCd;
	}
	public String getEnrUserId() {
		return enrUserId;
	}
	public void setEnrUserId(String enrUserId) {
		this.enrUserId = enrUserId;
	}
	public String getEnrDtm() {
		return enrDtm;
	}
	public void setEnrDtm(String enrDtm) {
		this.enrDtm = enrDtm;
	}
	public String getChangeEnrUserId() {
		return changeEnrUserId;
	}
	public void setChangeEnrUserId(String changeEnrUserId) {
		this.changeEnrUserId = changeEnrUserId;
	}
	public String getChangeEnrDtm() {
		return changeEnrDtm;
	}
	public void setChangeEnrDtm(String changeEnrDtm) {
		this.changeEnrDtm = changeEnrDtm;
	}
	@Override
	public String toString() {
		return "Employee [userId=" + userId + ", orgCd=" + orgCd + ", enrUserId=" + enrUserId + ", enrDtm=" + enrDtm
				+ ", changeEnrUserId=" + changeEnrUserId + ", changeEnrDtm=" + changeEnrDtm + "]";
	}
	
	
	
}
