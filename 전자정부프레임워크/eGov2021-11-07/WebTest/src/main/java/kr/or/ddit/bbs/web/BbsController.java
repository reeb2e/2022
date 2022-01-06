package kr.or.ddit.bbs.web;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import egovframework.com.cmmn.interceptor.CommInterceptor;
import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import kr.or.ddit.bbs.service.BbsService;
import kr.or.ddit.sample.service.SampleDefaultVO;

@Controller
@RequestMapping( value={"/test", "/test2" })
public class BbsController {

//	@Autowired
//	private BbsService bbsService;
//	
//	@Resource(name = "faqService")
//	private FaqService faqService;
//	
//	@Resource(name = "bbsService")
//	private FaqService faqService2;

	@Autowired
	@Qualifier(value = "bbsService")
	private BbsService bbsService;
	
	@Autowired
	@Qualifier(value = "qnaService")
	private BbsService qnaService;
	
	@Autowired
	@Qualifier(value = "propertiesService")
	private EgovPropertyService propertiesService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BbsController.class);
	
//	@RequestMapping(value={"/test.do", "test2.do", "testest.do", "happyTest.do"})
//	@PostMapping(value={"/test.do", "test2.do", "testest.do", "happyTest.do"})
	@GetMapping(value={"/test.do", "/test2.do", "/testest.do", "/happyTest.do"})
	public String selectList(@ModelAttribute("searchVO") SampleDefaultVO searchVO, ModelMap model) throws EgovBizException, Exception {
		
		//ModelAndView model = new ModelAndView();
//		System.out.println(bbsService.getTitle());
//		System.out.println(faqService.getName());
//		System.out.println(faqService2.getName());
		
		/** EgovPropertyService.sample */
		searchVO.setPageUnit(propertiesService.getInt("pageUnit"));
		searchVO.setPageSize(propertiesService.getInt("pageSize"));

		/** pageing setting */
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
		paginationInfo.setPageSize(searchVO.getPageSize());

		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());

		List<?> sampleList = bbsService.getList(searchVO);
		paginationInfo.setTotalRecordCount(100);

		model.addAttribute("paginationInfo", paginationInfo);
		model.addAttribute("resultList", sampleList);
		
		System.out.println(bbsService.getName());
		System.out.println(qnaService.getName());
		
		return "test";
	}
	
}
