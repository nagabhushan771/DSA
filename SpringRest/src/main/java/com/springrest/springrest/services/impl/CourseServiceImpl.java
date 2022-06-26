package com.springrest.springrest.services.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Service;

import com.springrest.springrest.entities.BinInfo;
import com.springrest.springrest.entities.Course;
import com.springrest.springrest.services.CourseService;


@Service
public class CourseServiceImpl implements CourseService {
	
	List<Course> list;
	HashMap<Integer, BinInfo> map = new HashMap<>();
	public CourseServiceImpl() {
		list = new ArrayList<>();
		list.add(new Course(125, "Java Core Course", "This course contains basics of java"));
		list.add(new Course(124, "SpringBoot course", "Creating restAPI using Spring Boot"));
		String fileString = "C:\\Users\\naag0\\Desktop\\bin-file-assignment.csv";
		BufferedReader reader = null;
		String lineString = "";
		
		try {
			reader = new BufferedReader(new FileReader(fileString));
			reader.readLine();
			while((lineString = reader.readLine()) != null) {
				System.out.println(lineString);
				String[] strings = lineString.split(";", 11);
				System.out.println(Integer.parseInt(strings[0]));
				map.put(Integer.parseInt(strings[0]), new BinInfo(Integer.parseInt(strings[0]), strings[1], strings[2], strings[3], strings[4], strings[5], strings[6], strings[7], strings[8], strings[9], strings[10]));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		for(int bin : map.keySet()) {
			System.out.println(bin + " : " + map.get(bin).toString());
		}
//		
	}

	

	@Override
	public List<Course> getCourses() {
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public Course getCourse(long courseId) {
		Course course = null;
		for(Course c: list) {
			if(c.getId() == courseId) {
				course = c;
				break;
			}
		}
		return course;
	}

	@Override
	public Course addCourse(Course course) {
		list.add(course);
		return course;
	}

	@Override
	public Course deleteCourse(long courseId) {
		// TODO Auto-generated method stub
		int n = list.size();
		int i;
		for(i = 0; i<n; i++) {
			if(list.get(i).getId() == courseId)
				break;
		}
		Course course = null;
		if(i < n)
			course = list.remove(i);
		return course;
	}

	@Override
	public Course updateCourse(Course course) {
		for(Course c : list) {
			if(c.getId() == course.getId()) {
				c.setName(course.getName());
				c.setDescription(course.getDescription());
			}
		}
		return course;
	}

}
