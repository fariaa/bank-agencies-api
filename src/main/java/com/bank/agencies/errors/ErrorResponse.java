package com.bank.agencies.errors;

import java.io.Serializable;

/**
 * 
 * @author lucas_faria
 *
 */
public class ErrorResponse implements Serializable {

	private static final long serialVersionUID = -60111119893104506L;

	private String error;

	//TODO - implementar um tratamento melhor
	public ErrorResponse(Exception ex) {
		if (ex instanceof java.lang.IllegalArgumentException) {
			this.error = "estado fornecido não existe";
		}
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}
