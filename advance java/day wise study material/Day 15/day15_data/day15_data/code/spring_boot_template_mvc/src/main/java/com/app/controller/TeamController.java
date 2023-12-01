package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.service.TeamService;

// Team Controller = Team Handler
@Controller
//@RequestMapping("/")
public class TeamController {
	
//	dependency, service
	
	
//	autowired=byType
	@Autowired
	private TeamService teamService;
	
	
	public TeamController()
	{
		System.out.println("in ctor of "+ getClass());
	}
	
	@GetMapping("/")
	public String getAbbreviations(Model model) {
		
		List<String> abbreviations = teamService.getTeamsAbbreviations();
		
		System.out.println("from controller " + abbreviations);
		
		model.addAttribute("teams_abbr", abbreviations);
		
		return "/teams/add_player_form";
	}
	
	
	
	
	

}
