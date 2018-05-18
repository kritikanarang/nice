package com.nice.name.tutor;

import java.io.Serializable;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.nice.name.Name;

public class Tutor extends ResourceSupport implements Serializable, Name, Validator {

	private static final long serialVersionUID = 1L;

	public Tutor() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String generateIdFromNamel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setUpNamelFromId() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
	}

}
