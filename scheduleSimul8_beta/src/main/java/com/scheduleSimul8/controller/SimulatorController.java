package com.scheduleSimul8.controller;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.scheduleSimul8.dto.SimulatorForm;
import com.scheduleSimul8.service.SimulatorService;

@Controller
public class SimulatorController {

	@Autowired
	private SimulatorService sv;

	@GetMapping("/simulator")
	public String init(@ModelAttribute("form") SimulatorForm form) {

		// 画面フォーム生成
		//SimulatorForm form = new SimulatorForm();

		// 現在日付取得
		final LocalDate today = LocalDate.now();
		Month month = today.getMonth();
		// 月の最終日取得
		int lastDay = month.maxLength();

		// 現在日付の月の最初と最後の日付を取得
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String startDate = dtf.format(LocalDate.of(today.getYear(), month, 1));
		String endDate = dtf.format(LocalDate.of(today.getYear(), month, lastDay));
		// フォームにセット
		form.setStartDate(startDate);
		form.setEndDate(endDate);

		// 初期化サービス呼び出し
		sv.init(form);

		return "simulator";
	}

	// TODO: RestControllerにすべきかも……
	@PostMapping("/simulator/search")
	public String search(@ModelAttribute("form") SimulatorForm form, Model model) {

		// 検索サービス呼び出し
		sv.search(form);

		return "simulator";
	}

	@PostMapping("/simulator/confirm")
	public String confirm(@RequestParam("version") String version
			,@RequestParam("start_date") String startDate
			,@RequestParam("end_date") String endDate
			,Model model) {


		System.out.println(version);
		System.out.println(startDate);


//		model.addAttribute("cllist", sv.getCalender(startDate, endDate));
//
//		//model.addAttribute("dtlist", sv.getSimulationDetail());
//
//
//		model.addAttribute("start_date", startDate);
//		model.addAttribute("end_date", endDate);

		return "simulator";
	}
}
