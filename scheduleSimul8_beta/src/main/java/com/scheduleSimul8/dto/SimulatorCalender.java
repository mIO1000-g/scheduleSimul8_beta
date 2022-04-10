package com.scheduleSimul8.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class SimulatorCalender {
	private String yyyymmdd;
	private String mm;
	private String dd;
	private String dow;
}
