package com.praveen.encryption.service.impl;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.springframework.stereotype.Service;

import com.praveen.encryption.exception.EncryptionException;
import com.praveen.encryption.model.EncryptionRequest;
import com.praveen.encryption.model.EncryptionResponse;
import com.praveen.encryption.service.EncryptionService;
import com.praveen.encryption.utilities.EncryptionUtils;
import com.praveen.encryption.utilities.RandomStringGenerator;

/**
 * This class provides implementation for EncryptionService
 * 
 * @author Praveen J
 */
@Service
public class EncryptionServiceImpl implements EncryptionService {

	/**
	 * This method encrypts the message
	 */
	@Override
	public EncryptionResponse encryptMessage(EncryptionRequest encryptionRequest) {
		// instantiating
		EncryptionResponse encryptionResponse = new EncryptionResponse();
		String encryptedMessage;

		// generating random string of length 16
		String key = RandomStringGenerator.generateRandomString(16);

		try {
			// encrypting message with key
			encryptedMessage = EncryptionUtils.encryptMessage(encryptionRequest.getMessage(), key);

			// setting encrypted message and key
			encryptionResponse.setEncryptedMessage(encryptedMessage);
			encryptionResponse.setKey(key);
		} catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException | IllegalBlockSizeException
				| BadPaddingException e) {
			// rethrowing exception
			throw new EncryptionException(e.getMessage(), 500);
		}
		// returning response
		return encryptionResponse;
	}

}
