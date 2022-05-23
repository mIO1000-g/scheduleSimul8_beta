package com.scheduleSimul8.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scheduleSimul8.dao.ProjectListDao;
import com.scheduleSimul8.dto.ProjectListDetail;
import com.scheduleSimul8.dto.ProjectListForm;


@Service
public class ProjectListService {

	@Autowired
	ProjectListDao dao;

	public ProjectListForm search(ProjectListForm form) {

		List<ProjectListDetail> list = dao.selectByProjectName(form.getProjectName());

		form.setDetail(list);

		return form;
	}

}
