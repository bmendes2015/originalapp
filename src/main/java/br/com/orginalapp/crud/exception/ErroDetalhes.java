package br.com.orginalapp.crud.exception;

import java.util.Date;

public class ErroDetalhes {

	private Date timestamp;
	private String message;
	private String detalhes;

	public ErroDetalhes(Date timestamp, String message, String detalhes) {
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.detalhes = detalhes;
    }
	
	public Date getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetalhes() {
		return detalhes;
	}

}
