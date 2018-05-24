package edu.mum.everest.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.everest.aspect.Logging;
import edu.mum.everest.email.EmailGateway;
import edu.mum.everest.email.EmailMessage;
import edu.mum.everest.email.EmailMessageBuilder;
import edu.mum.everest.email.UserActivation;
import edu.mum.everest.email.dao.UserActivationDao;
import edu.mum.everest.schedule.Booking;

@Service
@Transactional
public class MountaineerServiceImpl implements MountaineerService{

	@Autowired
	private MountaineerDao mountaineerDao;
	
	@Autowired
	private EmailGateway emailGateway;
	
	@Autowired
	private UserActivationDao userActivationDao;
	
	@Override
	public void saveMountaineer(Mountaineer climber) {
		mountaineerDao.save(climber);
		
		UserActivation userActivation = new UserActivation(climber.getEmail());
		userActivationDao.save(userActivation);
		
		String html = "<a href='http://localhost:8080/Everest/userActivation?key="+userActivation.getKey()+"'>Click Here to Activate</a>";

		EmailMessage msg = EmailMessageBuilder
								.withSubject("Registration Activation")
								.withContent(html)
								.withRecipient(climber.getEmail())
								.build();
		System.out.println(msg);
		emailGateway.sendEmail(MessageBuilder.withPayload(msg).build());
	}
	
	@Override
	@Logging
	public void updateMountaineer(Mountaineer climber) {
		mountaineerDao.update(climber);
	}

	@Override
	@Logging
	public void cancelTrip(Booking bookedTrip) {
//		mountaineerDao.delete(1L);
//		mountaineerDao.delete(bookedTrip.getId());
	}
	
	
	@Override
	public Mountaineer findMountaineerByUsername(String username) {
		return mountaineerDao.findMountaineerByUsername(username);
	}

	@Override
	public Mountaineer findMountaineerById(Long id) {
		return mountaineerDao.findOne(id);
	}

	@Override
	public void removeMountaineer(Mountaineer climber) {
		mountaineerDao.delete(climber.getId());
		
	}
}
