package br.com.blank.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Util {
	public static String setMD5Password(String password) {
		String senhaCriptografada = "";
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			
		}

		BigInteger hash = new BigInteger(1, md.digest(password.getBytes()));
		senhaCriptografada = hash.toString(16);
		return senhaCriptografada;
	}
}
