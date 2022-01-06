package egovframework.com.cmmn.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

public class DditSysLogAspect {

	private static final Logger LOGGER = LoggerFactory.getLogger(DditSysLogAspect.class);
	
	public Object logView(ProceedingJoinPoint joinPoint) throws Throwable {

		StopWatch stopWatch = new StopWatch();

		try {
		
			// Service 의 메서드를 실행
			stopWatch.start();
			
			// 실행된 결과 값을 받는다.
			Object retValue = joinPoint.proceed();
			
			LOGGER.debug("loginView ===========================> " + retValue);
			
			// 처리된 프로세스를 controller 또는 호출자에게 전달
			return retValue;
		} catch (Throwable e) {
			throw e;
		} finally {
			
			// 제어를 중지 하고 aop 객체를 소멸 한다.
			stopWatch.stop();
			
			// stopWatch.stop(); 실행 후 처리 업무 로직을 작성해야 한다. (***** 필수 )
			// 조회 이력을 적재 한다.
			
		}
	}
	
	public void logAfter(JoinPoint joinPoint, Object returnVal) throws Throwable {
		LOGGER.debug("logAfter ==========================> " + returnVal);
	}
	
}
