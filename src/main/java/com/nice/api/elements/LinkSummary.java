package com.nice.api.elements;

import org.springframework.hateoas.Link;

import com.nice.model.Model;

public class LinkSummary extends Link {

	private static final long serialVersionUID = 1L;
	Model summary;
	
	public LinkSummary(String href, String rel, Model summary){
		super(href, rel);
		this.summary = summary;
	}

	public Model getSummary() {
		return summary;
	}

	public void setSummary(Model summary) {
		this.summary = summary;
	}
	
}