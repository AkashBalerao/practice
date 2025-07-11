package EncryptionDecryption;

import java.security.MessageDigest;
import java.util.Base64;

public class SHAEncryption {
	public static void main(String [] args) throws Exception
	{
		String pass = "MyPassword@123";
		
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		byte[] b = md.digest(pass.getBytes());
		String hash = Base64.getEncoder().encodeToString(b);
		
		System.out.println("pass: "+pass);
		System.out.println("hash: "+hash);
	}
}
