package com.scheduleSimul8.dao;

import java.util.List;
import java.util.Map;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import com.scheduleSimul8.dto.TestDetail;

@ConfigAutowireable
@Dao
public interface TestDao {

	@Select
	public List<TestDetail> selectByProjectName(String projectName);

	@Select
	public List<Map<String, Object>> selectTitle(String version);

}
