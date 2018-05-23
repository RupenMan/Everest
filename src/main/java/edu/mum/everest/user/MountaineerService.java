package edu.mum.everest.user;

import edu.mum.everest.schedule.Booking;

public interface MountaineerService {
	
	public void saveMountaineer(Mountaineer climber);
		
	public void updateMountaineer(Mountaineer climber);
	
	public void cancelTrip(Booking booking);
	
	public Mountaineer findMountaineerById(Long id);
	
	public Mountaineer findMountaineerByUsername(String username);
	
	public void removeMountaineer(Mountaineer climber);
	
}
