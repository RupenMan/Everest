/**
 * 
 */
package edu.mum.everest.user;

import javax.persistence.NoResultException;

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

	/* (non-Javadoc)
	 * @see edu.mum.everest.user.EmployeeDao#findEmployeeByUsername(java.lang.String)
	 */
	@Override
	public Employee findEmployeeByUsername(String username) {
		// TODO Auto-generated method stub
		String jpql= "Select e from Employee e where e.email =:username"; 
		try {
		return (Employee) entityManager.createQuery(jpql)
				.setParameter("username", username)
				.getSingleResult();
		}catch(NoResultException nre) {
			
		}
		return null;
	}
}
