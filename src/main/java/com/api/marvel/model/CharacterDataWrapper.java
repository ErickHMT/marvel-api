package com.api.marvel.model;

import lombok.Data;
import lombok.Getter;

@Data
public class CharacterDataWrapper {

	private int code;
	private String status;
	private String copyright;
	private String attributionText;
	private String attributionHTML;
	private String etag;
	private CharacterDataContainer data;
	
	public CharacterDataWrapper(int responseCode, String status, CharacterDataContainer data) {

		this.code = responseCode;
		this.status = status;
		this.copyright = "© 2021 MARVEL";
		this.attributionText = "Data provided by Marvel. © 2021 MARVEL";
		this.attributionHTML = "<a href=\"http://marvel.com\">Data provided by Marvel. © 2021 MARVEL</a>";
		this.etag = "123456789"; // TODO: verificar retorno de eTag;
		this.data = data;
	}
	
}
