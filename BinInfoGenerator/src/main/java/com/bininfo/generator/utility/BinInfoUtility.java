package com.bininfo.generator.utility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Value;
//import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.bininfo.generator.entities.BinInfo;

@Component
public class BinInfoUtility {
	
	HashMap<Integer, BinInfo> map = new HashMap<>();
	
	@Value("${file.path}")
	String fileString;

	public HashMap<Integer, BinInfo> loadInfo(){

		
		BufferedReader reader = null;
		String lineString = "";

		try {
			reader = new BufferedReader(new FileReader(fileString));
			reader.readLine();
			while ((lineString = reader.readLine()) != null) {
				System.out.println(lineString);
				String[] strings = lineString.split(";", 11);
				System.out.println(Integer.parseInt(strings[0]));
				map.put(Integer.parseInt(strings[0]),
						new BinInfo(Integer.parseInt(strings[0]), strings[1], strings[2], strings[3], strings[4],
								strings[5], strings[6], strings[7], strings[8], strings[9], strings[10]));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (int bin : map.keySet()) {
			System.out.println(bin + " : " + map.get(bin).toString());
		}
		return map;
	}
}
