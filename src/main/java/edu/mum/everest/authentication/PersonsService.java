package edu.mum.everest.authentication;

import edu.mum.everest.schedule.Booking;
import edu.mum.everest.user.User;
import edu.mum.everest.user.UserCredentials;

public interface PersonsService {
	
	public UserCredentials authenticationLogin(UserCredentials userCredentials);
		
	public void register(UserCredentials userCredentials);
	
	public void updatePassword(UserCredentials userCredentials);
	
	public UserCredentials checkUsername(UserCredentials userCredentials);
	
	public void sendEmail(UserCredentials userCredentials);
	
}
