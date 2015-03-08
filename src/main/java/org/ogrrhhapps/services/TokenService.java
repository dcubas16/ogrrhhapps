package org.ogrrhhapps.services;

public interface TokenService {

	public String check(String token);
	
	public String generate();
	
	public void remove(String token);
}
