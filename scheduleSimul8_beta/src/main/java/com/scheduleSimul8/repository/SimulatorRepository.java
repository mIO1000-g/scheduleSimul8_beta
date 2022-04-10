package com.scheduleSimul8.repository;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SimulatorRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Map<String, Object>> getCalender(String startDate, String endDate) {

		String query =
				"select\r\n" +
				"      to_char(gs.*, 'YYYY/MM/DD') yyyymmdd\r\n" +
				"    , to_char(gs.*, 'MM') mm\r\n" +
				"    , to_char(gs.*, 'DD') dd\r\n" +
				"    , case date_part('dow', gs.*)\r\n" +
				"      when 1 then '月'\r\n" +
				"      when 2 then '火'\r\n" +
				"      when 3 then '水'\r\n" +
				"      when 4 then '木'\r\n" +
				"      when 5 then '金'\r\n" +
				"      when 6 then '土'\r\n" +
				"      when 0 then '日' end dow\r\n" +
				"from\r\n" +
				"    generate_series( \r\n" +
				"          '" + startDate + "' ::timestamp\r\n" +
				"        , '" + endDate + "'\r\n" +
				"        , '24 hours'\r\n" +
				"    ) gs\r\n";

				List<Map<String, Object>> result = jdbcTemplate.queryForList(query);

		return result;
	}

	public List<Map<String, Object>> getSimulationHeader() {

		String query =
				"select\r\n" +
				"   t1.title as key\r\n" +
				"  ,t1.version as value\r\n" +
				"from t_simulation_h t1\r\n" +
				"where 1=1\r\n" +
				"order by" +
				"  t1.title\r\n" +
				"  ,t1.version\r\n";

				List<Map<String, Object>> result = jdbcTemplate.queryForList(query);

		return result;
	}

	public List<Map<String, Object>> getSimulationDetail(String title, String version) {

		String query =
				"select\r\n" +
				"   t1.detail_no\r\n" +
				"  ,t1.task1\r\n" +
				"  ,t1.task2\r\n" +
				"  ,t1.task3\r\n" +
				"  ,t1.task4\r\n" +
				"  ,t1.person_in_charge\r\n" +
				"  ,t1.manhour_estimated\r\n" +
				"  ,t1.productivity\r\n" +
				"  ,t1.manhour_scheduled\r\n" +
				"  ,to_char(to_date(t1.start_date_sheduled, 'yyyymmdd'), 'yyyy-mm-dd') start_date_sheduled\r\n" +
				"  ,to_char(to_date(t1.end_date_sheduled, 'yyyymmdd'), 'yyyy-mm-dd') end_date_sheduled\r\n" +
				"  ,t1.create_datetime\r\n" +
				"  ,t1.update_datetime\r\n" +
				"from t_simulation_d t1\r\n" +
				"where 1=1\r\n" +
				"and t1.title = '" + title + "'\r\n" +
				"and t1.version = '" + version + "'\r\n" +
				"order by" +
				"  t1.detail_no\r\n";

				List<Map<String, Object>> result = jdbcTemplate.queryForList(query);

		return result;
	}

}
