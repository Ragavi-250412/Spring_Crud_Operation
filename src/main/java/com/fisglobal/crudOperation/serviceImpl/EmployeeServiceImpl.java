package com.fisglobal.crudOperation.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fisglobal.crudOperation.dto.EmployeeRes;
import com.fisglobal.crudOperation.dto.EmployeeResponse;
import com.fisglobal.crudOperation.exception.ResourceNotFoundException;
import com.fisglobal.crudOperation.model.Employee;
import com.fisglobal.crudOperation.repo.EmployeeRepository;
import com.fisglobal.crudOperation.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repo;
	
	@Autowired
	private EmployeeResponse response;
	@Autowired
	private EmployeeRes res;

	@SuppressWarnings("unchecked")
	@Override
	public EmployeeRes get(Integer id) {
		// TODO Auto-generated method stub
		
		try {
			res.setData( repo.findById(id).get());
			res.setCode("200");
			res.setMessage("Successful Operation");
			
		} catch(Exception e) {
			res.setData(null);
			res.setCode("01");
			res.setMessage("No Records Found");
			log.error("Error in Getall Method"+ e);
		}
		return res;
		
	}

	@Override
	public Employee save(Employee employee) {
		return repo.save(employee);
	}

	@Override
	public Map<String, Boolean> delete(Integer id) {
		// TODO Auto-generated method stub
		Map<String, Boolean> resp = new HashMap<>();
		try {
			Employee employee = repo.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));
		repo.delete(employee);
		
		resp.put("Deleted", true);
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			resp.put("Deleted", false);
		}
		return resp;

	}

	@Override
	public EmployeeResponse getAll() {
		// TODO Auto-generated method stub
//		EmployeeResponse response = new EmployeeResponse();
		try {
			List<Employee> employee = repo.findAll();
			response.setData(employee);
			response.setCode("200");
			response.setMessage("Successful Operation");
		} catch(Exception e) {
			response.setData(null);
			response.setCode("500");
			response.setMessage("Error in DB");
			log.error("Error in Getall Method"+ e);
		}
		return response;
	}

	public void update(Employee employee) {
//		return ;
	}
}
