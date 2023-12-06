package com.rocha.app.a.product;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rocha.app.a.product.entity.Prestamo;
import com.rocha.app.a.product.entity.TipoUsuario;
import com.rocha.app.a.product.entity.Usuario;
import com.rocha.app.a.product.repository.PrestamoRepository;

@RestController
@RequestMapping("/prestamo")
public class PrestamoControlador {
	
	
	@Autowired
	private PrestamoRepository repository;
	
	@PostMapping
	public PrestamoResponse registrarPrestamo(@RequestBody PrestamoRequest prestamoRequest) {
		
		Prestamo p = new Prestamo();
		p.setIsbn("123a4db");
		p.setTipoUsuario(TipoUsuario.USUARIO_AFILIADO.getCodigo());
		Usuario u = new Usuario();
		u.setIdentificadorUsuario("73216154");
		p.setUsario(u);
		
		repository.save(p);
	
		
		return new PrestamoResponse().builder().setId(1).setFechaMaximaDevolucion(LocalDate.now()).build();
	}
	
	

}
