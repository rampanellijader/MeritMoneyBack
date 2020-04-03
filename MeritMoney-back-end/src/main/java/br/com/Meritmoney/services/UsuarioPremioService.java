package br.com.Meritmoney.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.Meritmoney.entities.UsuarioPremio;
import br.com.Meritmoney.repositories.UsuarioPremioRepository;
import br.com.Meritmoney.services.exceptions.ObjectNotFoundException;

@Service
public class UsuarioPremioService {

	@Autowired
	private UsuarioPremioRepository repository;
	
	@Autowired
	private UsuarioService usuario;
	
	@Autowired
	private PremioService premio;
	
	public List<UsuarioPremio> findAll(){		
		return repository.findAll();
	}
	
	public UsuarioPremio findByID(Integer id) {		
		UsuarioPremio obj = repository.findById(id).orElse(null);
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
	
	public UsuarioPremio save(UsuarioPremio usuarioPremio) {
		//usuario.findByID(usuario.)
		return repository.saveAndFlush(usuarioPremio);
	}
	
	
}
