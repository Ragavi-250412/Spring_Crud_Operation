package com.fisglobal.crudOperation.dto;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fisglobal.crudOperation.model.Employee;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
@JsonInclude(Include.NON_NULL)
public class EmployeeResponse {
	
	@JsonProperty("data")
	private List<Employee> data;
		
	@JsonProperty("code")
	private String code;
	
	@JsonProperty("message")
	private String message;

}
