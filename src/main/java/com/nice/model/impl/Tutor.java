package com.nice.model.impl;

import java.io.Serializable;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.nice.api.annotations.SummaryProperty;
import com.nice.model.Model;

public class Tutor extends ResourceSupport implements Serializable, Model, Validator {

	private static final long serialVersionUID = 1L;

	@SummaryProperty
	private String tutorId;
	@SummaryProperty
	private String tutorName;
	@SummaryProperty
	private String subject;
	@SummaryProperty
	private String location;
	@SummaryProperty
	private String tutorImg;

	public Tutor() {
		super();
	}

	public Tutor(String tutorId, String tutorName, String subject, String location, String tutorImg) {
		super();
		this.tutorId = tutorId;
		this.tutorName = tutorName;
		this.subject = subject;
		this.location = location;
		this.tutorImg = tutorImg;
	}
	
	public String getTutorId() {
		return tutorId;
	}

	public void setTutorId(String tutorId) {
		this.tutorId = tutorId;
	}

	public String getTutorName() {
		return tutorName;
	}

	public void setTutorName(String tutorName) {
		this.tutorName = tutorName;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getTutorImg() {
		return tutorImg;
	}

	public void setTutorImg(String tutorImg) {
		this.tutorImg = tutorImg;
	}

	@Override
	public String generateIdFromModel() {
		return null;
	}

	@Override
	public void setUpModelFromId() {
		
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		
	}

}
