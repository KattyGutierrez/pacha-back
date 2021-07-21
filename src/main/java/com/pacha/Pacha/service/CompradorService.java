package com.pacha.Pacha.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pacha.Pacha.bean.CompradorBean;
import com.pacha.Pacha.entity.Comprador;
import com.pacha.Pacha.repository.CompradorRepository;

@Service
public class CompradorService {
	@Autowired
	CompradorRepository repoComprador;
	

	public Comprador getComprador(Long id) {
		return repoComprador.findById(id).get();
	}
	
	
	public Comprador registrar(CompradorBean cb) {
			Comprador c= new Comprador();
			
			c.setUsername(cb.getUsername());
			c.setEmail(cb.getEmail());
			
			c.setPassword("$2a$10$xBPpxqLBdUXblMGkCwadr.hsNVyJk04A3hb4Fcjn79YeYzAtYCZzC");
			//c.setPassword((cb.getContra()));
			c.setDni(cb.getDni());
			c.setFirstName(cb.getFirstname());
			c.setLastName(cb.getLastname());
			repoComprador.save(c);
			return c;
	}
}
