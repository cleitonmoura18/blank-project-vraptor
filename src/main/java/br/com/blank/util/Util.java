package br.com.blank.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Util {
	private static String SENHA_PADRAO = "123456";
	private static String ADMINISTRADOR = "ADMINISTRADOR";
	private static String GERENTE = "GERENTE";
	private static String USUARIO = "USUARIO";
	
	public static String getSENHA_PADRAO() {
		return SENHA_PADRAO;
	}
	
	public static boolean isSenhaPadrao(String senha) {
		return SENHA_PADRAO.equals(senha);
	}
	
	public static String getADMINISTRADOR() {
		return ADMINISTRADOR;
	}

	public static String getGERENTE() {
		return GERENTE;
	}

	public static String getUSUARIO() {
		return USUARIO;
	}

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
	
	public static String exceptionRootCauseMessage(Exception e) {
		e.printStackTrace();
		Throwable t = e.getCause();
		String errorMessage = "";

		if (t != null) {
			while (t.getCause() != null) {
				t = t.getCause();
			}
			errorMessage = t.getLocalizedMessage();
		} else {
			errorMessage = e.getLocalizedMessage();
		}

		return errorMessage;
	}

	public static boolean isNuloOuVazio(String str) {
		if(str == null || str.equals(""))
			return true;
		return false;
	}

}
