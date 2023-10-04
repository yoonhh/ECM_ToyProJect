package com.ecm.spring.list.model.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.ecm.spring.common.model.vo.PageInfo;
import com.ecm.spring.enroll.model.vo.Code;
import com.ecm.spring.enroll.model.vo.Common;
import com.ecm.spring.enroll.model.vo.Deposit;
import com.ecm.spring.enroll.model.vo.Intergrate;
import com.ecm.spring.enroll.model.vo.Loan;

@Repository
public class ListDao {

	public int selectLoListCount(SqlSession sqlSession) {

		return sqlSession.selectOne("loanMapper.selectLoListCount");
	}

	public int selectLoListCount(SqlSession sqlSession, Map<String, Object> paramMap) {

		return sqlSession.selectOne("loanMapper.searchLoListCount", paramMap);
	}

	public ArrayList<Loan> selectLoList(PageInfo pi, SqlSession sqlSession) {
		int limit = pi.getBoardLimit();
		int offset = (pi.getCurrentPage() - 1) * limit;

		RowBounds rowBounds = new RowBounds(offset, limit);// 순서를 잘 지키자

		ArrayList<Loan> list = (ArrayList) sqlSession.selectList("loanMapper.selectLoList", null, rowBounds);// rowBounds는
																												// 무조건
																												// 3번째
		return list;
	}

	public ArrayList<Loan> selectLoList(SqlSession sqlSession, Map<String, Object> paramMap) {

		int offset = (((PageInfo) paramMap.get("pi")).getCurrentPage() - 1)
				* ((PageInfo) paramMap.get("pi")).getBoardLimit();
		int limit = ((PageInfo) paramMap.get("pi")).getBoardLimit();

		RowBounds rowBounds = new RowBounds(offset, limit);

		return (ArrayList) sqlSession.selectList("loanMapper.searchLoList", paramMap, rowBounds);

	}

	public int selectdpListCount(SqlSession sqlSession) {

		return sqlSession.selectOne("depoMapper.selectdpListCount");
	}

	public int selectdpListCount(SqlSession sqlSession, Map<String, Object> paramMap) {

		return sqlSession.selectOne("depoMapper.searchdpListCount", paramMap);
	}

	public ArrayList<Deposit> selectdpList(PageInfo pi, SqlSession sqlSession) {
		int limit = pi.getBoardLimit();
		int offset = (pi.getCurrentPage() - 1) * limit;

		RowBounds rowBounds = new RowBounds(offset, limit);// 순서를 잘 지키자

		ArrayList<Deposit> list = (ArrayList) sqlSession.selectList("depoMapper.selectdpList", null, rowBounds);// rowBounds는
																												// 무조건
																												// 3번째
		return list;
	}

	public ArrayList<Deposit> selectdpList(SqlSession sqlSession, Map<String, Object> paramMap) {

		int offset = (((PageInfo) paramMap.get("pi")).getCurrentPage() - 1)
				* ((PageInfo) paramMap.get("pi")).getBoardLimit();
		int limit = ((PageInfo) paramMap.get("pi")).getBoardLimit();

		RowBounds rowBounds = new RowBounds(offset, limit);

		return (ArrayList) sqlSession.selectList("depoMapper.searchdpList", paramMap, rowBounds);

	}

	public int selectcoListCount(SqlSession sqlSession) {

		return sqlSession.selectOne("commMapper.selectcoListCount");
	}

	public int selectcoListCount(SqlSession sqlSession, Map<String, Object> paramMap) {

		return sqlSession.selectOne("commMapper.searchcoListCount", paramMap);
	}

	public ArrayList<Common> selectcoList(PageInfo pi, SqlSession sqlSession) {
		int limit = pi.getBoardLimit();
		int offset = (pi.getCurrentPage() - 1) * limit;

		RowBounds rowBounds = new RowBounds(offset, limit);// 순서를 잘 지키자

		ArrayList<Common> list = (ArrayList) sqlSession.selectList("commMapper.selectcoList", null, rowBounds);// rowBounds는
																												// 무조건
																												// 3번째
		return list;
	}

	public ArrayList<Common> selectcoList(SqlSession sqlSession, Map<String, Object> paramMap) {

		int offset = (((PageInfo) paramMap.get("pi")).getCurrentPage() - 1)
				* ((PageInfo) paramMap.get("pi")).getBoardLimit();
		int limit = ((PageInfo) paramMap.get("pi")).getBoardLimit();

		RowBounds rowBounds = new RowBounds(offset, limit);

		return (ArrayList) sqlSession.selectList("commMapper.searchcoList", paramMap, rowBounds);

	}

	public int lochangeStatus(SqlSession sqlSession, String elementId) {

		return sqlSession.update("interMapper.lochangeStatus", elementId);
	}

	public int dpchangeStatus(SqlSession sqlSession, String elementId) {

		return sqlSession.update("interMapper.dpchangeStatus", elementId);
	}

	public int cochangeStatus(SqlSession sqlSession, String elementId) {

		return sqlSession.update("interMapper.cochangeStatus", elementId);
	}

	public int selectLoIntercount(SqlSession sqlSession, String rrnNo) {

		return sqlSession.selectOne("loanMapper.selectLoIntercount", rrnNo);
	}

	public int loInterchangeStatus(SqlSession sqlSession, String rrnNo) {

		return sqlSession.update("loanMapper.loInterchangeStatus", rrnNo);
	}

	public int loInterchangeStatusN(SqlSession sqlSession, String rrnNo) {

		return sqlSession.update("loanMapper.loInterchangeStatusN", rrnNo);
	}

	public int selectDpIntercount(SqlSession sqlSession, String rrnNo) {

		return sqlSession.selectOne("depoMapper.selectDpIntercount", rrnNo);
	}

	public int dpInterchangeStatus(SqlSession sqlSession, String rrnNo) {

		return sqlSession.update("depoMapper.dpInterchangeStatus", rrnNo);
	}

	public int dpInterchangeStatusN(SqlSession sqlSession, String rrnNo) {

		return sqlSession.update("depoMapper.dpInterchangeStatusN", rrnNo);
	}

	public int selectCoIntercount(SqlSession sqlSession, String rrnNo) {

		return sqlSession.selectOne("commMapper.selectCoIntercount", rrnNo);
	}

	public int coInterchangeStatus(SqlSession sqlSession, String rrnNo) {

		return sqlSession.update("commMapper.coInterchangeStatus", rrnNo);
	}

	public int coInterchangeStatusN(SqlSession sqlSession, String rrnNo) {

		return sqlSession.update("commMapper.coInterchangeStatusN", rrnNo);
	}

	public String selectFileName(SqlSession sqlSession, String test) {

		return sqlSession.selectOne("interMapper.selectFileName", test);
	}

	public String selectFileExt(SqlSession sqlSession, String test) {

		return sqlSession.selectOne("interMapper.selectFileExt", test);
	}

//	public void codeUpdateStatus(SqlSession sqlSession) {
//		sqlSession.update("codeMapper.codeUpdateStatus");
//
//	}

	public void interUpdateStatus(SqlSession sqlSession, String i) {
		sqlSession.update("interMapper.interUpdateStatus", i);

	}

	public void coUpdateStatus(SqlSession sqlSession, String i) {
		sqlSession.update("commMapper.coUpdateStatus", i);

	}

	public void loUpdateStatus(SqlSession sqlSession, String i) {
		sqlSession.update("loanMapper.loUpdateStatus", i);
	}

	public void dpUpdateStatus(SqlSession sqlSession, String i) {
		sqlSession.update("depoMapper.dpUpdateStatus", i);
	}

	public List<String> dprrnNoY(SqlSession sqlSession) {

		return sqlSession.selectList("depoMapper.dprrnNoY");
	}

	public List<String> lorrnNoY(SqlSession sqlSession) {

		return sqlSession.selectList("loanMapper.lorrnNoY");
	}

	public List<String> corrnNoY(SqlSession sqlSession) {

		return sqlSession.selectList("commMapper.corrnNoY");

	}

	public List<String> codeOverPsv(SqlSession sqlSession) {
		return sqlSession.selectList("codeMapper.codeOverPsv");
		
	}
	
	public List<Intergrate> comList(SqlSession sqlSession, String rrnNo) {
		List<Intergrate> comList = sqlSession.selectList("interMapper.selectcomList", rrnNo);
		return comList;
	}

	public List<Intergrate> dpList(SqlSession sqlSession, String rrnNo) {
		List<Intergrate> dpList = sqlSession.selectList("interMapper.selectdpList", rrnNo);
		return dpList;
	}

	public List<Intergrate> loList(SqlSession sqlSession, String rrnNo) {
		List<Intergrate> loList = sqlSession.selectList("interMapper.selectloList", rrnNo);
		return loList;
	}


	

}
