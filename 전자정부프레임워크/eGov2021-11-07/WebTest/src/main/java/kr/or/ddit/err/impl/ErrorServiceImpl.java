package kr.or.ddit.err.impl;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import kr.or.ddit.err.service.ErrorService;

@Service("errorService")
public class ErrorServiceImpl extends EgovAbstractServiceImpl implements ErrorService{

	@Override
	public void sendMail() {
		
		try {
			egovLogger.debug("메일 발송 !");
		} catch (Exception e) {
			egovLogger.error(e.getMessage());
			leaveaTrace("info.nodata.msg");
		}
	}

	@Override
	public void saveDv() {

		try {
			egovLogger.debug("Db 저장 !");
		} catch (Exception e) {
			egovLogger.error(e.getMessage());
			leaveaTrace("info.nodata.msg");
		}
	}

}
