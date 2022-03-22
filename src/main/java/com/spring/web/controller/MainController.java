package com.spring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	@RequestMapping("/")
	public String home() {
		System.out.println("home running..");
		return "home";
	}
	
	@GetMapping("/parameter")
	public String parameter(@RequestParam(value="name", defaultValue = "nitin", required = true) String name,  Model model) {
		model.addAttribute("name", name);
		
		//System.out.println("parameter running.!");
	
		return "parameter";
	}
	
	/*without jsp page
	 * */
	@GetMapping("/id")
	@ResponseBody
	public String id(@RequestParam String id) {
		
		return "ID: "+id;
	}
	
}
