package com.catalogmanagementsystem.exceptions;

import lombok.Data;

@Data
public class ResourceNotFoundException extends RuntimeException{
	String resourceName;
	String FieldName;
	Integer fieldValue;
	Long fieldValuel;
	
	public ResourceNotFoundException(String resourceName, String fieldName, Integer rid) {
		super(String.format("%s not found with %s : %d",resourceName,fieldName,rid));
		this.resourceName = resourceName;
		FieldName = fieldName;
		this.fieldValue = rid;
	}
	public ResourceNotFoundException(String resourceName, String fieldName, Long sid) {
		super(String.format("%s not found with %s : %s",resourceName,fieldName,sid));
		this.resourceName = resourceName;
		FieldName = fieldName;
		this.fieldValuel = sid;
	}
	public ResourceNotFoundException(String resourceName, String fieldName, Long sid ,Integer rid) {
		super(String.format("%s not found with %s : %s/%d",resourceName,fieldName,sid ,rid));
		this.resourceName = resourceName;
		FieldName = fieldName;
		this.fieldValuel = sid;
		this.fieldValue=rid;
	}

}

