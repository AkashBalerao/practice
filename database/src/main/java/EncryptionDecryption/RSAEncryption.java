package EncryptionDecryption;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;

public class RSAEncryption {
	
	public static KeyPair getSecretKey() throws NoSuchAlgorithmException
	{
		KeyPairGenerator key = KeyPairGenerator.getInstance("RSA");
		key.initialize(1024);
		return key.generateKeyPair();
	}
	
	public static String encrypt(String plainText, KeyPair key) throws Exception
	{
		Cipher c = Cipher.getInstance("RSA");
		c.init(c.ENCRYPT_MODE, key.getPublic());
		byte[] b = c.doFinal(plainText.getBytes());
		String s = Base64.getEncoder().encodeToString(b);
		return s;
	}
	
	public static String decrypt(String p, KeyPair key) throws Exception
	{
		Cipher c = Cipher.getInstance("RSA");
		c.init(c.DECRYPT_MODE, key.getPrivate());
		byte[] s = Base64.getDecoder().decode(p);
		byte[] b = c.doFinal(s);
		return new String(b);
	}
	
	public static void main(String [] args) throws Exception
	{
		String plainText = "Hello World";
		KeyPair k = getSecretKey();
		
		String encryptedStr = encrypt(plainText, k);
		System.out.println("Plain Text: "+plainText);
		System.out.println("Encrypted String: "+encryptedStr);
		String decryptedStr = decrypt(encryptedStr, k);
		System.out.println("Decrypted String: "+decryptedStr);
	}
}
