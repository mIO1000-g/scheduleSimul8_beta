package com.scheduleSimul8.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scheduleSimul8.repository.SimulatorRepository;

// TODO: イベントごとのメソッドに変更する

@Service
public class SimulatorService {

	@Autowired
	private SimulatorRepository rp;

	public List<Map<String, Object>> getCalender(String startDate, String endDate) {
		return rp.getCalender(startDate, endDate);
	}

	public List<Map<String, Object>> getSimulationHeader() {
		return rp.getSimulationHeader();
	}


	public List<Map<String, Object>> getSimulationDetail(String title, String version) {
		return rp.getSimulationDetail(title, version);
	}

}
