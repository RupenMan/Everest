package edu.mum.everest.email.dao;

import edu.mum.everest.email.UserActivation;
import edu.mum.everest.shared.GenericDao;

/**
 * 
 * @author netra
 */
public interface UserActivationDao extends GenericDao<UserActivation> {
	public UserActivation findByKey(String key);
}
