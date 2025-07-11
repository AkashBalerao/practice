package EncryptionDecryption;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class AESEncryption {
	
	public static SecretKey getSecretKey() throws NoSuchAlgorithmException
	{
		KeyGenerator key = KeyGenerator.getInstance("AES");
		key.init(128);
		return key.generateKey();
	}
	
	public static String encrypt(String plainText, SecretKey key) throws Exception
	{
		Cipher c = Cipher.getInstance("AES");
		c.init(c.ENCRYPT_MODE, key);
		byte[] b = c.doFinal(plainText.getBytes());
		String s = Base64.getEncoder().encodeToString(b);
		return s;
	}
	
	public static String decrypt(String p, SecretKey key) throws Exception
	{
		Cipher c = Cipher.getInstance("AES");
		c.init(c.DECRYPT_MODE, key);
		byte[] s = Base64.getDecoder().decode(p);
		byte[] b = c.doFinal(s);
		return new String(b);
	}
	
	public static void main(String [] args) throws Exception
	{
		String plainText = "Hello World";
		SecretKey k = getSecretKey();
		
		String encryptedStr = encrypt(plainText, k);
		System.out.println("Plain Text: "+plainText);
		System.out.println("Encrypted String: "+encryptedStr);
		String decryptedStr = decrypt(encryptedStr, k);
		System.out.println("Decrypted String: "+decryptedStr);
	}
}
