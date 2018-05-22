package com.nice.service.processor.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.nice.data.repo.TutorRepository;
import com.nice.entities.TutorTo;
import com.nice.model.Model;
import com.nice.model.impl.Tutor;
import com.nice.service.processor.ServiceProcessor;

@Service
public class TutorServiceProcessor implements ServiceProcessor<Tutor>{

	@Autowired
	private TutorRepository tutorRepoObj;
	
	@Override
	public List<Tutor> getResponse(Tutor tutorObj, Integer page, Integer size) {
		if(page!=null && size!=null) {
			Page<TutorTo> tutorToList = tutorRepoObj.findAll(PageRequest.of(page, size));
			return fetchTutorList(tutorObj, tutorToList);
		}else {
			List<TutorTo> productToList = tutorRepoObj.findAll();
			return fetchTutorList(tutorObj, productToList);
		}
	}
	
	private List<Tutor> fetchTutorList(Tutor tutorObj, Iterable<TutorTo> tutorToList){
		List<Tutor> tutorList = new ArrayList<Tutor>();
		for(TutorTo tutorTo : tutorToList) {
			tutorObj = new Tutor(tutorTo.getTutorId(), tutorTo.getTutorName(), tutorTo.getLocation(), tutorTo.getSubject(), tutorTo.getTutorImg());
			tutorList.add(tutorObj);
		}
		return tutorList;
	}

	@Override
	public Model getResponseById(Tutor model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void postRequest(Tutor tutorObj) {
		TutorTo tutorTo = new TutorTo(tutorObj.getTutorId(), tutorObj.getTutorName(), tutorObj.getLocation(), tutorObj.getSubject(), tutorObj.getTutorImg());
		tutorRepoObj.save(tutorTo);
		
	}

	@Override
	public void processDelete(Tutor model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void processPatch(Tutor model) {
		// TODO Auto-generated method stub
		
	}

}
