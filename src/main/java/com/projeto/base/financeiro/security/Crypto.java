package com.projeto.base.financeiro.security;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Crypto {
	public static String crypto(String pass) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(pass.getBytes(),0,pass.length());
		return new BigInteger(1,md.digest()).toString(16);
	}	
}
