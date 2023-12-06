package com.rocha.app.a.product.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Prestamo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer id;
	
	private String isbn;
	private int tipoUsuario;
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Usuario usario;
	
	

	public Prestamo() {
		super();
	}



	public Prestamo(Integer id, String isbn, int tipoUsuario, Usuario usario) {
		super();
		this.id = id;
		this.isbn = isbn;
		this.tipoUsuario = tipoUsuario;
		this.usario = usario;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getIsbn() {
		return isbn;
	}



	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}



	public int getTipoUsuario() {
		return tipoUsuario;
	}



	public void setTipoUsuario(int tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}



	public Usuario getUsario() {
		return usario;
	}



	public void setUsario(Usuario usario) {
		this.usario = usario;
	}
	
	
	
	
	

}



//isbn : identificador unido de un libro (campo alfanumerico de maximo 10 digitos)
//identificacionUsuario : numero de la indentificacion del usuario (campo alfanumerico de maximo 10 digitos)
//tipoUsuario : determina la relacion que tiene el usuario con la biblioteca (campo de un solo digito)
//1: usuario afiliado
//2: usuario empleado de la biblioteca
//3: usuario invitado