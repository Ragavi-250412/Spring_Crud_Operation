package com.fisglobal.crudOperation.service;

import java.util.Map;

import com.fisglobal.crudOperation.dto.EmployeeRes;
import com.fisglobal.crudOperation.dto.EmployeeResponse;
import com.fisglobal.crudOperation.model.Employee;


public interface EmployeeService {

	public EmployeeRes get(Integer id);
	public Employee save(Employee employee);
	public Map<String, Boolean> delete(Integer id);
	public EmployeeResponse getAll();
	public void update(Employee employee);
	
}
