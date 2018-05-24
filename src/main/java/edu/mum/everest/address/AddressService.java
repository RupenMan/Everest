package edu.mum.everest.address;

public interface AddressService {
	
	public void saveAddress(Address address);
	
	public Address updateAddress(Address address);
	
	public Address findAddressById(Long id);
}
