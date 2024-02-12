package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Alien;
import com.example.demo.repository.AlienRepo;

@Controller
public class AlienController {
	@Autowired
	AlienRepo repo;
	@GetMapping("/")
	public String home() {
		return "home.jsp";
	}
	@PostMapping("/addAlien")
	public String addAlien(Alien alien) {
		repo.save(alien);
		return "home.jsp";
	}
	@RequestMapping("/fetchAlien")
	public ModelAndView fetchAlien(@RequestParam int id) {
		ModelAndView mv=new ModelAndView("fetch.jsp");
		Alien alien=repo.findById(id).orElse(null);
		mv.addObject(alien);
		return mv;
	}
}
