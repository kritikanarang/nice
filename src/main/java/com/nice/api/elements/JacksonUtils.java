package com.nice.api.elements;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.nice.api.annotations.SummaryProperty;

public class JacksonUtils {
	
	private final static ObjectMapper jacksonObjectMapper = new ObjectMapper();

	public static <ModelImpl> ModelImpl publishSummaryObject(ModelImpl modelImpl, Class<ModelImpl> modelClass,
			Set<String> properties) throws Throwable {
		ModelImpl summaryObj = convertToSummaryObject(modelImpl, modelClass, properties);
		return summaryObj;
	}

	private static <ModelImpl> ModelImpl convertToSummaryObject(ModelImpl json, Class<ModelImpl> modelClass,
			Set<String> properties) throws Throwable {
		FilterProvider filters = new SimpleFilterProvider().addFilter("summaryfilter",
				SimpleBeanPropertyFilter.filterOutAllExcept(properties));
		jacksonObjectMapper.addMixIn(Object.class, PropertyFilterMixIn.class);
		ObjectWriter writer = jacksonObjectMapper.writer(filters);
		return jacksonObjectMapper.readValue(writer.writeValueAsString(json), modelClass);
	}
	public static <ModelImpl>Set<String> getSummaryProperties(Class<ModelImpl> modelClass){
		Field[] fields = modelClass.getDeclaredFields();
		Set<String> properties = new HashSet<String>();
		for(Field field : fields) {
			if (field.isAnnotationPresent(SummaryProperty.class)) {
				properties.add(field.getName());
			}
		}
		return properties;
	}
}
@JsonFilter("summaryfilter")
class PropertyFilterMixIn {
}
