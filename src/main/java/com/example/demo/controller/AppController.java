package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Webboard;
import com.example.demo.repo.WebboardRepro;

@Controller
public class AppController {

	@Autowired
	WebboardRepro atwwrp;

	@RequestMapping(method=RequestMethod.GET, value="/app")
	public ModelAndView app() {
		//controler
		ModelAndView v = new ModelAndView();
		List<Webboard> wbList = atwwrp.findAll();
		v.addObject("attname", wbList);
		v.setViewName("index");
		return v;
	}

}