package com.baumannibiuna.rest.exceptions;

import java.io.Serializable;
import java.util.Date;

public class ExceptionResponse implements Serializable{
	private static final long serialVersionUID = 1L;

	private Date timeStamp;
	private String message;
	private String datails;
	
	public ExceptionResponse(Date timeStamp, String message, String datails) {
		this.timeStamp = timeStamp;
		this.message = message;
		this.datails = datails;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDatails() {
		return datails;
	}
	
}
