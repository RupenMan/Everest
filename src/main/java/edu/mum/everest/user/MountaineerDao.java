package edu.mum.everest.user;

import edu.mum.everest.schedule.Booking;
import edu.mum.everest.shared.GenericDao;

public interface MountaineerDao extends GenericDao<Mountaineer>{
	
	@Override
	public void save(Mountaineer climber);
	
	@Override
	public Mountaineer update(Mountaineer climber);
	
	@Override
	public void delete(Long id);
	
	public Mountaineer findMountaineerByUsername(String email);
}
