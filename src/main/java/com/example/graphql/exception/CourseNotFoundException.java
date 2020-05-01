package com.example.graphql.exception;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

@SuppressWarnings("serial")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CourseNotFoundException extends RuntimeException implements GraphQLError {
	
	private Map<String, Object> extensions = new HashMap<>();

    public CourseNotFoundException(String message, String invalidCourseField) {
        super(message);
        extensions.put("invalidCourse", invalidCourseField);
    }

    @Override
    public Map<String, Object> getExtensions() {
        Map<String, Object> customAttributes = new LinkedHashMap<>();

        customAttributes.put("errorCode", "400");
        customAttributes.put("errorMessage", this.getMessage());

        return customAttributes;
    }
    
	@Override
	public List<SourceLocation> getLocations() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ErrorType getErrorType() {
		// TODO Auto-generated method stub
		return null;
	}


}
