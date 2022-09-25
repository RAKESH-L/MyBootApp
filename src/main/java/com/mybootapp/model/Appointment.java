package com.mybootapp.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	private String contact;
	private Integer doctorId;
	private Integer slotId;
	private LocalDate apptDate;
	
	
	public Appointment(Long id, String name, String contact, Integer doctorId, Integer slotId, LocalDate apptDate) {
		super();
		this.id = id;
		this.name = name;
		this.contact = contact;
		this.doctorId = doctorId;
		this.slotId = slotId;
		this.apptDate = apptDate;
	}
	
	
	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public Integer getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}
	public Integer getSlotId() {
		return slotId;
	}
	public void setSlotId(Integer slotId) {
		this.slotId = slotId;
	}
	public LocalDate getApptDate() {
		return apptDate;
	}
	public void setApptDate(LocalDate apptDate) {
		this.apptDate = apptDate;
	}


	@Override
	public String toString() {
		return "Appointment [id=" + id + ", name=" + name + ", contact=" + contact + ", doctorId=" + doctorId
				+ ", slotId=" + slotId + ", apptDate=" + apptDate + "]";
	}
	
	
}
