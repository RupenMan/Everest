package edu.mum.everest.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.everest.aspect.Logging;
import edu.mum.everest.schedule.Booking;

@Service
@Transactional
public class MountaineerServiceImpl implements MountaineerService{

	@Autowired
	private MountaineerDao mountaineerDao;
	
	@Override
	@Logging
	public void saveMountaineer(Mountaineer climber) {
		mountaineerDao.save(climber);
	}
	
	@Override
	@Logging
	public void updateMountaineer(Mountaineer climber) {
		mountaineerDao.update(climber);
	}

	@Override
	@Logging
	public void cancelTrip(Booking bookedTrip) {
//		mountaineerDao.delete(1L);
//		mountaineerDao.delete(bookedTrip.getId());
	}
	
	
	@Override
	public Mountaineer findMountaineerByUsername(String username) {
		return mountaineerDao.findMountaineerByUsername(username);
	}

	@Override
	public Mountaineer findMountaineerById(Long id) {
		return mountaineerDao.findOne(id);
	}

	@Override
	public void removeMountaineer(Mountaineer climber) {
		mountaineerDao.delete(climber.getId());
		
	}
}
