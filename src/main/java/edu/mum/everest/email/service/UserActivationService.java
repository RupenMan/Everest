package edu.mum.everest.email.service;

import edu.mum.everest.email.UserActivation;

/**
 * 
 * @author netra
 */
public interface UserActivationService  {
	public void save(UserActivation userActivation);
	public UserActivation update(UserActivation userActivation);
	public UserActivation findByKey(String key);
}
