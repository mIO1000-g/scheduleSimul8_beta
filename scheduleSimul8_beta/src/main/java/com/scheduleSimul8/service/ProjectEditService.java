package com.scheduleSimul8.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scheduleSimul8.dao.ProjectEditDao;
import com.scheduleSimul8.dto.ProjectEditForm;
import com.scheduleSimul8.entity.M_PROJECT;

@Service
public class ProjectEditService {

	@Autowired
	ProjectEditDao dao;

	public void init(ProjectEditForm form) {

		M_PROJECT entity = dao.selectByPK(form.getProjectId());

		form.setProjectName(entity.getProjectName());

	}

	public int insert(ProjectEditForm form) {

		SimpleDateFormat  dtf = new SimpleDateFormat ("yyyyMMddHHmmss");

		M_PROJECT entity = new M_PROJECT();

		entity.setProjectId(form.getProjectId());
		entity.setProjectName(form.getProjectName());
		entity.setInsertDate(dtf.format(new Date()));
		entity.setUpdateDate(dtf.format(new Date()));

		return dao.insert(entity);
	}

	public int update(ProjectEditForm form) {

		SimpleDateFormat  dtf = new SimpleDateFormat ("yyyyMMddHHmmss");

		M_PROJECT entity = new M_PROJECT();

		entity.setProjectId(form.getProjectId());
		entity.setProjectName(form.getProjectName());
		entity.setUpdateDate(dtf.format(new Date()));

		return dao.updateWherePK(entity);
	}

	public int delete(ProjectEditForm form) {

		M_PROJECT entity = new M_PROJECT();

		entity.setProjectId(form.getProjectId());
		entity.setProjectName(form.getProjectName());

		return dao.deleteWherePK(entity);
	}
}
