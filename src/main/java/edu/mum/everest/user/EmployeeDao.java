/**
 * 
 */
package edu.mum.everest.user;

import edu.mum.everest.shared.GenericDao;

/**
 * @author jeewa
 *
 */
public interface EmployeeDao extends GenericDao<Employee>{

	/**
	 * @param username
	 * @return
	 */
	Employee findEmployeeByUsername(String username);

}
