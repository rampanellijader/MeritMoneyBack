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
	
	
	
	//buscar por login
	public Usuario findByLogin(String usuario) {		
		Usuario obj = repository.findByLogin(usuario);
		if (obj == null) {
			throw new ObjectNotFoundException("Usuario" + usuario + "não localizado!");
		}		
		 return obj;
	}
	
	
	


	
	public UsuarioService(UsuarioRepository repository) {
		
		this.repository = repository;
	}

	
	
	
	
}
