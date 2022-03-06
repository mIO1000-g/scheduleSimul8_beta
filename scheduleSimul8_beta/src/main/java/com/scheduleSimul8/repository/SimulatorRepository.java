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

}
