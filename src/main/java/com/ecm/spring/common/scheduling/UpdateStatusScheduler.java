package com.ecm.spring.common.scheduling;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ecm.spring.list.model.service.ListService;

@Component
public class UpdateStatusScheduler {

	private Logger logger = LoggerFactory.getLogger(UpdateStatusScheduler.class);

	@Autowired
	private ListService listservice;

	// 지정된 문서보존 기간이 지나면 코드테이블에 있는 상태값과 공통테이블에 등록되어있는 이미지 상태값이 update되는 메소드이다.
	// 통합테이블에 등록되어있는 업무별 이미지들이 모두 삭제가 되면 각 업무테이블에 등록되어있는 데이터도 상태가 업데이트 되어 리스트에 보이지
	// 않는다.
	@Scheduled(fixedDelay = 3600000)// 한시간 마다 실행
	public void updateStatus() {

		logger.info("업데이트 시작");

		// listservice.codeUpdateStatus();// 설정해둔 문서보존기간이 지나면 코드테이블에 있는 문서코드의 상태값이 변함.
		List<String> resultCode = listservice.codeOverPsv();// 문서보존기간이 지난 문서코드들을 불러온다.

		if (resultCode != null) {
			for (String i : resultCode) {

				listservice.interUpdateStatus(i);// 코드테이블에 있는 문서코드의 상태가 변하면 공통(통합) 테이블에 등록한 이미지 상태가 변함.
			}

		}

		List<String> result1 = listservice.dprrnNoY();// Y가 한개라도 있는 고객 주민등록 번호 불러오기
		List<String> result2 = listservice.corrnNoY();// Y가 한개라도 있는 고객 주민등록 번호 불러오기
		List<String> result3 = listservice.lorrnNoY();// Y가 한개라도 있는 고객 주민등록 번호 불러오기

		logger.info("" + result2);

		if (result1 != null) {
			for (String i : result1) {

				listservice.dpUpdateStatus(i);// 공통 테이블에 등록되어있는 Deposit업무 이미지들의 상태 개수와 등록되어있는 Deposit업무의개수가 같아지면
												// Deposit업무테이블 상태가 변함
			}
		}

		if (result2 != null) {
			System.out.println(result2);
			for (String i : result2) {
				listservice.coUpdateStatus(i);// 공통 테이블에 등록되어있는 Common업무 이미지들의 상태 개수와 등록되어있는 Common업무의개수가 같아지면
												// Common업무테이블 상태가 변함
			}
		}

		if (result3 != null) {
			for (String i : result3) {
				listservice.loUpdateStatus(i);// 공통 테이블에 등록되어있는 Loan업무 이미지들의 상태 개수와 등록되어있는 Loan업무의개수가 같아지면 Loan업무테이블 상태가
												// 변함
			}
		}

		logger.info("업데이트 종료");

	}
	
	

}
