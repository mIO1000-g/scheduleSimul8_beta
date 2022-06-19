package com.scheduleSimul8.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WorkflowEditController {

	@GetMapping("/workflow_edit")
	public String init() {


		return "workflow_edit";

	}

}
