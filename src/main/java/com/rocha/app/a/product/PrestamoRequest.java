package com.rocha.app.a.product;

import java.io.Serializable;

import com.rocha.app.a.product.entity.TipoUsuario;

public class PrestamoRequest implements Serializable{
	private static final long serialVersionUID = -3461310644739103111L;

	private String isbn;
	private String identificadorUsuario;
	private TipoUsuario tipoUsuario;
	
	public PrestamoRequest() {
		super();
	}
	
	
	public PrestamoRequest(String isbn, String identificadorUsuario, TipoUsuario tipoUsuario) {
		super();
		this.isbn = isbn;
		this.identificadorUsuario = identificadorUsuario;
		this.tipoUsuario = tipoUsuario;
	}


	public String getIsbn() {
		return isbn;
	}


	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}


	public String getIdentificadorUsuario() {
		return identificadorUsuario;
	}


	public void setIdentificadorUsuario(String identificadorUsuario) {
		this.identificadorUsuario = identificadorUsuario;
	}


	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}


	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
}
