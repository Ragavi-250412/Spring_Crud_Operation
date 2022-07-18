package com.fisglobal.crudOperation.dto;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fisglobal.crudOperation.model.Employee;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class EmployeeRes {
	
	@JsonProperty("data")
	private Employee data;
		
	@JsonProperty("code")
	private String code;
	
	@JsonProperty("message")
	private String message;

}
