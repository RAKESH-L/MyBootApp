package com.mybootapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mybootapp.dto.CourseDto;
import com.mybootapp.model.Course;
import com.mybootapp.model.Department;
import com.mybootapp.repository.CourseRepository;
import com.mybootapp.repository.DepartmentRepository;

@RestController
public class CourseController {
	
	@Autowired
	private CourseRepository courseRepository ;
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@PostMapping("/course/insert")
	public Course postCourse(@RequestBody Course course) {
		
		Department department = departmentRepository.findByName(course.getDepartment().getName());
		
		if (department == null) {
			department = departmentRepository.save(course.getDepartment());
		}
		
		 
		course.setDepartment(department);
		
		return courseRepository.save(course);
	}
	
	@PostMapping("/course/post")
	public Course coursepost(@RequestBody CourseDto courseDto) {
		Course course = new Course();
		course.setName(courseDto.getName());
		course.setCredits(courseDto.getCredits());
		course.setFee(courseDto.getFee());
		
		Department department = new Department();
		department.setName(courseDto.getDepartmentName());
		
		Department departmentDB = departmentRepository.findByName(department.getName());
		if(departmentDB == null) {
			department = departmentRepository.save(department);
		}
		else {
			department = departmentDB;
		}
		
		course.setDepartment(department);
		
		return courseRepository.save(course);
		
	}
	
	@GetMapping("/course/department/{dname}")
	public List<Course> getCourseByDepartment(@PathVariable("dname") String dname) {
		List<Course> list = courseRepository.getCourseByDepartment(dname);
		return list;
	}
	
	@GetMapping("/department/course/{cname}")
	public Department getDepartmentByCourseName(@PathVariable("cname") String cname) {
		Department department = courseRepository.getDepartmentByCourseName(cname);
		return department;
	}
	
	@GetMapping("/Course/department/{did}")
	public List<Course> getCourseByDepartmentId(@PathVariable("did") Long did) {
		List<Course> list = courseRepository.getCourseByDepartmentId(did);
		return list;
	}
	
	
}
