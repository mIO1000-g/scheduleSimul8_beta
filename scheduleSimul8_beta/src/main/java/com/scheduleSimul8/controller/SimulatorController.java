package com.scheduleSimul8.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SimulatorController {

	@GetMapping("/simulator")

	public String getimulator() {
		return "simulator";
	}
}
