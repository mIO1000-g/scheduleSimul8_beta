package com.scheduleSimul8.dto;

import org.seasar.doma.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class TestDetail {

	private boolean checkbox;
	private String projectId;
	private String projectName;

}
