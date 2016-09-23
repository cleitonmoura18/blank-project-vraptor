package br.com.blank.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class AcessoUtil {
	public static final long ADMINISTRADOR = 1L;
	public static final long GERENTE = 2L;
	public static final long USUARIO = 3L;
	public static final String DESC_ADMINISTRADOR = "ADMINISTRADOR";
	public static final String DESC_GERENTE = "GERENTE";
	public static final String DESC_USUARIO = "USUARIO";
	private static final String SENHA_PADRAO = "123456";
	
	public static long getKey(String role){
		if(role.equals(DESC_ADMINISTRADOR))
			return ADMINISTRADOR;
		if(role.equals(DESC_GERENTE))
			return GERENTE;
		if(role.equals(DESC_USUARIO))
			return USUARIO;
		return 0;
	}
	
	public static String getSENHA_PADRAO() {
		return SENHA_PADRAO;
	}
	
	public static boolean isSenhaPadrao(String senha) {
		return SENHA_PADRAO.equals(senha);
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
}
