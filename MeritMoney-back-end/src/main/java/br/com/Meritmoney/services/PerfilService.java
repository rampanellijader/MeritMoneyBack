package br.com.Meritmoney.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.Meritmoney.entities.Perfil;
import br.com.Meritmoney.repositories.PerfilRepository;
import br.com.Meritmoney.services.exceptions.ObjectNotFoundException;

@Service
public class PerfilService {
	
	@Autowired
	private PerfilRepository repository;
	
	public List<Perfil> findAll(){		
		return repository.findAll();
	}
	
	public Perfil findByID(Integer id) {		
		Perfil obj = repository.findById(id).orElse(null);
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
	
	public Perfil save(Perfil perfil) {		
		return repository.saveAndFlush(perfil);
	}
	

}
