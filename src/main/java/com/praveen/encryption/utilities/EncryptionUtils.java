package com.praveen.encryption.utilities;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/**
 * This is a utility class which contains methods which helps to encrypt and
 * decrypt messages.
 * 
 * @author Praveen J
 */
public final class EncryptionUtils {

	private EncryptionUtils() {

	}

	/**
	 * This method decrypts an encrypted message with the help of key
	 * 
	 * @param encryptedMessage
	 * @param key
	 * @return decrypted message
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws InvalidKeyException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 */
	public static String decryptMessage(String encryptedMessage, String key) throws NoSuchAlgorithmException,
			NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		// getting an instance of cipher class with given Algorithm/Mode/Scheme
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");

		// creating key spec from provided key and AES algorithm
		SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");

		// initializing cipher with key and setting it in Decrypt mode
		cipher.init(Cipher.DECRYPT_MODE, secretKey);

		// decrypting data
		byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedMessage));

		// returning string format of decrypted data
		return new String(decryptedBytes);
	}

	/**
	 * This method encrypts a message with the help of key
	 * 
	 * @param message
	 * @param key
	 * @return encrypted message
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws InvalidKeyException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 */
	public static String encryptMessage(String message, String key) throws NoSuchAlgorithmException,
			NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		// getting an instance of cipher class with given Algorithm/Mode/Scheme
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");

		// creating key spec from provided key and AES algorithm
		SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");

		// initializing cipher with key and setting it in Encrypt mode
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);

		// encrypting data
		byte[] encryptedBytes = cipher.doFinal(message.getBytes());

		// returning encrypted data in encoded format
		return Base64.getEncoder().encodeToString(encryptedBytes);
	}

}
