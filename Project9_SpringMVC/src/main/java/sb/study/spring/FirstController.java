package sb.study.spring;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <code>@RequsetMapping@</code>을 달 수 있는 기본 단위인
 * <code>@Controller</code>객체이다.
 * 
 * <code>@RequestMapping</code>는 메소드 단위로 작동하지만
 * Controller는 RequstMapping 방식이 나오기 전까지 Class 단위로 작동했다.
 * 
 * 따라서 호환성 문제로 <code>@Controller</code>가 필요한 것 같다.
 * classpath scanning 대상이 Spring Bean이어야 하는 문제도 동시에 해결하기도 하고.
 * 아, 참고로 (없어도 불가능한건 아니지만 최적화를 위해) <code>@Controller</code>가 붙은
 * 클래스에서만 <code>@RequestMapping</code>를 scanning 한다고 한다.
 * 
 * HandlerMapping 객체에 따라 Mapping 방식이 달라지는데,
 * <code>@Controller</code>와 같이 어노테이션 방식으로 작동되려면,
 * 
 * RequestMappingHandlerMapping 객체가 구현체로 작동해야 한다.
 */
@Controller
public class FirstController {
	
	private static final Logger logger = LoggerFactory.getLogger(FirstController.class);
	
	/**
	 * 뷰를 렌더링할 때 home이라는 뷰 네임(view name)을 반환
	 * 
	 * Spring에서 반환형을 보고 어떻게 View를 사용할 지 결정한다.
	 * 
	 * Spring에서 InternalResourceViewResolver가 해당 View를 선택하고,
	 * JstlView가 해당 Model 객체에서 forEach로 request.setAttribute로 설정한다.
	 * 
	 * Spring의 내부 구조를 자세히 알 필요는 없다.
	 * 그러나 못 읽을 만한 소스 코드는 아니다. 
	 * 여유 시간이 많이 들어가고 머리가 아플 뿐이다!
	 * 소스 코드를 읽지 않더라도, 어떻게 돌아가는 지는 공식 문서를 통해서 알 수 있다.
	 * 
	 * Spring 책을 읽거나 StackOverFlow의 답변을 보면, Spring은 꽤 상식적으로 동작한다.
	 * 다만 기본적으로 제공되는 기능이 많아 설정이 복잡한 것을 감수해야 한다.
	 * (망망대해 중 일부씩을 탐사하는 느낌으로 감)
	 * 
	 * Spring은 ArgumentResolver를 통해 <code>@RequestMapping</code>가 달린
	 * 메소드의 인자를 주입한다. ArgumentResolver는 구현체가 굉장히 많아
	 * 지원하는 타입도 굉장히 많고, 객체로 매핑하는 구현체도 있다. 
	 * Form Object, Model Object 등을 Argument에서 전달 받을 수 있다.
	 * 이러한 객체를 Command Object라고 하며,
	 * 
	 * (Command Object 예시)
	 * getter/setter가 있는 객체를 생성하고 Argument로 등록하면
	 * Spring이 Form Data 등을 매핑해서 전달한다.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String returnViewName(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	/**
	 * 반환형이 void 이면 RequestToViewNameTranslator가 작동된다.
	 * 
	 * URL과 일치하는 ViewName으로 InternalResourceViewResolver가 작동하게 될까?
	 * - applyDefaultViewName()이 DispatcherServlet에서 수행됐고,
	 * - viewName이 있으면 ViewResolver가 작동하는데,
	 */
	@RequestMapping(value = "/modelValue")
	public void noReturnType(Model model) {
		// request.setAttribute와 동일함
		model.addAttribute("value", 1234);
	}
	
	// 위와 동일한 예제
	// @RequestMapping에서 method = 를 생략하면
	// GET이다.
	@RequestMapping(value = "/login")
	public void login() {
		logger.info("/login 으로 GET 요청 --> InternalResourceViewResolver --> JstlView --> request.getRequestDispatcher().forward()");
	}
	
	/**
	 * <code>@RequestParam</code> 어노테이션을 변수 앞에 붙이면
	 * getParameter()와 형변환이 자동으로 실행된다.
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPost(
			@RequestParam("id") String id, 
			@RequestParam("password") String password) {
		
		logger.info("사용자의 로그인 요청");
		logger.info("id => " + id);
		logger.info("pw => " + password);
		
		return "redirect:/";
	}
	
	/**
	 * LoginDto 객체에 있는 getter/setter를 보고
	 * <code>@RequestParam</code>의 집합처럼 처리해준다.
	 * 아무런 어노테이션이 필요 없음
	 */
	@RequestMapping(value = "/login_command", method = RequestMethod.POST)
	public String loginPostWithCommandObject(LoginDto dto) {
		logger.info("사용자의 로그인 요청\n" + dto);
		
		return "redirect:/";
	}
}
