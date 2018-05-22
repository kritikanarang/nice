package com.nice.api.elements;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class OptionsResponseEntity extends ResourceSupport {

	private String title;

	@JsonProperty("_options")
	private Options options;

	public OptionsResponseEntity() {
		super();
	}
	public OptionsResponseEntity(String title, @JsonProperty("_options") Options options) {
		super();
		this.title = title;
		this.options = options;
	}

	public Options getOptions() {
		return options;
	}

	public void setOptions(Options options) {
		this.options = options;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
