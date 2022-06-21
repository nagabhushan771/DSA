package com.bininfo.generator.service;

import com.bininfo.generator.entities.BinInfo;

public interface BinInfoService {
	public abstract BinInfo fetchInfo(int number);
}
