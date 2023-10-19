package com.praveen.encryption.service;

import com.praveen.encryption.model.EncryptionRequest;
import com.praveen.encryption.model.EncryptionResponse;

public interface EncryptionService {

	EncryptionResponse encryptMessage(EncryptionRequest encryptionRequest);

}
