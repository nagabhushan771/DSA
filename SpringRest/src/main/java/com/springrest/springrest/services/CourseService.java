package com.springrest.springrest.services;

import java.util.List;

import com.springrest.springrest.entities.Course;

public interface CourseService {
	public abstract List<Course> getCourses();

	public abstract Course getCourse(long courseId);

	public abstract Course addCourse(Course course);

	public abstract Course deleteCourse(long courseId);

	public abstract Course updateCourse(Course course);

}
