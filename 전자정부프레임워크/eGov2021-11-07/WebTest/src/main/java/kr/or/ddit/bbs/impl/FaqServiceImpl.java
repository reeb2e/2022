package kr.or.ddit.bbs.impl;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import kr.or.ddit.bbs.service.FaqService;

@Service("faqService")
public class FaqServiceImpl implements FaqService{

	@Override
	public String getName() throws EgovBizException {
		return "호웅길동";
	}

	
	
}
