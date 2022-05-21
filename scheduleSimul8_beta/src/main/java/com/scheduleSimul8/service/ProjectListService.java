package com.scheduleSimul8.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.scheduleSimul8.dto.ProjectListDetail;
import com.scheduleSimul8.dto.ProjectListForm;


@Service
public class ProjectListService {

	public ProjectListForm search(ProjectListForm form) {

		List<ProjectListDetail> list = new ArrayList<>();

		for (int i = 0; i < 3; i++) {
			ProjectListDetail detail = new ProjectListDetail();

			detail.setNo(String.valueOf(i + 1));
			detail.setProjectId("12345");
			detail.setProjectName("プロジェクト１");

			list.add(detail);
		}

		form.setDetail(list);

		return form;
	}

}
