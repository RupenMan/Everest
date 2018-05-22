package edu.mum.everest.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.everest.schedule.Booking;

@Service
@Transactional
public class MountaineerServiceImpl implements MountaineerService{

	@Autowired
	private MountaineerDao mountaineerDao;
	
	@Override
	public void saveMountaineer(Mountaineer climber) {
		mountaineerDao.save(climber);
	}
	
	@Override
	public void updateMountaineer(Mountaineer climber) {
		mountaineerDao.update(climber);
	}

	@Override
	public void bookTrip(Booking bookTrip) {
		mountaineerDao.bookTrip(bookTrip);
	}

	@Override
	public void cancelTrip(Booking bookedTrip) {
//		mountaineerDao.delete(1L);
//		mountaineerDao.delete(bookedTrip.getId());
	}
}
