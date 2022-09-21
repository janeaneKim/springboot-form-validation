package com.tts.formvalidation.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.tts.formvalidation.models.PersonForm;

@Controller
public class WebController implements WebMvcConfigurer {
	
	@GetMapping("/")
	public String showForm(PersonForm personForm) {
		return "form";
	}
	
	@PostMapping("/")
	public String checkPersonInfo(@Valid PersonForm personForm, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "form";
		}
		return "redirect:/results";
	}
}
