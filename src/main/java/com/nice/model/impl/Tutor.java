package com.nice.model.impl;

import java.io.Serializable;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.nice.api.annotations.SummaryProperty;
import com.nice.model.Model;

@JsonInclude(Include.NON_NULL)
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
	
	private String age;

	private String sex;

	private String qualification;
	
	private String experience;
	
	private String classes;
	
	public Tutor() {
		super();
	}
	
	public Tutor(String tutorId, String tutorName, String subject, String location, String tutorImg, String age,
			String sex, String qualification, String experience, String classes) {
		super();
		this.tutorId = tutorId;
		this.tutorName = tutorName;
		this.subject = subject;
		this.location = location;
		this.tutorImg = tutorImg;
		this.age = age;
		this.sex = sex;
		this.qualification = qualification;
		this.experience = experience;
		this.classes = classes;
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

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getClasses() {
		return classes;
	}

	public void setClasses(String classes) {
		this.classes = classes;
	}

	@Override
	public String generateIdFromModel() {
		return this.tutorId;
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
