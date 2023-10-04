package com.ecm.spring.list.model.service;

import java.util.List;
import java.util.Map;

import com.ecm.spring.enroll.model.vo.Code;
import com.ecm.spring.enroll.model.vo.Common;
import com.ecm.spring.enroll.model.vo.Intergrate;

public interface ListService {

	public int selectLoListCount();

	public int selectLoListCount(Map<String, Object> paramMap);

	public int selectdpListCount();

	public int selectdpListCount(Map<String, Object> paramMap);

	public int selectcoListCount();

	public int selectcoListCount(Map<String, Object> paramMap);

	public Map<String, Object> selectLoList(int currentPage);

	public Map<String, Object> selectLoList(Map<String, Object> paramMap);

	public Map<String, Object> selectdpList(int currentPage);

	public Map<String, Object> selectdpList(Map<String, Object> paramMap);

	public Map<String, Object> selectcoList(int currentPage);

	public Map<String, Object> selectcoList(Map<String, Object> paramMap);

	public int lochangeStatus(String elementId);

	public int dpchangeStatus(String elementId);

	public int cochangeStatus(String elementId);

	public int selectLoIntercount(String rrnNo);

	public int loInterchangeStatus(String rrnNo);

	public int loInterchangeStatusN(String rrnNo);

	int selectDpIntercount(String rrnNo);

	int dpInterchangeStatus(String rrnNo);

	int dpInterchangeStatusN(String rrnNo);

	int selectCoIntercount(String rrnNo);

	int coInterchangeStatus(String rrnNo);

	int coInterchangeStatusN(String rrnNo);

	public String selectFileName(String test);// eid로 파일이름 조회

	public String selectFileExt(String test);

	//public void codeUpdateStatus();

	public void interUpdateStatus(String i);

	public void coUpdateStatus(String i);

	public void loUpdateStatus(String i);

	public void dpUpdateStatus(String i);

	public List<String> dprrnNoY();

	public List<String> corrnNoY();

	public List<String> lorrnNoY();

	public List<String> codeOverPsv();
	
	public List<Intergrate> comList(String rrnNo);

	public List<Intergrate> dpList(String rrnNo);

	public List<Intergrate> loList(String rrnNo);

}
