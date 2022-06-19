package com.scheduleSimul8.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class TestForm {

	private String projectName;

	private String version;

	private String title;

	private List<Dropdown> titleList;

	private List<TestDetail> detail;

}
