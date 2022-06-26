package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.Usuario;
import com.example.demo.repository.RolRepository;
import com.example.demo.service.UserService;

@Controller
public class userController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	RolRepository rolRepository;
	
	@GetMapping("/")
	public String index(){
		return "index";
	}
	
	@GetMapping("/userform")
	public String userform(Model model) {
		model.addAttribute("userform", new Usuario());	
		model.addAttribute("userview",  userService.getAllUsers());
		model.addAttribute("roles", rolRepository.findAll());
		return "user-form/select-tab";
	}

}
