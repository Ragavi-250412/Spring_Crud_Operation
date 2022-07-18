/**
 * 
 */
package com.fisglobal.crudOperation.controller;

import java.util.Map;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fisglobal.crudOperation.dto.EmployeeRes;
import com.fisglobal.crudOperation.dto.EmployeeResponse;
import com.fisglobal.crudOperation.exception.ResourceNotFoundException;
import com.fisglobal.crudOperation.model.Employee;
import com.fisglobal.crudOperation.repo.EmployeeRepository;
import com.fisglobal.crudOperation.service.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;

/**
 * @author e5642758
 *
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
//@Slf4j
@RequestMapping("/FIS/CrudOperation/v1")
public class CrudOperationController {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private EmployeeRepository repo;


	@Operation(summary = "Get all the Employees")
	@GetMapping(value = "/employees", produces = { MediaType.APPLICATION_JSON_VALUE })
	public EmployeeResponse getAllEmployee() {
		return employeeService.getAll();
	}

	@Operation(summary = "Get Employee by Id")
	@GetMapping(value = "/employees/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<EmployeeRes> getById(@PathVariable Integer id) {
		try {
			EmployeeRes employee = employeeService.get(id);
			return new ResponseEntity<EmployeeRes>(employee, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<EmployeeRes>(HttpStatus.NOT_FOUND);
		}
	}

	@Operation(summary = "Save the Employees")
	@PostMapping(value = "/employees", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public Employee createEmployee(@Valid @RequestBody Employee employee) {
		return employeeService.save(employee);
	}

	@Operation(summary = "Delete the Employees")
	@DeleteMapping(value = "/employees/{id}")
	public Map<String, Boolean> delete(@PathVariable Integer id) {
		return employeeService.delete(id);
	}

	@Operation(summary = "Update the employees")
	@PutMapping(value = "/employees/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Employee> updateEmployee(@PathVariable Integer id,
			@RequestBody @Valid Employee employeeDetails) throws ResourceNotFoundException {
		Employee emp = repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));

		emp.setFirstName(employeeDetails.getFirstName());
		emp.setLastName(employeeDetails.getLastName());
		emp.setAge(employeeDetails.getAge());
		emp.setDesignation(employeeDetails.getDesignation());
		emp.setExperience(employeeDetails.getExperience());
		emp.setSalary(employeeDetails.getSalary());
		final Employee response = employeeService.save(emp);
		return ResponseEntity.ok().body(response);
	}
}
