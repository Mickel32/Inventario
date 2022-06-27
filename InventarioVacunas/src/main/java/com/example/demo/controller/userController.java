package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Usuario;
import com.example.demo.repository.RolRepository;
import com.example.demo.service.UserService;

import aj.org.objectweb.asm.Attribute;

@Controller
public class userController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	RolRepository rolRepository;
	
	@GetMapping({"/","/login"})
	public String index(){
		return "index";
	}
	
	@GetMapping("/userform")
	public String userform(Model model) {
		model.addAttribute("userform", new Usuario());	
		model.addAttribute("userview",  userService.getAllUsers());
		model.addAttribute("roles", rolRepository.findAll());
		model.addAttribute("listTab","active");
		return "user-form/select-tab";
	}
	
	@PostMapping("/userform")
	public String createUser(@Valid @ModelAttribute("userform")Usuario usuario, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {
			model.addAttribute("userform", usuario);	
			model.addAttribute("formTab","active");
		}else {
			try {
				userService.createUser(usuario);
				model.addAttribute("userform", new Usuario());	
				model.addAttribute("listTab","active");
			} catch (Exception e) {
				model.addAttribute("formErrorMessage", e.getMessage());
				model.addAttribute("userform", usuario);	
				model.addAttribute("formTab","active");
				model.addAttribute("userview",  userService.getAllUsers());
				model.addAttribute("roles", rolRepository.findAll());
			}
		}
		model.addAttribute("userview",  userService.getAllUsers());
		model.addAttribute("roles", rolRepository.findAll());
		return "user-form/select-tab";
		
	}

}
