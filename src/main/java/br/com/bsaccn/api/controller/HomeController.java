package br.com.bsaccn.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.Api;

@Controller
@Api(tags="Home", hidden=true)
public class HomeController {
	@RequestMapping("/")
	public String home() {
		return "Index";
	}
}
