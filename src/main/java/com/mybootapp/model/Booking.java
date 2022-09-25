package com.mybootapp.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToOne
	private Patient patient;

	@OneToOne
	private Doctor doctor;

	@OneToOne
	private Slots slot;

	private LocalDate bookingDate;

	public Booking(Long id, Patient patient, Doctor doctor, Slots slot, LocalDate bookingDate) {
		super();
		this.id = id;
		this.patient = patient;
		this.doctor = doctor;
		this.slot = slot;
		this.bookingDate = bookingDate;
	}

	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Slots getSlot() {
		return slot;
	}

	public void setSlot(Slots slot) {
		this.slot = slot;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	@Override
	public String toString() {
		return "Booking [id=" + id + ", patient=" + patient + ", doctor=" + doctor + ", slot=" + slot + ", bookingDate="
				+ bookingDate + "]";
	}

}
