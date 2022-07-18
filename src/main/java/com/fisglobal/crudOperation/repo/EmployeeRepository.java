/**
 * 
 */
package com.fisglobal.crudOperation.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fisglobal.crudOperation.model.Employee;

/**
 * @author e5642758
 *
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	

}
