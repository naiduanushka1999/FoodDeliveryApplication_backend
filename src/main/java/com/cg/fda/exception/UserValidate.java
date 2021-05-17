package com.cg.fda.exception;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * This method for Validating userId,Password
 * @author Aswitha
 */
public class UserValidate {

//This method for checking userId on regex
	public boolean validateUser(String userId) {
		String regex = "^[A-Za-z]\\w{5,29}$";
		Pattern p = Pattern.compile(regex);
		if (userId == null) {
			return false;
		}
		Matcher m = p.matcher(userId);
		return m.matches();

	}

//This method for checking Password on regex
	public boolean validatePassword(String password, String userId) {
		String regex = "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])" + "(?=\\S+).{8,20}$";
		Pattern p = Pattern.compile(regex);

		if (password == null || password.substring(0, 6).equals(userId.substring(0, 6))) {
			return false;
		}
		System.out.println(password.substring(0, 6));
		Matcher m = p.matcher(password);
		return m.matches();
	}

	public boolean validatePassword(String password) {
		String regex = "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])" + "(?=\\S+).{8,20}$";
		Pattern p = Pattern.compile(regex);
		if (password == null) {
			return false;
		}
		Matcher m = p.matcher(password);
		return m.matches();
	}

}
