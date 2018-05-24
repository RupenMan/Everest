package edu.mum.everest.address;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.everest.user.Mountaineer;
import edu.mum.everest.user.MountaineerService;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressDao addressDao;
	
	@Autowired
	private MountaineerService mountaineerService;

	@Override
	public void saveAddress(Address address) {
		Mountaineer activeMountaineer = mountaineerService.findMountaineerByUsername("rupenman@gmail.com");
		activeMountaineer.addAddress(address);
		activeMountaineer.getAddressList().stream().forEach(System.out::println);
		mountaineerService.updateMountaineer(activeMountaineer);
	}

	@Override
	public Address updateAddress(Address address) {
		return addressDao.update(address);
	}

	@Override
	public Address findAddressById(Long id) {
		try {
			return addressDao.findOne(id);
		} catch (NoResultException nre) {

		}
		return null;
	}

}
