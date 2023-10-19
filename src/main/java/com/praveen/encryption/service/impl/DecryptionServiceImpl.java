package com.praveen.encryption.service.impl;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.springframework.stereotype.Service;

import com.praveen.encryption.exception.EncryptionException;
import com.praveen.encryption.model.DecryptionRequest;
import com.praveen.encryption.model.DecryptionResponse;
import com.praveen.encryption.service.DecryptionService;
import com.praveen.encryption.utilities.EncryptionUtils;

/**
 * This class provides implementation for DecryptionService
 * 
 * @author Praveen J
 */
@Service
public class DecryptionServiceImpl implements DecryptionService {

	/**
	 * This method decrypts message
	 */
	@Override
	public DecryptionResponse decryptMessage(DecryptionRequest decryptionRequest) {
		// instantiating
		DecryptionResponse decryptionResponse = new DecryptionResponse();
		try {
			// decrypting message
			String decryptedMessage = EncryptionUtils.decryptMessage(decryptionRequest.getEncryptedMessage(),
					decryptionRequest.getKey());
			// setting decrypted message in response
			decryptionResponse.setDecryptedMessage(decryptedMessage);
		} catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException | IllegalBlockSizeException
				| BadPaddingException e) {
			// rethrowing exception
			throw new EncryptionException(e.getMessage(), 500);
		}
		// returning response
		return decryptionResponse;
	}

}
