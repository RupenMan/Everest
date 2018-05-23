/**
 * 
 */
package edu.mum.everest.schedule;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.everest.user.Mountaineer;
import edu.mum.everest.user.MountaineerDao;

/**
 * @author jeewa
 *
 */
@Service
@Transactional
public class ScheduleServiceImpl implements ScheduleService{

	@Autowired
	private ScheduleDao scheduleDao;
	
	@Override
	public void saveSchedule(Schedule schedule) {
		scheduleDao.save(schedule);
	}
	
	@Override
	public void updateSchedule(Schedule schedule) {
		scheduleDao.update(schedule);
	}
	
	@Override
	public void deleteSchedule(Schedule schedule) {
		scheduleDao.delete(schedule.getId());
	}

	/* (non-Javadoc)
	 * @see edu.mum.everest.schedule.ScheduleService#getAllSchedules()
	 */
	@Override
	public List<Schedule> getAllSchedules() {
		// TODO Auto-generated method stub
		return scheduleDao.findAll();
	}

	/* (non-Javadoc)
	 * @see edu.mum.everest.schedule.ScheduleService#findOne(java.lang.Long)
	 */
	@Override
	public Schedule findOne(Long id) {
		// TODO Auto-generated method stub
		return scheduleDao.findOne(id);
	}

	/* (non-Javadoc)
	 * @see edu.mum.everest.schedule.ScheduleService#updateScheule(edu.mum.everest.schedule.Schedule)
	 */

	/* (non-Javadoc)
	 * @see edu.mum.everest.schedule.ScheduleService#updateScheule(edu.mum.everest.schedule.Schedule)
	 */
}
