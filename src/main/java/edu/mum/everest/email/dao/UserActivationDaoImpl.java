package edu.mum.everest.email.dao;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import edu.mum.everest.email.UserActivation;
import edu.mum.everest.shared.GenericDaoImpl;

/**
 * 
 * @author netra
 */
@Repository
public class UserActivationDaoImpl extends GenericDaoImpl<UserActivation> implements UserActivationDao {
	
	@Override
	public UserActivation findByKey(String key) {
		Query query = entityManager.createQuery("SELECT u FROM UserActivation u WHERE u.validateKey = :key");
		query.setParameter("key", key);
		
		return (UserActivation) query.getSingleResult();
	}
}