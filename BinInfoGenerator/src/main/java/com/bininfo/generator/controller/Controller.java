package com.bininfo.generator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bininfo.generator.entities.BinInfo;
import com.bininfo.generator.service.BinInfoService;

@RestController
public class Controller {
	
	@Autowired
	BinInfoService service;
	
	@GetMapping("/getinfo/{number}")
	public BinInfo fetchBinInfo(@PathVariable String number) {
		number = number.substring(0, 6);
		System.out.println(number);
		return this.service.fetchInfo(Integer.parseInt(number));
	}
}
