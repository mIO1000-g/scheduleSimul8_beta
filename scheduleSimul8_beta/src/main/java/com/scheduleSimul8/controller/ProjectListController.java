package com.scheduleSimul8.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProjectListController {

	@GetMapping("/project_list")
	public String init() {

		return "project_list";
	}

}
