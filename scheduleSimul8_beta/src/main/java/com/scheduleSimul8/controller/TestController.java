package com.scheduleSimul8.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.scheduleSimul8.dto.Dropdown;
import com.scheduleSimul8.dto.TestDetail;
import com.scheduleSimul8.dto.TestForm;
import com.scheduleSimul8.dto.TestSessionForm;
import com.scheduleSimul8.service.TestService;

@Controller
@SessionAttributes(value = "testSession")
public class TestController {

	@Autowired
	TestService sv;

	//NOTE: 実際はパラメータとして遷移元から渡ってきたものを使う
	@ModelAttribute(value = "testSession")
	public TestSessionForm setupForm() {
		return new TestSessionForm();
	}

	@GetMapping("/test")
	public String init(@ModelAttribute("form") TestForm form
			, @ModelAttribute("testSession") TestSessionForm testSessionForm
			, SessionStatus sessionStatus) {

		//sessionStatus.setComplete();

		testSessionForm.setCount(testSessionForm.getCount() + 1);

		sv.search(form);

		return "test";

	}

	@PostMapping("/test/search")
	public String search(@ModelAttribute("form") TestForm form
			, @ModelAttribute("testSession") TestSessionForm testSessionForm) {

		testSessionForm.setCount(testSessionForm.getCount() + 1);

		for (TestDetail dt : form.getDetail()) {
			if (dt.isCheckbox()) {
				System.out.println(dt.getProjectId());
			}
		}

		sv.search(form);

		return "test";

	}


	@PostMapping("/test/clear")
	public String clear(SessionStatus sessionStatus) {

		sessionStatus.setComplete();

		return "redirect:/test";
	}

	@GetMapping("/test/change")
	@ResponseBody
	public List<Dropdown> changeTitleList(@RequestParam String version) {

		return sv.changeTitleList(version);
	}

}
