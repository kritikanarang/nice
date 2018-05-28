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
			List<TutorTo> tutorToList = tutorRepoObj.findAll();
			return fetchTutorList(tutorObj, tutorToList);
		}
	}
	
	private List<Tutor> fetchTutorList(Tutor tutorObj, Iterable<TutorTo> tutorToList){
		List<Tutor> tutorList = new ArrayList<Tutor>();
		for(TutorTo tutorTo : tutorToList) {
			tutorObj = new Tutor(tutorTo.getTutorId(), tutorTo.getTutorName(), tutorTo.getLocation(), tutorTo.getSubject(), tutorTo.getTutorImg(), tutorTo.getAge(), tutorTo.getSex(), tutorTo.getQualifaction(), tutorTo.getExperience(), tutorTo.getClasses());
			tutorList.add(tutorObj);
		}
		return tutorList;
	}

	@Override
	public Model getResponseById(Tutor tutorObj) {
		TutorTo tutorTo = tutorRepoObj.findUnique(tutorObj.getTutorId());
		tutorObj.setTutorId(tutorTo.getTutorId());
		tutorObj.setTutorName(tutorTo.getTutorName());
		tutorObj.setSubject(tutorTo.getSubject());
		tutorObj.setLocation(tutorTo.getLocation());
		tutorObj.setLocation(tutorTo.getTutorImg());
		return tutorObj;
	}

	@Override
	public void postRequest(Tutor tutorObj) {
		TutorTo tutorTo = new TutorTo(tutorObj.getTutorId(), tutorObj.getTutorName(), tutorObj.getLocation(), tutorObj.getSubject(), tutorObj.getTutorImg(), tutorObj.getAge(), tutorObj.getSex(), tutorObj.getQualifaction(), tutorObj.getExperience(), tutorObj.getClasses());
		tutorRepoObj.save(tutorTo);
		
	}

	@Override
	public void processDelete(Tutor tutorObj) {
		TutorTo tutorTo = new TutorTo(tutorObj.getTutorId());
		tutorRepoObj.delete(tutorTo);
		
	}

	@Override
	public void processPatch(Tutor model) {
		// TODO Auto-generated method stub
		
	}

}
