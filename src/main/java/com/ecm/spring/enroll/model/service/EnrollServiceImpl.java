package com.ecm.spring.enroll.model.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecm.spring.enroll.model.dao.EnrollDao;
import com.ecm.spring.enroll.model.vo.Client;
import com.ecm.spring.enroll.model.vo.Code;
import com.ecm.spring.enroll.model.vo.Common;
import com.ecm.spring.enroll.model.vo.Deposit;
import com.ecm.spring.enroll.model.vo.Employee;
import com.ecm.spring.enroll.model.vo.Intergrate;
import com.ecm.spring.enroll.model.vo.Loan;

@Service
public class EnrollServiceImpl implements EnrollService{
	private EnrollDao enrollDao;
	private SqlSession sqlSession;
	
	public EnrollServiceImpl() {
		
	}
	
	@Autowired
	public EnrollServiceImpl(EnrollDao enrollDao, SqlSession sqlSession) {
		this.enrollDao = enrollDao;
		this.sqlSession = sqlSession;
	}
	
	/*
	 * 코드 불러오기
	 */
	@Override
	public List<Code> locodeList(){
		
		return enrollDao.locodeList(sqlSession);
	}
	
	@Override
	public List<Code> dpcodeList(){
		
		return enrollDao.dpcodeList(sqlSession);
	}
	
	@Override
	public List<Code> comcodeList(){
		
		return enrollDao.comcodeList(sqlSession);
	}
	/*
	 * 사원불러오기
	 */
	@Override
	public List<Employee> empList()
	{
		return enrollDao.empList(sqlSession);
	}
	/*
	 * 여신 정보 데이터 넣기
	 */
	@Override
	public int insertLo(Loan l) {
		return enrollDao.insertLo(sqlSession, l);
	}
	
	@Override
	public int insertDp(Deposit d) {
		return enrollDao.insertDp(sqlSession, d);
	}
	
	@Override
	public int insertCo(Common c) {
		return enrollDao.insertCo(sqlSession, c);
	}

	
	/*
	 * 통합 정보 데이터 넣기
	 */
	@Override
	public int insertInter(Intergrate i) {
		return enrollDao.insertInter(sqlSession, i);
	}
	
	@Override
	public int insertClient(Client cl) {
		return enrollDao.insertClient(sqlSession, cl);
	}
	
	@Override
	public String selectCustRrn(String rrnNo) {
		String result =enrollDao.selectCustRrn(sqlSession, rrnNo);
		return result;
	}
	@Override
	public String selectCustNo(String rrnNo) {
		return enrollDao.selectCustNo(sqlSession, rrnNo);
	}
	@Override
	public String selectimgKey(String rrnNo) {
		return enrollDao.selectimgKey(sqlSession, rrnNo);
	}
	
	@Override
	public String selectimgKey2(String rrnNo) {
		return enrollDao.selectimgKey2(sqlSession, rrnNo);
	}
	
	@Override
	public String selectdpCustRrn(String rrnNo) {
		String result =enrollDao.selectdpCustRrn(sqlSession, rrnNo);
		return result;
	}
	@Override
	public String selectdpCustNo(String rrnNo) {
		return enrollDao.selectdpCustNo(sqlSession, rrnNo);
	}
	@Override
	public String selectdpimgKey(String rrnNo) {
		return enrollDao.selectdpimgKey(sqlSession, rrnNo);
	}
	
	@Override
	public String selectdpimgKey2(String rrnNo) {
		return enrollDao.selectdpimgKey2(sqlSession, rrnNo);
	}
	
	@Override
	public String selectcoCustRrn(String rrnNo) {
		String result =enrollDao.selectcoCustRrn(sqlSession, rrnNo);
		return result;
	}
	@Override
	public String selectcoCustNo(String rrnNo) {
		return enrollDao.selectcoCustNo(sqlSession, rrnNo);
	}
	@Override
	public String selectcoimgKey(String rrnNo) {
		return enrollDao.selectcoimgKey(sqlSession, rrnNo);
	}
	
	@Override
	public String selectcoimgKey2(String rrnNo) {
		return enrollDao.selectcoimgKey2(sqlSession, rrnNo);
	}
	
	
	@Override
	public int selectCountLoImgKey(String rrnNo) {
		return enrollDao.selectCountLoImgKey(sqlSession, rrnNo);
	}
	
	@Override
	public int selectCountDpImgKey(String rrnNo) {
		return enrollDao.selectCountDpImgKey(sqlSession, rrnNo);
	}
	
	@Override
	public int selectCountCoImgKey(String rrnNo) {
		return enrollDao.selectCountCoImgKey(sqlSession, rrnNo);
	}
	
	@Override
	public String selectClientRrn(String rrnNo) {
		return enrollDao.selectClientRrn(sqlSession, rrnNo);
	}
	
	
	
	
	
	
}
