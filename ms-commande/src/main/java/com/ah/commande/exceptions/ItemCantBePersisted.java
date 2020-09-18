package com.ah.commande.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ItemCantBePersisted extends RuntimeException{

	public ItemCantBePersisted(String message) {
		super(message);
		
	}


}
