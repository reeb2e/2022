package egovframework.com.cmmn.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class CommInterceptor extends HandlerInterceptorAdapter{

	private static final Logger LOGGER = LoggerFactory.getLogger(CommInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		LOGGER.debug("======================================================> 전처리 인터셉터 입니다.");
		
		String id = request.getParameter("id");
		
		boolean test = true;
//		if(StringUtils.isNotEmpty(id)) {
		
		if(test) {
			LOGGER.debug("로그인 성공");
		} else {
			LOGGER.debug("로그인 실패");
			ModelAndView modelAndView = new ModelAndView("redirect:/login.do?auth_error=1");
			throw new ModelAndViewDefiningException(modelAndView);
		}
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		
		LOGGER.debug("======================================================> 후처리 인터셉터 입니다.");
		
		modelAndView.addObject("test", "고생하셨습니다 !");
//		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterCompletion(request, response, handler, ex);
	}

	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterConcurrentHandlingStarted(request, response, handler);
	}

	
	
}
