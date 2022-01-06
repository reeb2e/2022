package kr.or.ddit.bbs.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import kr.or.ddit.bbs.service.BbsService;
import kr.or.ddit.sample.service.SampleDefaultVO;
import kr.or.ddit.sample.service.SampleVO;
import kr.or.ddit.sample.service.impl.SampleMapper;

@Service("bbsService")
public class BbsServiceImpl extends EgovAbstractServiceImpl implements BbsService {

	@Resource(name = "sampleMapper")
	private SampleMapper sampleDao;
	
	@Resource(name = "egovIdGnrService")
	private EgovIdGnrService egovIdGnrService;
	
	@Override
	public String getTitle() throws EgovBizException {
		egovLogger.debug("실행 클래스 : {}", this.getClass().getCanonicalName());
		return "해피테스트";
	}

	@Override
	public String getName() throws Exception {
		egovLogger.debug("실행 클래스 : {}", this.getClass().getCanonicalName());
		
		boolean test = true;
		if (test) {
			
		} else {
			// EgovAbstractServiceImpl 제공하는 다국어 에러 메시지 처리하는 기능
//			throw processException("fail.common.msg");
			throw processException("fail.common.sql", new String[] {"bbs", "bbs 정보등록"});
		}
		
		return "호웅길도웅";
	}

	@Override
	@SuppressWarnings("unchecked")
	public List getList(SampleDefaultVO searchVO) throws Exception {
		
		List<SampleVO> result = (List<SampleVO>)sampleDao.selectSampleList(searchVO);
		
		for (SampleVO sampleVO : result) {
			String idgen = egovIdGnrService.getNextStringId();
			egovLogger.debug("as-is : {}, to-ve : {}", sampleVO.getId(), idgen);
			sampleVO.setId(idgen);
			System.out.println(sampleVO.toString());
		}
		egovLogger.debug("result : {}" , result);
		
		return result;
	}
	
}
