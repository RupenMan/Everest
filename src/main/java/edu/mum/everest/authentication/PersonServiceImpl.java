package edu.mum.everest.authentication;

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
import edu.mum.everest.user.Mountaineer;
import edu.mum.everest.user.MountaineerDao;
import edu.mum.everest.user.MountaineerService;
import edu.mum.everest.user.User;
import edu.mum.everest.user.UserCredentials;

@Service
@Transactional
public class PersonServiceImpl implements PersonsService{

	@Autowired
	private PersonDao personDao;
	
	@Autowired
	private MountaineerDao mountaineerDao;
	
	@Autowired
	private EmailGateway emailGateway;
	
	@Autowired 
	private MountaineerService mountaineerService;
	
	@Autowired
	private UserActivationDao userActivationDao;
	
//	@Override
//	@Logging
//	public void saveMountaineer(Mountaineer climber) {
//		mountaineerDao.save(climber);
//	}
	
//	@Override
//	@Logging
//	public void updateMountaineer(Mountaineer climber) {
//		mountaineerDao.update(climber);
//	}

//	@Override
//	@Logging
//	public void bookTrip(Booking bookTrip) {
//		mountaineerDao.bookTrip(bookTrip);
//	}

//	@Override
//	@Logging
//	public void cancelTrip(Booking bookedTrip) {
//		mountaineerDao.delete(1L);
//		mountaineerDao.delete(bookedTrip.getId());
//	}

	@Override
	public UserCredentials authenticationLogin(UserCredentials userCredentials) {
		return personDao.authenticationLogin(userCredentials);
	}
	
	@Override
	public void register(UserCredentials userCredentials) {
		personDao.save(userCredentials);
//		User user = new User();
//		userCredentials.setUser(user);
//		userCredentials.getUser().setuserCredentials(userCredentials);
	}
	
	@Override
	public void updatePassword(UserCredentials userCredentials) {
		personDao.update(userCredentials);
	}
	
	@Override
	public UserCredentials checkUsername(UserCredentials userCredentials) {
		return personDao.checkUsername(userCredentials);
	}
	
	@Override
	public void sendEmail(UserCredentials userCredentials) {
		UserActivation userActivation = new UserActivation(userCredentials.getUsername());
		userActivationDao.save(userActivation);
		
		String html = "<a href='http://localhost:8080/Everest/userActivation?key="+userActivation.getKey()+"'>Click Here to Activate</a>";

		EmailMessage msg = EmailMessageBuilder
								.withSubject("Registration Activation")
								.withContent(html)
								.withRecipient(userCredentials.getUsername())
								.build();
		System.out.println(msg);
		emailGateway.sendEmail(MessageBuilder.withPayload(msg).build());
	}
}

