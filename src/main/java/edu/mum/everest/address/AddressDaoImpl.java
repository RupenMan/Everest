package edu.mum.everest.address;

import org.springframework.stereotype.Repository;

import edu.mum.everest.shared.GenericDaoImpl;

@Repository
public class AddressDaoImpl extends GenericDaoImpl<Address> implements AddressDao{
	public AddressDaoImpl() {
		super.setDaoType(Address.class);
	}
}
