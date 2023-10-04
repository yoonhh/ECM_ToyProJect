package com.ecm.spring.enroll.download;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecm.spring.enroll.controller.EnrollController;
import com.ecm.spring.list.model.service.ListService;
import com.windfire.apis.asysConnectData;
import com.windfire.apis.asys.asysUsrElement;

@Controller
public class DownController {

	private Logger logger = LoggerFactory.getLogger(EnrollController.class);

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

	// 로그를 나타내기 위한 변수설정
	public long start = System.currentTimeMillis();
	public long end = System.currentTimeMillis();

	private ListService listservice;

	public DownController() {

	}

	@Autowired
	public DownController(ListService listservice) {
		this.listservice = listservice;
	}

	// 다운로드
	@RequestMapping(value = "download/download", method = RequestMethod.GET)
	public String godown() {

		return "download/download";
	}

	@RequestMapping(value = "download/download.do")
	public String download(@RequestParam String test, HttpServletResponse response, HttpSession session, Model m, HttpServletRequest request)
			throws IOException {
		con = new asysConnectData(Hostname, Port, Description, ID, Password);
		asysUsrElement uePage1 = new asysUsrElement(con);
		String elementId = test;
		uePage1.m_elementId = "XTORM_MAIN::" + elementId + "::IMAGE";
		String localfile = "C:/toy_downImg/" + elementId;
		//String localfile = "/home/p394122/toy_downImg/"+elementId;
		int ret = uePage1.getContent(localfile);
		if (ret != 0) {// 다운로드 실패
			System.out.println("Error, download normal, " + uePage1.getLastError());
			System.out.println("download 실패");
			request.setAttribute("msg", "다운실패");
			return "common/errorPage";
		} else {// 다운로드 성공
			System.out.println("Success, download normal, " + uePage1.m_elementId);
			System.out.println("download 완료 : " + (end - start) / 1000.0 + "초");
			
			
			String fileExt = listservice.selectFileExt(test);
			

			if (fileExt.equals("pptx") || fileExt.equals("xls") || fileExt.equals("pdf") || fileExt.equals("hwp")
					|| fileExt.equals("xlsx") || fileExt.equals("ppt") || fileExt.equals("doc")
					|| fileExt.equals("docx")) {// 확장자가 문서파일일경우
				String fileName = listservice.selectFileName(test);
				String saveFileName = localfile;

				File file = new File(saveFileName);

				// 파일의 크기와 같지 않을 경우 프로그램이 멈추지 않고 계속 실행되거나, 잘못된 정보가 다운로드 될 수 있다.

				byte fileByte[] = FileUtils.readFileToByteArray(file);

				response.setContentType("application/octet-stream");
				response.setContentLength(fileByte.length);

				response.setHeader("Content-Disposition",
						"attachment; fileName=\"" + URLEncoder.encode(fileName, "UTF-8") + "\";");
				response.setHeader("Content-Transfer-Encoding", "binary");

				response.getOutputStream().write(fileByte);
				response.getOutputStream().flush();
				response.getOutputStream().close();
				
				

				

			}
			
			

			
		}
		request.setAttribute("msg", "다운성공");

		return "common/alert";


	}
	

}
