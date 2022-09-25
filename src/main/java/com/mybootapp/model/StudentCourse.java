package com.mybootapp.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student_course")
public class StudentCourse {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; // you need to create id even if you don't want id beacuse when you create a table 
						 // using spring boot you need a Primary key
	
	@OneToOne
	private Student student;
	
	@OneToOne
	private Course course;
	 
	private LocalDate enroll_date;

	public StudentCourse(Long id, Student student, Course course, LocalDate enroll_date) {
		super();
		this.id = id;
		this.student = student;
		this.course = course;
		this.enroll_date = enroll_date;
	}

	public StudentCourse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public LocalDate getEnroll_date() {
		return enroll_date;
	}

	public void setEnroll_date(LocalDate enroll_date) {
		this.enroll_date = enroll_date;
	}

	@Override
	public String toString() {
		return "StudentCourse [id=" + id + ", student=" + student + ", course=" + course + ", enroll_date="
				+ enroll_date + "]";
	}
	 
	
}
