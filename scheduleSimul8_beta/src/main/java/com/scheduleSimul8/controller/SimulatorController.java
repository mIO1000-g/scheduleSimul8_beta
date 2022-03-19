package com.scheduleSimul8.controller;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.scheduleSimul8.service.SimulatorService;

@Controller
public class SimulatorController {

	@Autowired
	private SimulatorService sv;

	@GetMapping("/simulator")
	public String init(Model model) {

		// 現在日付取得
		final LocalDate today = LocalDate.now();
		Month month = today.getMonth();
		// 月の最終日取得
		int lastDay = month.maxLength();

		// 現在日付の月の最初と最後の日付を取得
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String startDate = dtf.format(LocalDate.of(today.getYear(), month, 1));
		String endDate = dtf.format(LocalDate.of(today.getYear(), month, lastDay));

		// 可変列（カレンダー部）取得
		model.addAttribute("cllist", sv.getCalender(startDate, endDate));

		// 初期値設定
		model.addAttribute("start_date", startDate);
		model.addAttribute("end_date", endDate);
		// ドロップダウンリスト
		model.addAttribute("version_list", sv.getSimulationHeader());

		return "simulator";
	}

	// TODO: RestControllerにすべきかも……
	@PostMapping("/simulator/search")
	public String search(@RequestParam("version") String version
			,@RequestParam("start_date") String startDate
			,@RequestParam("end_date") String endDate
			,Model model) {

		// 可変列（カレンダー部）取得
		model.addAttribute("cllist", sv.getCalender(startDate, endDate));

		// ドロップダウンリストのvalue属性が[title-version]であることが前提
		String[] versionArr = version.split("-");
		// 明細部取得
		model.addAttribute("dtlist", sv.getSimulationDetail(versionArr[0], versionArr[1]));

		// 検索条件部を再設定
		model.addAttribute("start_date", startDate);
		model.addAttribute("end_date", endDate);
		model.addAttribute("version", version);
		// ドロップダウンリスト
		model.addAttribute("version_list", sv.getSimulationHeader());

		return "simulator";
	}

	@PostMapping("/simulator/confirm")
	public String confirm(@RequestParam("version") String version
			,@RequestParam("start_date") String startDate
			,@RequestParam("end_date") String endDate
			,Model model) {


		System.out.println(version);
		System.out.println(startDate);


		model.addAttribute("cllist", sv.getCalender(startDate, endDate));

		//model.addAttribute("dtlist", sv.getSimulationDetail());


		model.addAttribute("start_date", startDate);
		model.addAttribute("end_date", endDate);

		return "simulator";
	}
}
