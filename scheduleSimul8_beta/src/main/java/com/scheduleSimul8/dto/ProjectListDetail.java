package com.scheduleSimul8.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectListDetail {

	private String no;
	private String projectId;
	private String projectName;

}
