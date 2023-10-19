package com.praveen.encryption.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.praveen.encryption.EncryptApi;
import com.praveen.encryption.model.EncryptionRequest;
import com.praveen.encryption.model.EncryptionResponse;
import com.praveen.encryption.service.EncryptionService;

/**
 * This class exposes APIs related to encryption   
 * 
 * @author Praveen J
 * 
 */
@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class EncryptionController implements EncryptApi {

	@Autowired
	private EncryptionService encryptionService;

	/**
	 * This method performs encryption for the input message
	 */
	@PostMapping("/encryptMessage")
	@Override
	public ResponseEntity<EncryptionResponse> encryptMessage(@Valid EncryptionRequest encryptionRequest) {
		// calling service method
		EncryptionResponse encryptionResponse = this.encryptionService.encryptMessage(encryptionRequest);

		// returning response
		return new ResponseEntity<>(encryptionResponse, HttpStatus.OK);
	}

}
