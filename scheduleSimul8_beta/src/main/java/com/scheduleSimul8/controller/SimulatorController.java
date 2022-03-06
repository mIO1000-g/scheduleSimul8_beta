package com.scheduleSimul8.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.scheduleSimul8.service.SimulatorService;

@Controller
public class SimulatorController {

	@Autowired
	private SimulatorService sv;

	@GetMapping("/simulator")
	public String getimulator(Model model) {

		model.addAttribute("cllist", sv.getCalender());

		return "simulator";
	}
}
