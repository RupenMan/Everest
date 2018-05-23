/**
 * 
 */
package edu.mum.everest.schedule;

import org.springframework.stereotype.Repository;
import edu.mum.everest.shared.GenericDaoImpl;

/**
 * @author jeewa
 *
 */
@Repository
public class ScheduleDaoImpl extends GenericDaoImpl<Schedule> implements ScheduleDao{

	public ScheduleDaoImpl() {
		super.setDaoType(Schedule.class);
	}
}
