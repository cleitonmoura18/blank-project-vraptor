package br.com.blank.util;

public class Util {
	
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
