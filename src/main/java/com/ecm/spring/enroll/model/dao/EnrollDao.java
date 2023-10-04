package com.ecm.spring.enroll.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.ecm.spring.enroll.model.vo.Client;
import com.ecm.spring.enroll.model.vo.Code;
import com.ecm.spring.enroll.model.vo.Common;
import com.ecm.spring.enroll.model.vo.Deposit;
import com.ecm.spring.enroll.model.vo.Employee;
import com.ecm.spring.enroll.model.vo.Intergrate;
import com.ecm.spring.enroll.model.vo.Loan;

import lombok.extern.slf4j.Slf4j;

@Repository
public class EnrollDao {

	/**
	 * 코드리스트 불러오기
	 * @param sqlSession
	 * @return
	 */
	public List<Code> locodeList(SqlSession sqlSession) {
		List<Code> locodeList = sqlSession.selectList("codeMapper.locodeList");
		return locodeList;
	}
	
	public List<Code> dpcodeList(SqlSession sqlSession) {
		List<Code> dpcodeList = sqlSession.selectList("codeMapper.dpcodeList");
		return dpcodeList;
	}
	
	public List<Code> comcodeList(SqlSession sqlSession) {
		List<Code> comcodeList = sqlSession.selectList("codeMapper.comcodeList");
		return comcodeList;
	}
	
	/**
	 * 사용자 정보 불러오기
	 * @param sqlSession
	 * @return
	 */
	public List<Employee> empList(SqlSession sqlSession) {
		List<Employee> emplist = sqlSession.selectList("empMapper.empList");
		return emplist;
	}
	/**
	 * 여신 정보 데이터 넣기
	 * @param sqlSession
	 * @param l
	 * @return
	 */
	public int insertLo(SqlSession sqlSession, Loan l) {
		int insertLo = sqlSession.insert("loanMapper.insertLo", l);
		return insertLo;
	}
	
	public int insertDp(SqlSession sqlSession, Deposit d) {
		int insertDp  = sqlSession.insert("depoMapper.insertDp", d);
		return insertDp;
	}
	
	public int insertCo(SqlSession sqlSession, Common c) {
		int insertCo = sqlSession.insert("commMapper.insertCo", c);
		return insertCo;
	}
	
/**
 * 통합테이블 정보 데이터 넣기
 * @param sqlSession
 * @param i
 * @return
 */
	public int insertInter(SqlSession sqlSession, Intergrate i) {
		int insertInter = sqlSession.insert("interMapper.insertInter", i);
		return insertInter;
	}


	public int insertClient(SqlSession sqlSession, Client cl) {
		int insertClient = sqlSession.insert("clMapper.insertClient", cl);
		return insertClient;
	}

	public String selectCustRrn(SqlSession sqlSession, String rrnNo) {
		String selectCustRrn = sqlSession.selectOne("clMapper.selectRrn", rrnNo);
		return selectCustRrn;
	}

	public String selectCustNo(SqlSession sqlSession, String rrnNo) {
		String selectCustNo = sqlSession.selectOne("clMapper.selectCustNo",rrnNo);
		return selectCustNo;
	}

	public String selectimgKey(SqlSession sqlSession, String rrnNo) {
		String selectimgKey = sqlSession.selectOne("clMapper.selectimgKey", rrnNo);
		return selectimgKey;
	}

	public String selectimgKey2(SqlSession sqlSession, String rrnNo) {
		String selectimgKey2 = sqlSession.selectOne("clMapper.selectimgKey2", rrnNo);
		return selectimgKey2;
	}
	
	public String selectdpCustRrn(SqlSession sqlSession, String rrnNo) {
		String selectdpCustRrn = sqlSession.selectOne("clMapper.selectdpRrn", rrnNo);
		return selectdpCustRrn;
	}

	public String selectdpCustNo(SqlSession sqlSession, String rrnNo) {
		String selectdpCustNo = sqlSession.selectOne("clMapper.selectdpCustNo",rrnNo);
		return selectdpCustNo;
	}

	public String selectdpimgKey(SqlSession sqlSession, String rrnNo) {
		String selectdpimgKey = sqlSession.selectOne("clMapper.selectdpimgKey", rrnNo);
		return selectdpimgKey;
	}

	public String selectdpimgKey2(SqlSession sqlSession, String rrnNo) {
		String selectdpimgKey2 = sqlSession.selectOne("clMapper.selectdpimgKey2", rrnNo);
		return selectdpimgKey2;
	}
	
	public String selectcoCustRrn(SqlSession sqlSession, String rrnNo) {
		String selectcoCustRrn = sqlSession.selectOne("clMapper.selectcoRrn", rrnNo);
		return selectcoCustRrn;
	}

	public String selectcoCustNo(SqlSession sqlSession, String rrnNo) {
		String selectcoCustNo = sqlSession.selectOne("clMapper.selectcoCustNo",rrnNo);
		return selectcoCustNo;
	}

	public String selectcoimgKey(SqlSession sqlSession, String rrnNo) {
		String selectcoimgKey = sqlSession.selectOne("clMapper.selectcoimgKey", rrnNo);
		return selectcoimgKey;
	}

	public String selectcoimgKey2(SqlSession sqlSession, String rrnNo) {
		String selectcoimgKey2 = sqlSession.selectOne("clMapper.selectcoimgKey2", rrnNo);
		return selectcoimgKey2;
	}

	public int selectCountLoImgKey(SqlSession sqlSession, String rrnNo) {
		int selectCountLoImgKey = sqlSession.selectOne("interMapper.selectCountLoImgKey", rrnNo);
		return selectCountLoImgKey;
	}
	
	public int selectCountDpImgKey(SqlSession sqlSession, String rrnNo) {
		int selectCountDpImgKey = sqlSession.selectOne("interMapper.selectCountDpImgKey", rrnNo);
		return selectCountDpImgKey;
	}
	
	public int selectCountCoImgKey(SqlSession sqlSession, String rrnNo) {
		int selectCountCoImgKey = sqlSession.selectOne("interMapper.selectCountCoImgKey", rrnNo);
		return selectCountCoImgKey;
	}

	public String selectClientRrn(SqlSession sqlSession, String rrnNo) {
		String selectClientRrn = sqlSession.selectOne("clMapper.selectClientRrn",rrnNo);
		return selectClientRrn;
	}

	
	





	
	

}
