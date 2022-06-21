package com.bininfo.generator.service.impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bininfo.generator.entities.BinInfo;
import com.bininfo.generator.service.BinInfoService;
import com.bininfo.generator.utility.BinInfoUtility;

@Service
public class BinInfoServiceImpl implements BinInfoService {

	
	
	@Autowired
	BinInfoUtility utility;

	public BinInfoServiceImpl() {
		
	}

	@Override
	public BinInfo fetchInfo(int number) {
		HashMap<Integer, BinInfo> map = this.utility.loadInfo();
		BinInfo binInfo = null;
		if(map.containsKey(number)) {
			binInfo = map.get(number);
		} else if(map.containsKey(number/10)) {
			binInfo = map.get(number/10);
		} else if(map.containsKey(number/100)) {
			binInfo = map.get(number/100);
		}
		return binInfo;
	}

}
