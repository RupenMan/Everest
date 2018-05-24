package edu.mum.everest.authentication;

import edu.mum.everest.schedule.Booking;
import edu.mum.everest.shared.GenericDao;
import edu.mum.everest.user.User;
import edu.mum.everest.user.UserCredentials;

public interface PersonDao extends GenericDao<UserCredentials>{
	
	public UserCredentials authenticationLogin(UserCredentials userCredentials);
	
	public void register(UserCredentials userCredentials);
	
	public void updatePassword(UserCredentials userCredentials);
	
	public UserCredentials checkUsername(UserCredentials userCredentials);
	
}
