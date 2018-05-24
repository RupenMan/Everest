package edu.mum.everest.authentication;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import edu.mum.everest.schedule.Booking;
import edu.mum.everest.shared.GenericDaoImpl;
import edu.mum.everest.user.Mountaineer;
import edu.mum.everest.user.MountaineerDaoImpl;
import edu.mum.everest.user.User;
import edu.mum.everest.user.UserCredentials;

@Repository
public class PersonDaoImpl extends GenericDaoImpl<UserCredentials> implements PersonDao {

	public PersonDaoImpl() {
		super.setDaoType(UserCredentials.class);
	}

	@Override
	public UserCredentials authenticationLogin(UserCredentials userCredentials) {
		String jpql = "Select m from UserCredentials m where m.username =:username and m.password =:password";
		try {
			UserCredentials user = (UserCredentials) entityManager.createQuery(jpql).setParameter("username", userCredentials.getUsername()).setParameter("password", userCredentials.getPassword()).getSingleResult();
			return user;
		} catch (NoResultException ex) {

		}
		
		return null;
	}
	
	@Override
	public void register(UserCredentials userCredentials) {
		super.save(userCredentials);
	}
	
	@Override
	public void updatePassword(UserCredentials userCredentials) {
		super.update(userCredentials);
	}
	
	@Override
	public UserCredentials checkUsername(UserCredentials userCredentials) {
		String jpql = "Select m from UserCredentials m where m.username =:username";
		try {
			UserCredentials user = (UserCredentials) entityManager.createQuery(jpql).setParameter("username", userCredentials.getUsername()).getSingleResult();
			return user;
		} catch (NoResultException ex) {

		}
		
		return null;
	}
}
