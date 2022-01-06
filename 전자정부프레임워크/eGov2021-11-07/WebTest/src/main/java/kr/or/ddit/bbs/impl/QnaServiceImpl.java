package kr.or.ddit.bbs.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import kr.or.ddit.bbs.service.BbsService;
import kr.or.ddit.sample.service.SampleDefaultVO;

@Service ("qnaService")
public class QnaServiceImpl implements BbsService{

	@Override
	public String getName() throws EgovBizException {
		return "으임꺽즈엉";
	}

	@Override
	public String getTitle() throws EgovBizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getList(SampleDefaultVO searchVO) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}
