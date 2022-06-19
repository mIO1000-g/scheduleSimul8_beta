package com.scheduleSimul8.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Dropdown {

	private String key;
	private String value;

	public List<Dropdown> convertToDropdownList(List<Map<String, Object>> mapList) {
		List<Dropdown> ddList = new ArrayList<>();
		for (Map<String, Object> el : mapList) {
			Dropdown dd = new Dropdown();
			dd.setKey(el.get("key").toString());
			dd.setValue(el.get("value").toString());
			ddList.add(dd);
		}
		return ddList;
	}
}
