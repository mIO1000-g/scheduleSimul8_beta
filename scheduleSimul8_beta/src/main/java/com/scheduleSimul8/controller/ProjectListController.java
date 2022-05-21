package com.scheduleSimul8.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.scheduleSimul8.dto.ProjectListForm;
import com.scheduleSimul8.service.ProjectListService;

@Controller
public class ProjectListController {

	@Autowired
	ProjectListService sv;

	@GetMapping("/project_list")
	public String init(@ModelAttribute("form") ProjectListForm form) {

		sv.search(form);

		return "project_list";

	}

	@PostMapping("/project_list/entry")
	public String entry(@ModelAttribute("form") ProjectListForm form) {

		return "redirect:/project_edit";
	}

}
