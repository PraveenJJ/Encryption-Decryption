package com.praveen.encryption.service;

import com.praveen.encryption.model.DecryptionRequest;
import com.praveen.encryption.model.DecryptionResponse;

public interface DecryptionService {

	DecryptionResponse decryptMessage(DecryptionRequest decryptionRequest);

}
