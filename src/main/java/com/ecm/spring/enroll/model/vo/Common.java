package com.ecm.spring.enroll.model.vo;

public class Common {
	private String imgKey;// 이미지키
	private String custNo;//고객번호
	private String custNm;//고객이름
	private String rrnNo;//고객 주민번호
	private String enrUserId;//최초등록사번
	private String enrDtm;//최초등록일자
	private String changeEnrUserId;//최종등록사번
	private String changeEnrDtm;//최종등록일자
	private String delYN;// 삭제여부
	public String getImgKey() {
		return imgKey;
	}
	public void setImgKey(String imgKey) {
		this.imgKey = imgKey;
	}
	public String getCustNo() {
		return custNo;
	}
	public void setCustNo(String custNo) {
		this.custNo = custNo;
	}
	public String getCustNm() {
		return custNm;
	}
	public void setCustNm(String custNm) {
		this.custNm = custNm;
	}
	public String getRrnNo() {
		return rrnNo;
	}
	public void setRrnNo(String rrnNo) {
		this.rrnNo = rrnNo;
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
	public String getDelYN() {
		return delYN;
	}
	public void setDelYN(String delYN) {
		this.delYN = delYN;
	}
	@Override
	public String toString() {
		return "Common [imgKey=" + imgKey + ", custNo=" + custNo + ", custNm=" + custNm + ", rrnNo=" + rrnNo
				+ ", enrUserId=" + enrUserId + ", enrDtm=" + enrDtm + ", changeEnrUserId=" + changeEnrUserId
				+ ", changeEnrDtm=" + changeEnrDtm + ", delYN=" + delYN + "]";
	}
	
	
	
	


}
