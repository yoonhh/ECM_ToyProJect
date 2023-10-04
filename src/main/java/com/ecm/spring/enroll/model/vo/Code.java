package com.ecm.spring.enroll.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Code {
	private String mainCateCd;//대분류코드
	private String mainCate;//대분류명
	private String midCateCd;//중분류코드
	private String midCate;//중분류명
	private String subCateCd;//소분류코드
	private String subCate;//소분류 명
	private String docCd;//문서코드
	private String docPsv;//문서보존기간
	private String enrUserId;//최초등록사번
	private String enrDtm;//최초등록일자
	private String changeEnrUserId;//최종등록사번
	private String changeEnrDtm;//최종등록일자
	private String docdel_yn;// 문서코드 상태
	
	public String getMainCateCd() {
		return mainCateCd;
	}

	public void setMainCateCd(String mainCateCd) {
		this.mainCateCd = mainCateCd;
	}

	public String getMainCate() {
		return mainCate;
	}

	public void setMainCate(String mainCate) {
		this.mainCate = mainCate;
	}

	public String getMidCateCd() {
		return midCateCd;
	}

	public void setMidCateCd(String midCateCd) {
		this.midCateCd = midCateCd;
	}

	public String getMidCate() {
		return midCate;
	}

	public void setMidCate(String midCate) {
		this.midCate = midCate;
	}

	public String getSubCateCd() {
		return subCateCd;
	}

	public void setSubCateCd(String subCateCd) {
		this.subCateCd = subCateCd;
	}

	public String getSubCate() {
		return subCate;
	}

	public void setSubCate(String subCate) {
		this.subCate = subCate;
	}

	public String getDocCd() {
		return docCd;
	}

	public void setDocCd(String docCd) {
		this.docCd = docCd;
	}

	public String getDocPsv() {
		return docPsv;
	}

	public void setDocPsv(String docPsv) {
		this.docPsv = docPsv;
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
	
	

	public String getDocdel_yn() {
		return docdel_yn;
	}

	public void setDocdel_yn(String docdel_yn) {
		this.docdel_yn = docdel_yn;
	}

	@Override
	public String toString() {
		return "Code [mainCateCd=" + mainCateCd + ", mainCate=" + mainCate + ", midCateCd=" + midCateCd + ", midCate="
				+ midCate + ", subCateCd=" + subCateCd + ", subCate=" + subCate + ", docCd=" + docCd + ", docPsv="
				+ docPsv + ", enrUserId=" + enrUserId + ", enrDtm=" + enrDtm + ", changeEnrUserId=" + changeEnrUserId
				+ ", changeEnrDtm=" + changeEnrDtm + ", docdel_yn=" + docdel_yn + "]";
	}

	
	
	
}
