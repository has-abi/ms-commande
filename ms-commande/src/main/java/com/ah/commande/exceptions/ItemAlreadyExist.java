package com.ah.commande.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.RESET_CONTENT)
public class ItemAlreadyExist extends RuntimeException {
	public ItemAlreadyExist(String message) {
		super(message);
	}

}
