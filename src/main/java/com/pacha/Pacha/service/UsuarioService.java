package com.pacha.Pacha.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pacha.Pacha.bean.UsuarioBean;
import com.pacha.Pacha.entity.Usuario;
import com.pacha.Pacha.repository.CompradorRepository;
import com.pacha.Pacha.repository.NegocioRepository;
import com.pacha.Pacha.repository.UsuarioRepository;



@Service
public class UsuarioService  {
	
	@Autowired
	UsuarioRepository repoUsuario;

	@Autowired
	NegocioRepository repoNego;
	
	
	@Autowired
	CompradorRepository repoCompra;
	
	public Usuario  getUsuario(Long id){
		return repoUsuario.findById(id).get();
	}

	public UsuarioBean autenticacion(UsuarioBean ub){
		Usuario u= repoUsuario.findByUsername(ub.getUsername());
		
		if(u!=null) {
			ub.setId(u.getId());
			if(ub.getPassword().equals("12345"))
				if(u.getPassword().equals("$2a$10$xBPpxqLBdUXblMGkCwadr.hsNVyJk04A3hb4Fcjn79YeYzAtYCZzC")) 
					if(repoNego.findById(ub.getId()).isPresent()) {
						
						ub.setTipo("N");
					}
					else ub.setTipo("C");
			return ub;
		}
			
		return null;
			
	}


}
