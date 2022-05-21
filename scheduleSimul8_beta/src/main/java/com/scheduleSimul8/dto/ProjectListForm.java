package com.scheduleSimul8.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectListForm {

	private String no;
	private String projectId;
	private String projectName;

	private List<ProjectListDetail> detail;

}
