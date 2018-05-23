/**
 * 
 */
package edu.mum.everest.schedule;

import java.util.List;

/**
 * @author jeewa
 *
 */
public interface ScheduleService {

	/**
	 * @param schedule
	 */
	void saveSchedule(Schedule schedule);

	/**
	 * @param schedule
	 */
	void updateSchedule(Schedule schedule);

	/**
	 * @param schedule
	 */
	void deleteSchedule(Schedule schedule);

	/**
	 * @return
	 */
	List<Schedule> getAllSchedules();

	/**
	 * @param id
	 * @return
	 */
	Schedule findOne(Long id);

}
