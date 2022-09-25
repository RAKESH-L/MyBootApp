package com.mybootapp.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mybootapp.dto.StudentDto;
import com.mybootapp.model.Address;
import com.mybootapp.model.Student;
import com.mybootapp.repository.AddressRepository;
import com.mybootapp.repository.StudentRepository;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
public class StudentController {

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private AddressRepository  addressRepository;
	
	@PostMapping("/student/insert")
	public Student insertStudent(@RequestBody Student student) {
		System.out.println(student.getName());
		System.out.println(student.getEmail());
		System.out.println(student.getAddress());
		
		Address address = addressRepository.save(student.getAddress());
		
		student.setAddress(address);
		
		System.out.println(student);
		
		return studentRepository.save(student);
		
	}
	
	@PostMapping("/student/post")
	public Student postStudent(@RequestBody StudentDto studentDto) {
		System.out.println(studentDto);
		
		Student student = new Student();
		student.setName(studentDto.getName());
		student.setEmail(studentDto.getEmail());
		
		Address address =new Address();
		
		address.setHouseno(studentDto.getHouseno());
		address.setPincode(studentDto.getPincode());
		address.setCity(studentDto.getCity());
		
		Address addressDB = addressRepository.save(address);
		
		student.setAddress(addressDB);
		
		return studentRepository.save(student);
		
	}
	
	@GetMapping("/student/all")
	public List<Student> getAllStudent(  
			           @RequestParam(name= "page", required = false, defaultValue ="0") Integer page,
						@RequestParam(name = "size", required = false, defaultValue = "10") Integer size) {
		Pageable pageable  = PageRequest.of(page, size);
		Page<Student> pageData = studentRepository.findAll(pageable);
		return pageData.getContent();
		
		
	}
}
