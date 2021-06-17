package com.api.marvel.controller.dto;

import lombok.Data;

@Data
public class DataWrapper {

	private int code;
	private String status;
	private String copyright;
	private String attributionText;
	private String attributionHTML;
	private String etag;
	private DataContainer<?> data;
	
	public DataWrapper(int responseCode, String status, DataContainer<?> data) {

		this.code = responseCode;
		this.status = status;
		this.copyright = "© 2021 MARVEL";
		this.attributionText = "Data provided by Marvel. © 2021 MARVEL";
		this.attributionHTML = "<a href=\"http://marvel.com\">Data provided by Marvel. © 2021 MARVEL</a>";
		this.etag = "123456789"; // TODO: verificar retorno de eTag;
		this.data = data;
	}
	
}
