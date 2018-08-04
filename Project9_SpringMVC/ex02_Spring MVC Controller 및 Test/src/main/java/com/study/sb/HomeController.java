package com.study.sb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		return "home";
	}
	
	@RequestMapping("/result")
	public String result(@ModelAttribute("msg") String msg) {
		
		return "result";
	}
	
	@RequestMapping("/product")
	public String processProduct(Model model) {
		
		ProductVO product = new ProductVO("샘플", 10000);
		
		model.addAttribute(product);
		
		return "productDetail";
	}
	
	// RedirectAttributes는 Session을 통해서 저장됨
	// 다음 Redirect된 RequestMapping에서 접근 가능
	// 
	// Flash이면 Session에 저장 (단, 1회성임)
	// 일반이면 Request에 저장 (request.getParameter)
	@RequestMapping("/beforeRedirect")
	public String beforeRedirect(@RequestParam("originalMsg") String originalMsg, RedirectAttributes rttr) {
		// Model이든 Request이든 addAttribute하지 않으면 Redirect된 페이지에서 접근할 수 없음
		rttr.addFlashAttribute("msg", originalMsg);
		
		return "redirect:/afterRedirect";
	}
	
	@RequestMapping("/afterRedirect")
	public void afterRedirect(@ModelAttribute String msg) {		
	}
	
	@RequestMapping("/json")
	public @ResponseBody ProductVO json() {
		return new ProductVO("샘플 상품", 3000);
	}
}
