package edu.mum.everest.email;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.util.Base64Utils;

/**
 * 
 * @author netra
 */
@Entity
public class UserActivation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String validateKey;

	public UserActivation() {

	}

	public UserActivation(String email) {
		this.validateKey = new String(Base64Utils.encode((email + new Date()).getBytes()));
	}

	public String getKey() {
		return this.validateKey;
	}
}