package com.scheduleSimul8.dao;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.boot.ConfigAutowireable;

import com.scheduleSimul8.entity.M_PROJECT;

@ConfigAutowireable
@Dao
public interface ProjectEditDao {

	@Select
	public M_PROJECT selectByPK(String projectId);

	@Insert(sqlFile = true)
	public int insert(M_PROJECT entity);

	@Update(sqlFile = true)
	public int updateWherePK(M_PROJECT entity);

	@Delete(sqlFile = true)
	public int deleteWherePK(M_PROJECT entity);
}
