package com.ecm.spring.list.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecm.spring.enroll.controller.EnrollController;
import com.ecm.spring.enroll.model.vo.Intergrate;
import com.ecm.spring.list.model.service.ListService;

@Controller
public class ListController {

	private Logger logger = LoggerFactory.getLogger(EnrollController.class);
	private ListService listservice;

	public ListController() {

	}

	@Autowired
	public ListController(ListService listservice) {
		this.listservice = listservice;
	}
	
	/**
	 * 여신업무 리스트 및 검색
	 * @param model
	 * @param currentPage
	 * @param paramMap
	 * @return
	 */
	@RequestMapping("list/loList")
	public String selectloList(Model model, @RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
			@RequestParam Map<String, Object> paramMap ) {
		Map<String, Object> map = new HashMap();
		
		
		
		
		if(paramMap.get("condition")==null) {// 검색요청을 하지 않은경우
			map = listservice.selectLoList(currentPage);
		}else {// 검색요청을 한경우
			//검색에 필여한 데이터를 map에 담아서 paramMap 넣어서을 호출
			// condition, keyword
			paramMap.put("currentPage", currentPage);
			map=listservice.selectLoList(paramMap);
		}
		
//		int result = listservice.selectLoIntercount();
//		if(result!=0) {
//			listservice.loInterchangeStatusN();
//		}
		
		
		
		

		model.addAttribute("map", map);

		return "list/lolist";
	}
	 
	/***
	 * 수신업무 리스트 및 검색
	 * @param model
	 * @param currentPage
	 * @param paramMap
	 * @return
	 */
	@RequestMapping("list/dpList")
	public String selectdpList(Model model, @RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
			@RequestParam Map<String, Object> paramMap) {
		Map<String, Object> map = new HashMap();

		
		
		if(paramMap.get("condition")==null) {// 검색요청을 하지 않은경우
			map = listservice.selectdpList(currentPage);
		}else {// 검색요청을 한경우
			//검색에 필여한 데이터를 map에 담아서 paramMap 넣어서을 호출
			// condition, keyword
			paramMap.put("currentPage", currentPage);
			map=listservice.selectdpList(paramMap);
		}

		model.addAttribute("map", map);

		return "list/dplist";
	}
	
	/**
	 * 공통 업무 리스트 및 조회
	 * @param model
	 * @param currentPage
	 * @param paramMap
	 * @return
	 */
	@RequestMapping("list/coList")
	public String selectcoList(Model model, @RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
			@RequestParam Map<String, Object> paramMap) {
		Map<String, Object> map = new HashMap();

		
		
		if(paramMap.get("condition")==null) {// 검색요청을 하지 않은경우
			map = listservice.selectcoList(currentPage);
		}else {// 검색요청을 한경우
			//검색에 필여한 데이터를 map에 담아서 paramMap을 넣어서 호출
			// condition, keyword
			paramMap.put("currentPage", currentPage);		
			map=listservice.selectcoList(paramMap);
		}

		model.addAttribute("map", map);

		return "list/colist";
	}
	
	
	@RequestMapping(value = "detail/codetail/{rrnNo}")
	public String selectCo(@PathVariable("rrnNo") String rrnNo, Model m) {

		List<Intergrate> comlist = listservice.comList(rrnNo);

		m.addAttribute("comlist", comlist);

		int result = listservice.selectCoIntercount(rrnNo);
		if (result == 0) {
			listservice.coInterchangeStatus(rrnNo);
			return "redirect:/";
		}

		return "detail/codetail";

	}

	@RequestMapping(value = "detail/dpdetail/{rrnNo}")
	public String selectDp(@PathVariable("rrnNo") String rrnNo, Model m) {

		List<Intergrate> dplist = listservice.dpList(rrnNo);

		m.addAttribute("dplist", dplist);

		int result = listservice.selectDpIntercount(rrnNo);
		if (result == 0) {
			listservice.dpInterchangeStatus(rrnNo);
			return "redirect:/";
		}

		return "detail/dpdetail";

	}

	@RequestMapping(value = "detail/lodetail/{rrnNo}")
	public String selectLo(@PathVariable("rrnNo") String rrnNo, Model m) {

		List<Intergrate> lolist = listservice.loList(rrnNo);

		m.addAttribute("lolist", lolist);

		int result = listservice.selectLoIntercount(rrnNo);
		if (result == 0) {
			listservice.loInterchangeStatus(rrnNo);
			return "redirect:/";
		}

		return "detail/lodetail";

	}
	
	@ResponseBody
	@RequestMapping("lochangeStatus")
	public int lochangeStatus(@RequestParam("elementId") String elementId) {
		int result = 0;
		
		
		if(result==0) {
			
			listservice.lochangeStatus(elementId);
			result =1;
		}
		
		
		
		return result;
		
	}
	
	@ResponseBody
	@RequestMapping("dpchangeStatus")
	public int dpchangeStatus(@RequestParam("elementId") String elementId) {
		int result = 0;
		
		
		if(result==0) {
			
			listservice.dpchangeStatus(elementId);
			result =1;
		}
		
		
		
		return result;
		
	}
	
	@ResponseBody
	@RequestMapping("cochangeStatus")
	public int cochangeStatus(@RequestParam("elementId") String elementId) {
		int result = 0;
		
		
		if(result==0) {
			
			listservice.cochangeStatus(elementId);
			result =1;
		}
		
		
		
		return result;
		
	}
	
	
	
	
	
	
}
