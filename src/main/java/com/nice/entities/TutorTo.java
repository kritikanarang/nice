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
	
	public TutorTo() {
		super();
	}
	
	public TutorTo(String tutorId) {
		super();
		this.tutorId = tutorId;
	}

	public TutorTo(String tutorId, String tutorName, String subject, String location, String tutorImg) {
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
	
}
