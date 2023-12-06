package com.rocha.app.a.product.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
public class Usuario {
	
	@Id
	private String identificadorUsuario;
	
	@OneToMany(targetEntity = Prestamo.class, cascade= CascadeType.MERGE, fetch = FetchType.LAZY)
	private List<Prestamo> prestamos = new ArrayList<>();

	public Usuario(String identificadorUsuario, List<Prestamo> prestamos) {
		super();
		this.identificadorUsuario = identificadorUsuario;
		this.prestamos = prestamos;
	}

	public Usuario() {
		super();
	}

	public String getIdentificadorUsuario() {
		return identificadorUsuario;
	}

	public void setIdentificadorUsuario(String identificadorUsuario) {
		this.identificadorUsuario = identificadorUsuario;
	}

	public List<Prestamo> getPrestamos() {
		return prestamos;
	}

	public void addPrestamo(Prestamo prestamo) {
		this.prestamos.add(prestamo);
	}
	
	
	
	

}

