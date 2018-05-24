package edu.mum.everest.user;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import edu.mum.everest.schedule.Booking;
import edu.mum.everest.shared.GenericDaoImpl;

@Repository
public class MountaineerDaoImpl extends GenericDaoImpl<Mountaineer> implements MountaineerDao {

	public MountaineerDaoImpl() {
		super.setDaoType(Mountaineer.class);
	}

	@Override
	public Mountaineer findMountaineerByUsername(String username) {
		String jpql = "Select m from Mountaineer m where m.email =:username";
		try {
			Mountaineer mountaineer = (Mountaineer) entityManager.createQuery(jpql).setParameter("username", username)
					.getSingleResult();
			return mountaineer;
		} catch (NoResultException nre) {

		}
		return null;
	}
}
