package com.ecm.spring.list.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecm.spring.common.model.vo.PageInfo;
import com.ecm.spring.common.template.Pagination;
import com.ecm.spring.enroll.model.service.EnrollService;
import com.ecm.spring.enroll.model.vo.Code;
import com.ecm.spring.enroll.model.vo.Common;
import com.ecm.spring.enroll.model.vo.Deposit;
import com.ecm.spring.enroll.model.vo.Intergrate;
import com.ecm.spring.enroll.model.vo.Loan;
import com.ecm.spring.list.model.dao.ListDao;

@Service
public class ListServiceImpl implements ListService {

	@Autowired
	private ListDao listDao;
	@Autowired
	private SqlSession sqlSession;
	private Pagination pagination;

	public ListServiceImpl(ListDao listDao, SqlSession sqlSession, Pagination pagination) {
		this.listDao = listDao;
		this.pagination = pagination;
		this.sqlSession = sqlSession;

	}

	@Override
	public int selectLoListCount() {
		return listDao.selectLoListCount(sqlSession);
	}
	
	@Override
	public int selectLoListCount(Map<String, Object> paramMap) {
		return listDao.selectLoListCount(sqlSession, paramMap);
	}

	@Override
	public Map<String, Object> selectLoList(int currentPage) {

		Map<String, Object> map = new HashMap();

		int listCount = selectLoListCount();

		// 페이징 처리 작업
		int pageLimit = 5;
		int boardLimit = 10;

		PageInfo pi = pagination.getPageInfo(listCount, currentPage, pageLimit, boardLimit);

		map.put("pi", pi);
		ArrayList<Loan> list = listDao.selectLoList(pi, sqlSession);

		map.put("list", list);

		return map;

	}
	
	@Override
	public Map<String, Object> selectLoList(Map<String, Object> paramMap) {

		Map<String, Object> map = new HashMap();

		int listCount = selectLoListCount(paramMap);

		// 페이징 처리 작업
		int pageLimit = 5;
		int boardLimit = 10;

		PageInfo pi = pagination.getPageInfo(listCount, (Integer)paramMap.get("currentPage"), pageLimit, boardLimit);
		paramMap.put("pi",pi);
		map.put("pi", pi);
		ArrayList<Loan> list = listDao.selectLoList(sqlSession, paramMap);

		map.put("list", list);

		return map;

	}
	
	@Override
	public int selectdpListCount() {
		return listDao.selectdpListCount(sqlSession);
	}
	
	@Override
	public int selectdpListCount(Map<String, Object> paramMap) {
		return listDao.selectdpListCount(sqlSession, paramMap);
	}

	@Override
	public Map<String, Object> selectdpList(int currentPage) {

		Map<String, Object> map = new HashMap();

		int listCount = selectdpListCount();

		// 페이징 처리 작업
		int pageLimit = 5;
		int boardLimit = 10;
		PageInfo pi = pagination.getPageInfo(listCount, currentPage, pageLimit, boardLimit);

		map.put("pi", pi);
		ArrayList<Deposit> list = listDao.selectdpList(pi, sqlSession);

		map.put("list", list);

		return map;

	}
	
	@Override
	public Map<String, Object> selectdpList(Map<String, Object> paramMap) {

		Map<String, Object> map = new HashMap();

		int listCount = selectdpListCount(paramMap);

		// 페이징 처리 작업
		int pageLimit = 5;
		int boardLimit = 10;

		PageInfo pi = pagination.getPageInfo(listCount, (Integer)paramMap.get("currentPage"), pageLimit, boardLimit);
		paramMap.put("pi",pi);
		map.put("pi", pi);
		ArrayList<Deposit> list = listDao.selectdpList(sqlSession, paramMap);

		map.put("list", list);

		return map;

	}
	
	@Override
	public int selectcoListCount() {
		return listDao.selectcoListCount(sqlSession);
	}
	
	@Override
	public int selectcoListCount(Map<String, Object> paramMap) {
		return listDao.selectcoListCount(sqlSession, paramMap);
	}

	@Override
	public Map<String, Object> selectcoList(int currentPage) {

		Map<String, Object> map = new HashMap();

		int listCount = selectcoListCount();

		// 페이징 처리 작업
		int pageLimit = 5;
		int boardLimit = 10;

		PageInfo pi = pagination.getPageInfo(listCount, currentPage, pageLimit, boardLimit);

		map.put("pi", pi);
		ArrayList<Common> list = listDao.selectcoList(pi, sqlSession);

		map.put("list", list);

		return map;

	}
	
	@Override
	public Map<String, Object> selectcoList(Map<String, Object> paramMap) {

		Map<String, Object> map = new HashMap();

		int listCount = selectcoListCount(paramMap);

		// 페이징 처리 작업
		int pageLimit = 5;
		int boardLimit = 10;

		PageInfo pi = pagination.getPageInfo(listCount, (Integer)paramMap.get("currentPage"), pageLimit, boardLimit);
		paramMap.put("pi",pi);
		map.put("pi", pi);
		ArrayList<Common> list = listDao.selectcoList(sqlSession, paramMap);

		map.put("list", list);

		return map;

	}
	
	@Override
	public int lochangeStatus(String elementId) {
		return listDao.lochangeStatus(sqlSession, elementId);
	}
	@Override
	public int dpchangeStatus(String elementId) {
		return listDao.dpchangeStatus(sqlSession, elementId);
	}
	@Override
	public int cochangeStatus(String elementId) {
		return listDao.cochangeStatus(sqlSession, elementId);
	}
	
	@Override
	public int selectLoIntercount(String rrnNo) {
		return listDao.selectLoIntercount(sqlSession, rrnNo);
	}
	
	
	
	@Override
	public int loInterchangeStatus(String rrnNo){
		return listDao.loInterchangeStatus(sqlSession, rrnNo);
	}
	
	@Override
	public int loInterchangeStatusN(String rrnNo){
		return listDao.loInterchangeStatusN(sqlSession, rrnNo);
	}
	
	
	
	@Override
	public int selectDpIntercount(String rrnNo) {
		return listDao.selectDpIntercount(sqlSession, rrnNo);
	}
	
	
	
	
	@Override
	public int dpInterchangeStatus(String rrnNo){
		return listDao.dpInterchangeStatus(sqlSession, rrnNo);
	}
	

	@Override
	public int dpInterchangeStatusN(String rrnNo){
		return listDao.dpInterchangeStatusN(sqlSession, rrnNo);
	}
	
	
	
	@Override
	public int selectCoIntercount(String rrnNo) {
		return listDao.selectCoIntercount(sqlSession, rrnNo);
	}
	
	
	
	@Override
	public int coInterchangeStatus(String rrnNo){
		return listDao.coInterchangeStatus(sqlSession, rrnNo);
	}
	
	
	@Override
	public int coInterchangeStatusN(String rrnNo){
		return listDao.coInterchangeStatusN(sqlSession, rrnNo);
	}
	
	@Override
	public String selectFileName(String test) {
		return listDao.selectFileName(sqlSession, test);
	}
	
	@Override
	public String selectFileExt(String test) {
		return listDao.selectFileExt(sqlSession, test);
	}
	
//	@Override
//	public void codeUpdateStatus() {
//		listDao.codeUpdateStatus(sqlSession);
//	}
	
	@Override
	public void interUpdateStatus(String i) {
		listDao.interUpdateStatus(sqlSession, i);
	}
	
	@Override
	public void coUpdateStatus(String i) {
		listDao.coUpdateStatus(sqlSession, i);
	}
	
	@Override
	public void loUpdateStatus(String i) {
		listDao.loUpdateStatus(sqlSession, i);
	}
	
	@Override
	public void dpUpdateStatus(String i) {
		listDao.dpUpdateStatus(sqlSession, i);
	}
	
	@Override 
	public List<String> dprrnNoY() {
		return listDao.dprrnNoY(sqlSession);
	}
	
	@Override 
	public List<String> lorrnNoY() {
		return listDao.lorrnNoY(sqlSession);
	}
	
	@Override 
	public List<String> corrnNoY() {
		return listDao.corrnNoY(sqlSession);
	}
	
	@Override
	public List<String> codeOverPsv() {
		 return listDao.codeOverPsv(sqlSession);
	}
	
	@Override
	public List<Intergrate> comList(String rrnNo) {
		return listDao.comList(sqlSession, rrnNo);
	}
	
	@Override
	public List<Intergrate> dpList(String rrnNo) {
		return listDao.dpList(sqlSession, rrnNo);
	}
	
	@Override
	public List<Intergrate> loList(String rrnNo) {
		return listDao.loList(sqlSession, rrnNo);
	}
	
	
	
	
	
	
	
	

}
