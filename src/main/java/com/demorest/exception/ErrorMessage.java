package com.demorest.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessage {
    private Integer statusCode;
    private String message;
    private String timestamp;
    private String description;
	public ErrorMessage(Integer statusCode, String message, String timestamp, String description) {
		super();
		this.statusCode = statusCode;
		this.message = message;
		this.timestamp = timestamp;
		this.description = description;
	}
    
}
