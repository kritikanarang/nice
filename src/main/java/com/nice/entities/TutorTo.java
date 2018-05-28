package com.nice.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.nice.mongo.generic.MongoEntity;

@Document(collection = "Tutors")
public class TutorTo implements MongoEntity {

	@Id
	@Indexed
	private String tutorId;
	private String tutorName;
	private String subject;
	private String location;
	private String tutorImg;
	private String age;
	private String sex;
	private String qualifaction;
	private String experience;
	private String classes;
	
	public TutorTo() {
		super();
	}
	
	public TutorTo(String tutorId) {
		super();
		this.tutorId = tutorId;
	}

	public TutorTo(String tutorId, String tutorName, String subject, String location, String tutorImg, String age,
			String sex, String qualifaction, String experience, String classes) {
		super();
		this.tutorId = tutorId;
		this.tutorName = tutorName;
		this.subject = subject;
		this.location = location;
		this.tutorImg = tutorImg;
		this.age = age;
		this.sex = sex;
		this.qualifaction = qualifaction;
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

	public String getQualifaction() {
		return qualifaction;
	}

	public void setQualifaction(String qualifaction) {
		this.qualifaction = qualifaction;
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
	
}
