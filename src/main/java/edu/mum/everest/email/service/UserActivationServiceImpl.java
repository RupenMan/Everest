package edu.mum.everest.email.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.everest.email.UserActivation;
import edu.mum.everest.email.dao.UserActivationDao;

/**
 * 
 * @author netra
 */
@Service
@Transactional
public class UserActivationServiceImpl implements UserActivationService {
	@Autowired
	private UserActivationDao userActivationDao;
	
	@Override
	public void save(UserActivation userActivation) {
		userActivationDao.save(userActivation);
	}

	@Override
	public UserActivation update(UserActivation userActivation) {
		return userActivationDao.update(userActivation);
	}

	@Override
	public UserActivation findByKey(String key) {
		return userActivationDao.findByKey(key);
	}
}