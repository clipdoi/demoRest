package com.demorest.exception;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class InputInvalidException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InputInvalidException(String message) {
        super(message);
    }

}
