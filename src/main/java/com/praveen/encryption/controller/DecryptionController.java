package com.praveen.encryption.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.praveen.encryption.DecryptApi;
import com.praveen.encryption.model.DecryptionRequest;
import com.praveen.encryption.model.DecryptionResponse;
import com.praveen.encryption.service.DecryptionService;

/**
 * This class exposes APIs related to decryption   
 * 
 * @author Praveen J
 */
@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class DecryptionController implements DecryptApi {

	@Autowired
	private DecryptionService decryptionService;

	/**
	 * This method performs decryption of encrypted message
	 */
	@PostMapping("/decryptMessage") 
	@Override
	public ResponseEntity<DecryptionResponse> decryptMessage(@Valid DecryptionRequest decryptionRequest) {
		// calling service method
		DecryptionResponse decryptionResponse = this.decryptionService.decryptMessage(decryptionRequest);

		// returning response
		return new ResponseEntity<>(decryptionResponse, HttpStatus.OK);
	}

}
