package sb.study.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	private BeanUser user;
	
	@Autowired
	public void setBeanUser(BeanUser user) {
		System.out.println("BeanUser is injected");
		this.user = user;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		// injected
		user.doSomething();
		
		return "home";
	}
	
}
