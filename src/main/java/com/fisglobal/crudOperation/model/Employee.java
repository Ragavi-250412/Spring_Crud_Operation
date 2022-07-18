/**
 * 
 */
package com.fisglobal.crudOperation.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * @author e5642758
 *
 */
@Getter
@Setter
@Table(name="Employee")
@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("id")
	@NotNull(message = "4002")
	@Schema(required = true, description = "Employee Id", name="id")
	private Integer id;
	
	@JsonProperty("firstName")
	@NotNull(message = "4002")
	@Schema(required = true, description = "Employee First Name", name="firstName")
	private String firstName;


	@JsonProperty("lastName")
	@NotNull(message = "4002")
	@Schema(required = true, description = "Employee Last Name", name="lastName")
	private String lastName;
	
	@JsonProperty("age")
	@NotNull(message = "4002")
	@Schema(required = true, description = "Employee Age", name="age")
	private Float age;
	

	@JsonProperty("designation")
	@NotNull(message = "4002")
	@Schema(required = true, description = "Designation", name="designation")
	private String designation;
	

	@JsonProperty("experience")
	@NotNull(message = "4002")
	@Schema(required = true, description = "Employee Experience", name="experience")
	private String experience;


	@JsonProperty("salary")
	@NotNull(message = "4002")
	@Schema(required = true, description = "Employee salary", name="salary")
	private String salary;

	
}

