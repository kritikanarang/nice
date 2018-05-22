package com.nice.controllers.impl;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.nice.api.elements.Collection;
import com.nice.controllers.AbstractController;
import com.nice.helper.generic.TutorHelper;
import com.nice.model.impl.Tutor;
import com.nice.service.processor.ServiceProcessor;


@RestController
@RequestMapping("/tutors")
public class TutorController implements AbstractController {

	@Autowired
	@Qualifier(value="tutorServiceProcessor")
	private ServiceProcessor<Tutor> tutorServiceProcessor;
	
	@Autowired
	private TutorHelper tutorHelper;
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	protected HttpEntity<?> postTutors(@Valid @RequestBody Tutor tutor, HttpServletResponse response){
		tutorServiceProcessor.postRequest(tutor);
		tutor.add(linkTo(methodOn(TutorController.class).postTutors(tutor, response)).slash(tutor.generateIdFromModel()).withSelfRel());
		response.setHeader(HttpHeaders.ALLOW, "POST, OPTIONS");
		response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, "POST, OPTIONS");
		return new ResponseEntity<>(tutor, HttpStatus.CREATED);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	protected HttpEntity<?> getTutors(@RequestParam(required=false) Integer page,@RequestParam(required=false) Integer size, @RequestParam(required=false) String modelName, @RequestParam(required=false) String price, HttpServletRequest request, HttpServletResponse response) throws Throwable{
		Collection collectionObj = new Collection();
		Tutor tutorObj = new Tutor();
		List<Tutor> tutorList = tutorServiceProcessor.getResponse(tutorObj, page, size);
		collectionObj.add(linkTo(methodOn(TutorController.class).getTutors(page, size, modelName, price, request, response)).withSelfRel().expand());
		tutorHelper.getCollectionResults(collectionObj, "gets a tutor resource", "product", request.getRequestURL().toString(), Tutor.class, tutorList);
		response.setHeader(HttpHeaders.ALLOW, "GET, OPTIONS");
		response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, "GET, OPTIONS");
		return new ResponseEntity<>(collectionObj, HttpStatus.OK);
	}
	
}
