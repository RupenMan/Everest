/**
 * 
 */
package edu.mum.everest.user;

import org.springframework.stereotype.Repository;
import edu.mum.everest.shared.GenericDaoImpl;

/**
 * @author jeewa
 *
 */
@Repository
public class EmployeeDaoImpl extends GenericDaoImpl<Employee> implements EmployeeDao {
	
	public EmployeeDaoImpl() {
		super.setDaoType(Employee.class);
	}
}
