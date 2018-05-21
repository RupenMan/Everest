package edu.mum.everest.user;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public void updateUserInfo(Mountaineer climber) {
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
