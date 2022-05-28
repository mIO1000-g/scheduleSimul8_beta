package com.scheduleSimul8.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.scheduleSimul8.dto.ProjectEditForm;
import com.scheduleSimul8.service.ProjectEditService;

@Controller
public class ProjectEditController {

	@Autowired
	ProjectEditService sv;

	@GetMapping("/project_edit")
	public String init(@ModelAttribute("form") ProjectEditForm form) {

		form.setEditMode("1");

		return "project_edit";

	}

	@GetMapping("/project_edit/{projectId}")
	public String init(@PathVariable("projectId") String projectId, @ModelAttribute("form") ProjectEditForm form) {

		form.setEditMode("2");
		form.setProjectId(projectId);

		sv.init(form);

		return "project_edit";

	}

	@PostMapping("/project_edit/confirm")
	public String confirm(@ModelAttribute("form") ProjectEditForm form) {

		if ("1".equals(form.getEditMode())) {
			System.out.println("★★ " + form.getProjectId() + " ★★");
			sv.insert(form);
		} else {
			sv.update(form);
		}

		return "redirect:/project_list";

	}

	@PostMapping("/project_edit/delete")
	public String delete(@ModelAttribute("form") ProjectEditForm form) {

		sv.delete(form);

		return "redirect:/project_list";

	}

}
