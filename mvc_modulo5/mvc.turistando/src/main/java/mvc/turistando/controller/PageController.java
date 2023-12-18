//TURISTANDO


package mvc.turistando.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
	
//	@RequestMapping("/home")
//	@ResponseBody
//	public ModelAndView home(){
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.setViewName("index.html");
//		return modelAndView;		
//	}
//	@RequestMapping("/curso")
//	@ResponseBody
//	public ModelAndView curso(){
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.setViewName("html/course.html");
//		return modelAndView;		
//	}

	@RequestMapping("/home")
	public String home(){
		return "index";
	}
	
	@RequestMapping("/inspire")
	public String inspire(){
		return "inspired";
	}
	
	@RequestMapping("/passagens")
	public String passagens(){
		return "passagens";
	}
	
////	@RequestMapping("/cadastro")
////	public String cadastro(){
////		return "cadastro";
//	}
	@RequestMapping("/login")
	public String login(){
		return "login";
	}
}
