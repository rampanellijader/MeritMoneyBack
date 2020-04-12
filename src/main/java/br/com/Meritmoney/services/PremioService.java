package br.com.Meritmoney.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.Meritmoney.entities.Premio;
import br.com.Meritmoney.repositories.PremioRepository;
import br.com.Meritmoney.services.exceptions.ObjectNotFoundException;


@Service
public class PremioService {

	@Autowired
	private PremioRepository repository;
	
	public List<Premio> findAll(){		
		return repository.findAll();
	}
	
	public Premio findByID(Integer id) {		
		Premio obj = repository.findById(id).orElse(null);
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
	
	public Premio save(Premio premio) {		
		return repository.saveAndFlush(premio);
	}
	
	//buscar premio por nome
	public Premio findByNome(String nome){
		Premio obj = repository.findByNome(nome);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não localizado!");
		}		
		return obj;
	}
	
	
	

		
	
}