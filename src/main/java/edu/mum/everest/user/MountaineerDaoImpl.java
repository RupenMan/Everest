package edu.mum.everest.user;

import org.springframework.stereotype.Repository;

import edu.mum.everest.schedule.Booking;
import edu.mum.everest.shared.GenericDaoImpl;

@Repository
public class MountaineerDaoImpl extends GenericDaoImpl<Mountaineer> implements MountaineerDao{
	
		
	public MountaineerDaoImpl() {
		super.setDaoType(Mountaineer.class);
	}

	@Override
	public void bookTrip(Booking bookTrip) {
		
	}

	
}
