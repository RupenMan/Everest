/**
 * 
 */
package edu.mum.everest.user;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author jeewa
 *
 */
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	public void saveEmployee(Employee employee) {
		employeeDao.save(employee);
	}
	
	@Override
	public void updateUserInfo(Employee employee) {
		employeeDao.update(employee);
	}
}
