package com.te.pearsonassignement.controladvice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.te.pearsonassignement.exception.CustomException;
import com.te.pearsonassignement.model.ResponseModel;

@RestControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(CustomException.class)
	public ResponseEntity<ResponseModel> getException(CustomException exceptionClass) {
		return new ResponseEntity<>(new ResponseModel(false, exceptionClass.getMessage(), null), HttpStatus.NOT_FOUND);
	}

}
