package com.app.data.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.data.service.TestService;

@Controller
public class LoginController {
	
	@Autowired
	TestService testService;
	
	@RequestMapping("/")
	public String viewMain(){
		return "index";
	}
	
	@PostMapping("/hello")
	public String loginControl(@RequestParam("name") String name, Model model){
		model.addAttribute("name", name);
		return "hello";
	}
	
	@GetMapping("/userList")
	public String userList(Model model){
		List<String> list = new ArrayList<>();
		list.add("kavesh");
		list.add("vaishnavi");
		list.add("sanjana");
		model.addAttribute("lists", list);

	    return "list";
	}
		
}
