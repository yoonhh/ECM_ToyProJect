package com.ecm.spring.enroll.model.vo;

public class Intergrate {
	
	private String mainCateCd;// 대분류 코드
	private String elementId;//엘리먼트아이디
	private String imgKey;//이미지 키
	private int enSeq;// 등록 순서
	private String fileNm;// 파일이름
	private String fileExt;//파일확장자
	private String docCd;//문서코드
	private String orgCd;// 조직코드
	private String enrUserId;//최초등록사번
	private String enrDtm;//최초등록일자
	private String changeEnrUserId;//최종등록사번
	private String changeEnrDtm;//최종등록일자
	private String delYN;
	
	private String rrnNo;//고객 주민번호
	
	public String getRrnNo() {
		return rrnNo;
	}
	public void setRrnNo(String rrnNo) {
		this.rrnNo = rrnNo;
	}
	public String getMainCateCd() {
		return mainCateCd;
	}
	public void setMainCateCd(String mainCateCd) {
		this.mainCateCd = mainCateCd;
	}
	public String getElementId() {
		return elementId;
	}
	public void setElementId(String elementId) {
		this.elementId = elementId;
	}
	public String getImgKey() {
		return imgKey;
	}
	public void setImgKey(String imgKey) {
		this.imgKey = imgKey;
	}
	public int getEnSeq() {
		return enSeq;
	}
	public void setEnSeq(int enSeq) {
		this.enSeq = enSeq;
	}
	public String getFileNm() {
		return fileNm;
	}
	public void setFileNm(String fileNm) {
		this.fileNm = fileNm;
	}
	public String getFileExt() {
		return fileExt;
	}
	public void setFileExt(String fileExt) {
		this.fileExt = fileExt;
	}
	public String getDocCd() {
		return docCd;
	}
	public void setDocCd(String docCd) {
		this.docCd = docCd;
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
	
	public String getOrgCd() {
		return orgCd;
	}
	public void setOrgCd(String orgCd) {
		this.orgCd = orgCd;
	}
	
	public String getDelYN() {
		return delYN;
	}
	public void setDelYN(String delYN) {
		this.delYN = delYN;
	}
	@Override
	public String toString() {
		return "Intergrate [mainCateCd=" + mainCateCd + ", elementId=" + elementId + ", imgKey=" + imgKey + ", enSeq="
				+ enSeq + ", fileNm=" + fileNm + ", fileExt=" + fileExt + ", docCd=" + docCd + ", orgCd=" + orgCd
				+ ", enrUserId=" + enrUserId + ", enrDtm=" + enrDtm + ", changeEnrUserId=" + changeEnrUserId
				+ ", changeEnrDtm=" + changeEnrDtm + ", delYN=" + delYN + ", rrnNo=" + rrnNo + "]";
	}
	
	
	
	
	
	

}
