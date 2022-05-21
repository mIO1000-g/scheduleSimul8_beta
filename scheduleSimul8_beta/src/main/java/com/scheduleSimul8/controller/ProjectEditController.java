package com.scheduleSimul8.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.scheduleSimul8.dto.ProjectEditForm;

@Controller
public class ProjectEditController {

	@GetMapping("/project_edit")
	public String init(@ModelAttribute("form") ProjectEditForm form) {

		return "project_edit";

	}

	@GetMapping("/project_edit/{projectId}")
	public String init(@PathVariable("projectId") String projectId, @ModelAttribute("form") ProjectEditForm form) {

		form.setProjectId(projectId);

		return "project_edit";

	}

}
