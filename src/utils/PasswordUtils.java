package utils;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordUtils {
	
	// hashea la contraseña
	public static String hashPassword(String plainTextPassword) {
		return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
	}
	
	// verifica la contraseña en el hash almacenado
	public static boolean checkPassword(String plainPassword, String hashedPassword) {
		return BCrypt.checkpw(plainPassword, hashedPassword);
	}

}
