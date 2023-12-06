package com.rocha.app.a.product;

import java.io.Serializable;
import java.time.LocalDate;

public class PrestamoResponse implements Serializable {

	private static final long serialVersionUID = 8523128753930005982L;
	private Integer id;
	private LocalDate fechaMaximaDevolucion;

	public PrestamoResponse() {
		super();
	}

	public PrestamoResponse(Integer id, LocalDate fechaMaximaDevolucion) {
		super();
		this.id = id;
		this.fechaMaximaDevolucion = fechaMaximaDevolucion;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getFechaMaximaDevolucion() {
		return fechaMaximaDevolucion;
	}

	public void setFechaMaximaDevolucion(LocalDate fechaMaximaDevolucion) {
		this.fechaMaximaDevolucion = fechaMaximaDevolucion;
	}

	public Builder builder() {
		return new Builder();
	}
	
	
	

	@Override
	public String toString() {
		return "PrestamoResponse [id=" + id + ", fechaMaximaDevolucion=" + fechaMaximaDevolucion + "]";
	}




	public static class Builder {

		private PrestamoResponse prestamo;

		private Builder() {
			 this.prestamo = new PrestamoResponse();

		}

		public Builder setId(int id) {
			this.prestamo.id = id;
			return this;
		}
		
		public Builder setFechaMaximaDevolucion(LocalDate fechaMaximaDevolucion) {
			this.prestamo.fechaMaximaDevolucion = fechaMaximaDevolucion;
			return this;
		}

		public PrestamoResponse build() {
			return prestamo;
		}

	}

}
