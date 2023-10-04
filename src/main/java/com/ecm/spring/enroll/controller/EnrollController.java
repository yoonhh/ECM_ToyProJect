package com.ecm.spring.enroll.controller;

import java.io.File;
import java.io.IOException;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.FlashMapManager;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.SessionFlashMapManager;

import com.ecm.spring.enroll.model.service.EnrollService;
import com.ecm.spring.enroll.model.vo.Client;
import com.ecm.spring.enroll.model.vo.Code;
import com.ecm.spring.enroll.model.vo.Common;
import com.ecm.spring.enroll.model.vo.Deposit;
import com.ecm.spring.enroll.model.vo.Employee;
import com.ecm.spring.enroll.model.vo.Intergrate;
import com.ecm.spring.enroll.model.vo.Loan;
import com.ecm.spring.list.model.service.ListService;
import com.windfire.apis.asysConnectData;
import com.windfire.apis.asys.asysUsrElement;

@Controller
public class EnrollController {

	private Logger logger = LoggerFactory.getLogger(EnrollController.class);
	private EnrollService enrollservice;
	private asysConnectData con = null;
	@Value("${Hostname}")
	private String Hostname; // 설치예정인 서버 또는 설치된 ‘IP’ 또는 ‘도메인’ 정보
	@Value("${Port:0}")
	private int Port; // XTORM 엔진 내부 통신을 위한 TCP/IP 포트
	private String Description = "Description"; // 연결되는 서버 정보 명칭
	@Value("${ID}")
	private String ID; // XTORM 엔진 접속 ID 기본 값은 “SUPER”
	@Value("${Password}")
	private String Password; // XTORM 엔진 접속 PASSWORD 기본 값은 “SUPER”
	@Value("${TEMPPATH}")
	private String TEMPPATH;

	// 로그를 나타내기 위한 변수설정
	public long start = System.currentTimeMillis();
	public long end = System.currentTimeMillis();

	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	private ListService listservice;

	public EnrollController() {

	}

	@Autowired
	public EnrollController(EnrollService enrollservice, ListService listservice) {
		this.enrollservice = enrollservice;
		this.listservice = listservice;

	}

	// 등록페이지 리스트
	@RequestMapping(value = "enroll/enroll", method = RequestMethod.GET)
	public String enroll(Model m1, Common c) {
//		System.out.print("encrypted test : " + bcryptPasswordEncoder.encode("test"));

		List<Code> lolist = enrollservice.locodeList();// 여신코드 리스트
		List<Code> dplist = enrollservice.dpcodeList();// 수신코드 리스트
		List<Code> comlist = enrollservice.comcodeList();// 공통코드 리스트
		List<Employee> emplist = enrollservice.empList();// 사번 리스트

		m1.addAttribute("lolist", lolist);
		m1.addAttribute("dplist", dplist);
		m1.addAttribute("comlist", comlist);
		m1.addAttribute("emplist", emplist);

		return "enroll/enroll";
	}

	/**
	 * 여신 등록
	 * 
	 * @param file1
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "enroll/loenroll.do", method = RequestMethod.POST)
	public String loinsert(@RequestParam MultipartFile file1, Loan l, Intergrate i, HttpSession session, Model m,
			Client cl, @RequestParam String rrnNo, HttpServletRequest request, HttpServletResponse response,
			RedirectAttributes rttr) throws IOException {

		con = new asysConnectData(Hostname, Port, Description, ID, Password);
		File requestFile = new File(TEMPPATH + UUID.randomUUID().toString());// 임시로 파일 생성
		file1.transferTo(requestFile);// 멀티파트로 받아온 객체를 파일로 전환
		asysUsrElement uePage1 = new asysUsrElement(con);
		uePage1.m_localFile = requestFile.getAbsolutePath();
		uePage1.m_descr = "ScanedImage";
		uePage1.m_cClassId = "EN_LN_CC";
		uePage1.m_userSClass = "SUPER";
		uePage1.m_eClassId = "IMAGE";
		String gateway = "XTORM_MAIN";

		try {

			int ret = uePage1.create(gateway, "", "");
			System.out.println("create : " + start / 1000.0 + "초");
			if (ret != 0) {
				System.out.println("Error, create stream, " + uePage1.getLastError());
				System.out.println("create 실패");
				request.setAttribute("msg", "등록실패");
				return "common/errorPage";
			} else {
				System.out.println("Success, create stream, " + uePage1.m_elementId);
				System.out.println("create 완료 : " + (end - start) / 1000.0 + "초");

				int count = enrollservice.selectCountLoImgKey(rrnNo);// 시퀀스 생성

				// 현재날짜를 문자로
				Date date = new Date();
				String dateToStr = date.toInstant().atOffset(ZoneOffset.UTC)
						.format(DateTimeFormatter.ofPattern("yy/MM/dd"));
				// 15자리 이미지 키 생성 변수 여신
				String s = Integer.toString(ThreadLocalRandom.current().nextInt(10000000, 100000000));
				String s1 = Integer.toString(ThreadLocalRandom.current().nextInt(10000, 100000));
				String l3 = "LN";

				String result = s + l3 + s1;

				// 10자리 고객코드 생성 변수
				String s2 = Integer.toString(ThreadLocalRandom.current().nextInt(10000, 100000));
				String s3 = Integer.toString(ThreadLocalRandom.current().nextInt(10000, 100000));

				String result2 = s2 + s3;

				// eid만 추출
				String eid = uePage1.m_elementId;
				String eid2 = eid.substring(12, 28);
				String mainCd = "03";// 대분류코드
				l.setImgKey(result);// 여신 테이블에 들어갈 이미지키
				i.setImgKey(result);// 통합테이블에 들어갈 이미지키

				i.setFileNm(file1.getOriginalFilename());// 통합테이블에 들어갈 파일이름
				i.setFileExt(FilenameUtils.getExtension(file1.getOriginalFilename()));// 통합테이블에 들어갈 파일 확장자
				i.setElementId(eid2);// 통합테이블에 들어갈 엘리먼트 아이디
				// 여신 테이블에 들어갈 고객번호
				i.setMainCateCd(mainCd);// 대분류 코드
				i.setEnSeq(count);// 시퀀스 생성
				l.setEnrDtm(dateToStr);// 여신테이블에 현재날짜
				i.setEnrDtm(dateToStr); // 통합테이블에 현재날짜

				listservice.loInterchangeStatusN(rrnNo);// 상태가 Y일때 등록시 N으로 여신업무 상태 변경

				String result12 = null;
				String result14 = null;
				String encRrn = bcryptPasswordEncoder.encode(rrnNo);
				
				result12 = enrollservice.selectCustRrn(rrnNo);// 고객테이블의 등록된 여신업무를 등록한 주민번호 불러오기

				result14 = enrollservice.selectClientRrn(rrnNo);// 고객테이블의 등록된 고객번호 불러오기

				if (result12 != null) {// 최초등록이 아닐시 기존의 여신업무로 등록한 주민번호가 있다면 기존의 이미지 키를 공통(통합)테이블에 넣는다(통합에만 추가데이터 넣는다)
					String result4 = enrollservice.selectimgKey2(rrnNo);// 기존의 이미지키 불러오기
					i.setImgKey(result4);
					enrollservice.insertInter(i);// 통합테이블에 데이터 추가

				} else {
					if (result14 != null) {// 다른 업무에는 등록되어있지만 현재 업무에는 등록이 안되어있을경우
						String result3 = enrollservice.selectCustNo(rrnNo);// 기존의 고객번호 불러오기
						l.setCustNo(result3);// 기존 고객번호
						enrollservice.insertLo(l);// 여신 테이블에 데이터 추가
						cl.setCustNo(result3);// 고객테이블의 기존 고객번호 추가
						cl.setImgKey(result); // 고객테이블의 새로 이미지키 생성
						enrollservice.insertClient(cl);
					} else {// 새로운 고객이 새로운 업무 즉 완전 최초등록일때

						l.setCustNo(result2);// 업무에 새로생성 된 고객번호
						enrollservice.insertLo(l);// 여신 테이블에 데이터 추가
						cl.setCustNo(result2);// 고객테이블에 새로생성된 고객번호
						cl.setImgKey(result);// 고객테이블에 새로 생성된 이미지키

						enrollservice.insertClient(cl);

					}

					enrollservice.insertInter(i);// 통합테이블에 데이터 추가

				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		request.setAttribute("msg", "등록성공");

		return "common/alert";

	}

	/**
	 * 수신 등록
	 * 
	 * @param file1
	 * @param d
	 * @param i
	 * @param session
	 * @param m
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "enroll/dpenroll.do", method = RequestMethod.POST)
	public String dpinsert(@RequestParam(value = "file1") MultipartFile file1, Deposit d, Intergrate i,
			HttpSession session, Model m, @RequestParam String rrnNo, Client cl, HttpServletRequest request)
			throws IOException {

		con = new asysConnectData(Hostname, Port, Description, ID, Password);
		File requestFile = new File(TEMPPATH + UUID.randomUUID().toString());
		file1.transferTo(requestFile);
		asysUsrElement uePage1 = new asysUsrElement(con);
		uePage1.m_localFile = requestFile.getAbsolutePath();
		uePage1.m_descr = "ScanedImage";
		uePage1.m_cClassId = "EN_DP_CC";
		uePage1.m_userSClass = "SUPER";
		uePage1.m_eClassId = "IMAGE";
		String gateway = "XTORM_MAIN";

		try {
			int ret = uePage1.create(gateway, "", "");
			System.out.println("create : " + start / 1000.0 + "초");
			if (ret != 0) {
				System.out.println("Error, create, " + uePage1.getLastError());
				System.out.println("create 실패");
				request.setAttribute("msg", "등록실패");
				return "common/errorPage";
			} else {
				System.out.println("Success, create, " + uePage1.m_elementId);
				System.out.println("create 완료 : " + (end - start) / 1000.0 + "초");

				// 15자리 이미지 키 생성 변수 수신
				String a = Integer.toString(ThreadLocalRandom.current().nextInt(10000000, 100000000));
				String a1 = Integer.toString(ThreadLocalRandom.current().nextInt(10000, 100000));
				String d1 = "DP";

				String resultD = a + d1 + a1;

				// 10자리 고객코드 생성 변수
				String s2 = Integer.toString(ThreadLocalRandom.current().nextInt(10000, 100000));
				String s3 = Integer.toString(ThreadLocalRandom.current().nextInt(10000, 100000));

				String result2 = s2 + s3;

				int count = enrollservice.selectCountDpImgKey(rrnNo);// 시퀀스

				// 현재날짜를 문자로
				Date date = new Date();
				String dateToStr = date.toInstant().atOffset(ZoneOffset.UTC)
						.format(DateTimeFormatter.ofPattern("yy/MM/dd"));

				// eid만 추출
				String eid = uePage1.m_elementId;
				String eid2 = eid.substring(12, 28);

				String mainCd = "02";// 대분류코드
				d.setImgKey(resultD);// 수신 테이블에 들어갈 이미지키
				i.setImgKey(resultD);// 통합테이블에 들어갈 이미지키

				i.setFileNm(file1.getOriginalFilename());// 통합테이블에 들어갈 파일이름
				i.setFileExt(FilenameUtils.getExtension(file1.getOriginalFilename()));// 통합테이블에 들어갈 파일 확장자
				i.setElementId(eid2);// 통합테이블에 들어갈 엘리먼트 아이디
				d.setCustNo(result2);// 통합 테이블에 들어갈 고객번호
				i.setMainCateCd(mainCd);// 대분류 코드
				i.setEnSeq(count);// 시퀀스 생성
				d.setEnrDtm(dateToStr);// 여신테이블에 현재날짜
				i.setEnrDtm(dateToStr); // 통합테이블에 현재날짜

				listservice.dpInterchangeStatusN(rrnNo);// 등록시 수신업무 상태 변경

				String result12 = null;
				String result14 = null;

				result12 = enrollservice.selectdpCustRrn(rrnNo);
				String encRrn = bcryptPasswordEncoder.encode(rrnNo);
				result14 = enrollservice.selectClientRrn(rrnNo);

				if (result12 != null) {
					String result4 = enrollservice.selectdpimgKey2(rrnNo);
					i.setImgKey(result4);
					enrollservice.insertInter(i);// 통합테이블에 데이터 추가

				} else {

					if (result14 != null) {
						String result3 = enrollservice.selectCustNo(rrnNo);// 기존의 고객번호 불러오기
						d.setCustNo(result3);
						enrollservice.insertDp(d);// 수신 테이블에 데이터 추가
						cl.setCustNo(result3);
						cl.setImgKey(resultD);
						enrollservice.insertClient(cl);
					} else {
						d.setCustNo(result2);
						enrollservice.insertDp(d);// 수신 테이블에 데이터 추가
						cl.setCustNo(result2);
						cl.setImgKey(resultD);
						enrollservice.insertClient(cl);
					}

					enrollservice.insertInter(i);// 통합테이블에 데이터 추가

				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}

		request.setAttribute("msg", "등록성공");

		return "common/alert";

	}

	/**
	 * 공통 등록
	 * 
	 * @param file1
	 * @param c
	 * @param i
	 * @param session
	 * @param m
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "enroll/coenroll.do", method = RequestMethod.POST)
	public String coinsert(@RequestParam MultipartFile file1, Common c, Intergrate i, HttpSession session, Model m,
			Client cl, @RequestParam String rrnNo, HttpServletRequest request) throws IOException {

		con = new asysConnectData(Hostname, Port, Description, ID, Password);
		File requestFile = new File(TEMPPATH + UUID.randomUUID().toString());
		file1.transferTo(requestFile);
		asysUsrElement uePage1 = new asysUsrElement(con);
		uePage1.m_localFile = requestFile.getAbsolutePath();
		uePage1.m_descr = "ScanedImage";
		uePage1.m_cClassId = "EN_CO_CC";
		uePage1.m_userSClass = "SUPER";
		uePage1.m_eClassId = "IMAGE";
		String gateway = "XTORM_MAIN";

		try {

			int ret = uePage1.create(gateway, "", "");
			System.out.println("create : " + start / 1000.0 + "초");
			if (ret != 0) {
				System.out.println("Error, create stream, " + uePage1.getLastError());
				System.out.println("create 실패");
				request.setAttribute("msg", "등록실패");
				return "common/errorPage";
			} else {
				System.out.println("Success, create stream, " + uePage1.m_elementId);
				System.out.println("create 완료 : " + (end - start) / 1000.0 + "초");

				int count = enrollservice.selectCountCoImgKey(rrnNo);// 시퀀스 (나중에 수정)

				// 현재날짜를 문자로
				Date date = new Date();
				String dateToStr = date.toInstant().atOffset(ZoneOffset.UTC)
						.format(DateTimeFormatter.ofPattern("yy/MM/dd"));

				// eid만 추출
				String eid = uePage1.m_elementId;
				String eid2 = eid.substring(12, 28);

				// 15자리 이미지 키 생성 변수 공통
				String b = Integer.toString(ThreadLocalRandom.current().nextInt(10000000, 100000000));
				String b1 = Integer.toString(ThreadLocalRandom.current().nextInt(10000, 100000));
				String c1 = "CO";

				String resultC = b + c1 + b1;

				// 10자리 고객코드 생성 변수
				String s2 = Integer.toString(ThreadLocalRandom.current().nextInt(10000, 100000));
				String s3 = Integer.toString(ThreadLocalRandom.current().nextInt(10000, 100000));

				String result2 = s2 + s3;

				String mainCd = "01";// 대분류코드
				c.setImgKey(resultC);// 여신 테이블에 들어갈 이미지키
				i.setImgKey(resultC);// 통합테이블에 들어갈 이미지키

				i.setFileNm(file1.getOriginalFilename());// 통합테이블에 들어갈 파일이름
				i.setFileExt(FilenameUtils.getExtension(file1.getOriginalFilename()));// 통합테이블에 들어갈 파일 확장자
				i.setElementId(eid2);// 통합테이블에 들어갈 엘리먼트 아이디
				c.setCustNo(result2);// 여신 테이블에 들어갈 고객번호
				i.setMainCateCd(mainCd);// 대분류 코드
				i.setEnSeq(count);// 시퀀스 생성
				c.setEnrDtm(dateToStr);// 여신테이블에 현재날짜
				i.setEnrDtm(dateToStr); // 통합테이블에 현재날짜

				listservice.coInterchangeStatusN(rrnNo);// 등록시 공통업무 상태 변경

				String result12 = null;
				String result14 = null;

				result12 = enrollservice.selectcoCustRrn(rrnNo);
				result14 = enrollservice.selectClientRrn(rrnNo);

				if (result12 != null) {

					String result4 = enrollservice.selectcoimgKey2(rrnNo);
					i.setImgKey(result4);
					enrollservice.insertInter(i);// 통합테이블에 데이터 추가

				} else {
					if (result14 != null) {
						String result3 = enrollservice.selectCustNo(rrnNo);// 기존의 고객번호 불러오기
						c.setCustNo(result3);
						enrollservice.insertCo(c);// 여신 테이블에 데이터 추가
						cl.setCustNo(result3);
						cl.setImgKey(resultC);
						enrollservice.insertClient(cl);
					} else {

						c.setCustNo(result2);
						enrollservice.insertCo(c);// 여신 테이블에 데이터 추가
						cl.setCustNo(result2);
						cl.setImgKey(resultC);
						enrollservice.insertClient(cl);
					}

					enrollservice.insertInter(i);// 통합테이블에 데이터 추가

				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}

		request.setAttribute("msg", "등록성공");

		return "common/alert";

	}

//	/**
//	 * api eid 삭제 (곧 삭제함)
//	 * 
//	 * @param delete
//	 * @return
//	 */
//	@RequestMapping(value = "enroll/delete.do")
//	public String delete(@RequestParam String delete) {
//		con = new asysConnectData(Hostname, Port, Description, ID, Password);
//		asysUsrElement uePage1 = new asysUsrElement(con);
//		String elementId = delete;
//		uePage1.m_elementId = "XTORM_MAIN::" + elementId + "::IMAGE";
//		int ret = uePage1.delete();
//		if (ret != 0) {
//			System.out.println("Error, failed to delete, " + uePage1.getLastError());
//			System.out.println("delete 실패");
//		} else {
//			System.out.println("Success, delete is done, " + uePage1.m_elementId);
//			System.out.println("delete 완료 : " + (end - start) / 1000.0 + "초");
//		}
//		return "redirect:/";
//	}

}
