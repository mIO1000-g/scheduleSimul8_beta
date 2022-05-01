package com.scheduleSimul8.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scheduleSimul8.dto.Dropdown;
import com.scheduleSimul8.dto.SimulatorCalender;
import com.scheduleSimul8.dto.SimulatorDetail;
import com.scheduleSimul8.dto.SimulatorForm;
import com.scheduleSimul8.repository.SimulatorRepository;

// TODO: イベントごとのメソッドに変更する

@Service
public class SimulatorService {

	@Autowired
	private SimulatorRepository rp;

	public SimulatorForm init(SimulatorForm form) {

		// ドロップダウンリスト取得
		form.setVersionDropdown(getSimulationHeader());

		// カレンダー取得
		form.setCalender(getCalender(form.getStartDate(), form.getEndDate()));


		return form;
	}

	public SimulatorForm search(SimulatorForm form) {

		// TODO ドロップダウンリストとカレンダーは、再取得せずにForm自体で持ち回りできないか？

		// ドロップダウンリスト取得
		form.setVersionDropdown(getSimulationHeader());

		// カレンダー取得
		form.setCalender(getCalender(form.getStartDate(), form.getEndDate()));


		// ドロップダウンリストのvalue属性が[title-version]であることが前提
		String[] versionArr = form.getVersion().split("-");

		// 明細部セット
		form.setDetail(getSimulationDetail(versionArr[0], versionArr[1]));

		return form;
	}

	private List<SimulatorCalender> getCalender(String startDate, String endDate) {

		List<Map<String, Object>> list = rp.getCalender(startDate, endDate);

		List<SimulatorCalender> calender = new ArrayList<>();

		for (Map<String, Object> el : list) {
			SimulatorCalender cl = new SimulatorCalender();

			cl.setYyyymmdd(el.get("yyyymmdd").toString());
			cl.setMm(el.get("mm").toString());
			cl.setDd(el.get("dd").toString());
			cl.setDow(el.get("dow").toString());

			calender.add(cl);
		}

		return calender;
	}

	private List<Dropdown> getSimulationHeader() {

		List<Map<String, Object>> list = rp.getSimulationHeader();

		return new Dropdown().convertToDropdownList(list);
	}


	private List<SimulatorDetail> getSimulationDetail(String title, String version) {

		List<Map<String, Object>> list = rp.getSimulationDetail(title, version);

		List<SimulatorDetail> detail = new ArrayList<>();

		for (Map<String, Object> el : list) {
			SimulatorDetail dt = new SimulatorDetail();

			dt.setDetailNo(Objects.toString(el.get("detail_no"), ""));
			dt.setTask1(Objects.toString(el.get("task1"), ""));
			dt.setTask2(Objects.toString(el.get("task2"), ""));
			dt.setTask3(Objects.toString(el.get("task3"), ""));
			dt.setTask4(Objects.toString(el.get("task4"), ""));
			dt.setPersonInCharge(Objects.toString(el.get("person_in_charge"), ""));
			dt.setManhourEstimated(Objects.toString(el.get("manhour_estimated"), ""));
			dt.setProductivity(Objects.toString(el.get("productivity"), ""));
			dt.setManhourScheduled(Objects.toString(el.get("manhour_scheduled"), ""));
			dt.setStartDateScheduled(Objects.toString(el.get("start_date_sheduled"), ""));
			dt.setEndDateScheduled(Objects.toString(el.get("end_date_sheduled"), ""));

			detail.add(dt);
		}

		return detail;
	}

}
