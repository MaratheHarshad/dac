package utils;

import exceptions.AuthenticationException;
import exceptions.UnauthorizedUserException;

public class UserValidation {
	
	
	public static void authorizedAdmin(boolean isAdmin, boolean isUser) throws UnauthorizedUserException {
		
		if (isUser) {
			throw new UnauthorizedUserException("trying to access invalid resourse");
		}
		
		if (!isAdmin) {
			throw new UnauthorizedUserException("invalid authentication");
		}
	}

	public static boolean authenticateAdmin(String username, String password) {

		if (username.equals("admin") && password.equals("admin")) {

			return true;
		} else {

			return false;
		}
	}

	public static boolean authenticateUser(String username, String password) throws AuthenticationException {

		if (username.equals("c1") && password.equals("c1")) {
			return true;
		}

		throw new AuthenticationException("invalid username or password");

	}
}