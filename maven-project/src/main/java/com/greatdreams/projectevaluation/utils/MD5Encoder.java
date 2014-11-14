package com.greatdreams.projectevaluation.utils;

import org.springframework.security.authentication.encoding.PasswordEncoder;

public class MD5Encoder implements PasswordEncoder{

	@Override
	public String encodePassword(String rawPass, Object salt) {
		return MD5.getMD5ofStr(rawPass);
	}

	@Override
	public boolean isPasswordValid(String encPass, String rawPass, Object salt) {
		return encPass.equals(encodePassword(rawPass, salt));
	}
	
}
