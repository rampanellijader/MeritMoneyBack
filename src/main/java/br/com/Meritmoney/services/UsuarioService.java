package br.com.Meritmoney.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.Meritmoney.entities.Usuario;
import br.com.Meritmoney.repositories.UsuarioRepository;
import br.com.Meritmoney.services.exceptions.ObjectNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	public List<Usuario> findAll(){		
		return repository.findAll();
	}
	
	public Usuario findByID(Integer id) {		
		Usuario obj = repository.findById(id).orElse(null);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não localizado!");
		}		
		return obj;
	}
	
	
	public void deleteByID(Integer id) {
		if (id == null) {
			throw new ObjectNotFoundException("Objeto não localizado!");
		}
		repository.deleteById(id);		
	}
	
	public Usuario save(Usuario usuario) {		
		return repository.saveAndFlush(usuario);
	}
	
	
	
	
	//buscar por email
		public Usuario findByEmail(String email) {		
			Usuario obj = repository.findByEmail(email);
			if (obj == null) {
				throw new ObjectNotFoundException("Usuario" + email + "não localizado!");
			}		
			 return obj;
		}
	
		

		//buscar por Login
			public Usuario findByLogin(String login) {		
				Usuario obj = repository.findByLogin(login);
				if (obj == null) {
					throw new ObjectNotFoundException("Usuario" + login + "não localizado!");
				}		
				 return obj;
			}
		
	
	
	
	
}
