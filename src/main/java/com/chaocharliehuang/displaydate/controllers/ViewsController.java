package com.chaocharliehuang.displaydate.controllers;

import java.util.Date;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ViewsController {
	
	Date date = new Date();
	
	@RequestMapping("")
	public String home() {
		return "home";
	}
	
	@RequestMapping("date")
	public String date(Model model) {
		SimpleDateFormat weekdayFormat = new SimpleDateFormat("EEEE");
		SimpleDateFormat dayFormat = new SimpleDateFormat("d");
		SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM, yyyy");
		model.addAttribute("weekday", weekdayFormat.format(date));
		model.addAttribute("day", dayFormat.format(date));
		model.addAttribute("date", dateFormat.format(date));
		return "date";
	}
	
	@RequestMapping("time")
	public String time(Model model) {
		SimpleDateFormat timeFormat = new SimpleDateFormat("h:m a");
		model.addAttribute("time", timeFormat.format(date));
		return "time";
	}
}
