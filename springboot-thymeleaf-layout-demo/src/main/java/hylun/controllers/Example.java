package hylun.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Example {
	
	@RequestMapping("/")
	public String index(){
		return "index";
	}
	
	@RequestMapping("/one")
	public String one(){
		return "content1";
	}

	@RequestMapping("/two")
	public String two(){
		return "content2";
	}
	
	

}
