package com.scheduleSimul8.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class SimulatorDetail {

	private String detailNo;
	private String task1;
	private String task2;
	private String task3;
	private String task4;
	private String personInCharge;
	private String manhourEstimated;
	private String productivity;
	private String manhourScheduled;
	private String startDateScheduled;
	private String endDateScheduled;
	private String updateDateTime;
}
