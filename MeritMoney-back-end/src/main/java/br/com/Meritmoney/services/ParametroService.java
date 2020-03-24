package br.com.Meritmoney.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.Meritmoney.entities.Parametro;
import br.com.Meritmoney.repositories.ParametroRepository;
import br.com.Meritmoney.services.exceptions.ObjectNotFoundException;

@Service
public class ParametroService {

	@Autowired
	private ParametroRepository repository;
	
	public List<Parametro> findAll(){		
		return repository.findAll();
	}
	
	public Parametro findByID(Integer id) {		
		Parametro obj = repository.findById(id).orElse(null);
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
	
	public Parametro save(Parametro parametro) {		
		return repository.saveAndFlush(parametro);
	}
	
}
