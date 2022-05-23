package com.scheduleSimul8.dao;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import com.scheduleSimul8.dto.ProjectListDetail;

@ConfigAutowireable
@Dao
public interface ProjectListDao {

	@Select
	public List<ProjectListDetail> selectByProjectName(String projectName);
}
