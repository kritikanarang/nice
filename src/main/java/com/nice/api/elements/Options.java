package com.nice.api.elements;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Options {

	private List<OptionsLink> links = new ArrayList<OptionsLink>();

	public Options() {
		super();
	}

	@JsonCreator
	public Options(@JsonProperty("link") List<OptionsLink> links) {
		super();
		this.setLinks(links);
	}

	public List<OptionsLink> getLinks() {
		return links;
	}

	public void setLinks(List<OptionsLink> links) {
		this.links = links;
	}

}
