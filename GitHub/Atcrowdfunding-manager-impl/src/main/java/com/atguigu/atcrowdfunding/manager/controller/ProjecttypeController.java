package com.atguigu.atcrowdfunding.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/projecttype")
public class ProjecttypeController {
	@RequestMapping("index")
	public String index() {
		return "projecttype/index";
	}
	@RequestMapping("tag")
	public String tag() {
		return "projecttype/tag";
	}
	
}
