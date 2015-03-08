package org.ogrrhhapps.services;

import java.util.HashMap;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class TokenServiceImpl implements TokenService {

	private  HashMap<String,String> tokens = new HashMap<String, String>();
	
	@Override
	public String check(String token) {
		return tokens.get(token);
	}

	@Override
	public String generate() {
		String uid = UUID.randomUUID().toString();
		tokens.put(uid, uid);
		return uid;
	}

	@Override
	public void remove(String token) {
		tokens.remove(token);
	}

}
