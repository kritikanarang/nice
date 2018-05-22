package com.nice.helper.generic;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMethod;

import com.nice.api.elements.Options;
import com.nice.api.elements.OptionsResponseEntity;
import com.nice.api.elements.StringConstants;
import com.nice.controllers.impl.TutorController;
import com.nice.helper.ResourceHelper;
import com.nice.model.impl.Tutor;

public class TutorHelper extends ResourceHelper<Tutor, HttpServletRequest, String> {

	public static final String TUTOR_TITLE = "Options for Tutor Id";
	public static final String TUTOR_RESOURCE_GET_TITLE = "Searches the tutors";
	public static final String TUTOR_RESOURCE_POST_TITLE = "Creates a new tutor";
	public static final String TUTOR_RESOURCE_GET_ID_TITLE = "Fetches the tutor from the Id";
	public static final String TUTOR_RESOURCE_DELETE_TITLE = "Deletes the tutor based on the Id";
	
	@Override
	public OptionsResponseEntity getResourceResponse(HttpServletRequest request, Class<Tutor> modelClass) {
		
		OptionsResponseEntity optionsResponseEntity = new OptionsResponseEntity();
		Options _options = new Options();

		optionsResponseEntity.setTitle(TUTOR_TITLE);
		_options.getLinks().add(addCollectionOptionsLink(request.getRequestURL().toString(), RequestMethod.GET.name(), TUTOR_RESOURCE_GET_TITLE, StringConstants.GET_REL, Tutor.class));
		_options.getLinks().add(addCollectionOptionsLink(request.getRequestURL().toString(), RequestMethod.POST.name(), TUTOR_RESOURCE_POST_TITLE, StringConstants.POST_REL, Tutor.class));
		optionsResponseEntity.setOptions(_options);
		//optionsResponseEntity.add(linkTo(methodOn(TutorController.class).optionsOnTutors(request, null)).withSelfRel().expand());
		return optionsResponseEntity;
	}

	@Override
	public OptionsResponseEntity getResourceResponseId(String id, HttpServletRequest request, Class<Tutor> modelClass) {
	
		OptionsResponseEntity optionsResponseEntity = new OptionsResponseEntity();
		Options _options = new Options();

		optionsResponseEntity.setTitle(TUTOR_TITLE);
		_options.getLinks().add(addCollectionOptionsLink(request.getRequestURL().toString(), RequestMethod.GET.name(), TUTOR_RESOURCE_GET_ID_TITLE, StringConstants.GET_ID_REL, Tutor.class));
		_options.getLinks().add(addCollectionOptionsLink(request.getRequestURL().toString(), RequestMethod.DELETE.name(), TUTOR_RESOURCE_DELETE_TITLE, StringConstants.DELETE_REL, Tutor.class));
		optionsResponseEntity.setOptions(_options);
		//optionsResponseEntity.add(linkTo(methodOn(TutorController.class).optionsOnTutorsId(id, request, null)).withSelfRel().expand(id, request, modelClass));
		return optionsResponseEntity;
	}

}
