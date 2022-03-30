package com.spring.web.controller;

import java.util.List;

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
	public String parameter(@RequestParam(value="name", defaultValue = "nitin", required = true) String name,  @RequestParam(value="age1", defaultValue = "21", required = true) String age,Model model) {
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		//System.out.println("parameter running.!");
	
		return "parameter";
	}
	
	/*without jsp page
	 * pass single   parameter through url
	 * */
	@GetMapping("/id")
	@ResponseBody
	public String id(@RequestParam String id) {
		
		return "ID: "+id;
	}
	
	/*pass multiple parameter through url with default values*/
	@GetMapping("/multiParameter")
	@ResponseBody
	public String multipleParameter(@RequestParam(name="id") String fid, @RequestParam(defaultValue="Nitin") String name) {
		
		return "ID: "+fid+ " Name: "+name;
	}
	
	/*pass multiple parameter through url without default values*/
	
	@GetMapping("/getparameters")
	@ResponseBody
	public String addFoo(@RequestParam(name = "id") String fooId, @RequestParam String name) { 
	    return "ID: " + fooId + " Name: " + name;
	}
	
	/*pass multiple id using list*/
	
	@GetMapping("/multiple")
	@ResponseBody
	public String multiple(@RequestParam List<String> id) {
		
		return "ID: "+id;
	}
}
