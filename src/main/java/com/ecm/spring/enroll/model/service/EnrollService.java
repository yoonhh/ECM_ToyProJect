package com.ecm.spring.enroll.model.service;

import java.util.List;
import java.util.Map;

import com.ecm.spring.enroll.model.vo.Client;
import com.ecm.spring.enroll.model.vo.Code;
import com.ecm.spring.enroll.model.vo.Common;
import com.ecm.spring.enroll.model.vo.Deposit;
import com.ecm.spring.enroll.model.vo.Employee;
import com.ecm.spring.enroll.model.vo.Intergrate;
import com.ecm.spring.enroll.model.vo.Loan;

public interface EnrollService {
	
	public List<Code> locodeList();
	
	public List<Code> dpcodeList();
	
	public List<Code> comcodeList();

	public List<Employee> empList();

	public int insertLo(Loan l);
	
	public int insertDp(Deposit d);
	
	public int insertCo(Common c);

	public int insertInter(Intergrate i);

	public int insertClient(Client cl);

	public String selectCustRrn(String rrnNo);

	public String selectCustNo(String rrnNo);

	public String selectimgKey(String rrnNo);

	public String selectimgKey2(String rrnNo);

	public String selectdpCustRrn(String rrnNo);

	public String selectdpimgKey(String rrnNo);

	public String selectdpCustNo(String rrnNo);

	public String selectdpimgKey2(String rrnNo);
	
	public String selectcoCustRrn(String rrnNo);

	public String selectcoimgKey(String rrnNo);

	public String selectcoCustNo(String rrnNo);

	public String selectcoimgKey2(String rrnNo);
	
	public int selectCountLoImgKey(String rrnNo);

	public int selectCountDpImgKey(String rrnNo);
	
	public int selectCountCoImgKey(String rrnNo);

	public String selectClientRrn(String rrnNo);

	

	

	

	

	

	

	
	
	
		

}
