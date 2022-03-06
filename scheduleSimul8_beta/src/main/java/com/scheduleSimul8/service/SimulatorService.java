package com.scheduleSimul8.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scheduleSimul8.repository.SimulatorRepository;

@Service
public class SimulatorService {

	@Autowired
	private SimulatorRepository rp;

	public List<Map<String, Object>> getCalender() {
		return rp.getCalender("2022-01-01", "2022-01-31");
	}

}
