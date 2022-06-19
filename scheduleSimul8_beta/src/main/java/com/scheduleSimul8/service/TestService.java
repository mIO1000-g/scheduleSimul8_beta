package com.scheduleSimul8.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scheduleSimul8.dao.TestDao;
import com.scheduleSimul8.dto.Dropdown;
import com.scheduleSimul8.dto.TestDetail;
import com.scheduleSimul8.dto.TestForm;


@Service
public class TestService {

	@Autowired
	TestDao dao;

	public TestForm search(TestForm form) {

		List<TestDetail> list = dao.selectByProjectName(form.getProjectName());

		form.setDetail(list);

		form.setTitleList(getTitleList(form.getVersion()));

		return form;
	}

	public List<Dropdown> changeTitleList(String version) {
		return getTitleList(version);
	}

	private List<Dropdown> getTitleList(String version) {

		List<Map<String, Object>> list = dao.selectTitle(version);

		return new Dropdown().convertToDropdownList(list);
	}

}
