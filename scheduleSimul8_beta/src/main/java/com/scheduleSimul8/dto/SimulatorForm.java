package com.scheduleSimul8.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class SimulatorForm {

	private String version;
	private String startDate;
	private String endDate;

	private List<Dropdown> versionDropdown;

	private List<SimulatorCalender> calender;

	private List<SimulatorDetail> detail;

}
