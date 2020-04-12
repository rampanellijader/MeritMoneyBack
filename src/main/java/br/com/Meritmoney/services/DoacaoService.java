package br.com.Meritmoney.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.Meritmoney.repositories.DoacaoRepository;
import br.com.Meritmoney.services.exceptions.ObjectNotFoundException;
import br.com.Meritmoney.entities.Doacao;
import java.util.List;

@Service
public class DoacaoService {
	
	@Autowired
	private DoacaoRepository repository;
	
	public List<Doacao> findAll(){
		return repository.findAll();
	}

	public Doacao findByID(Integer id) {		
		Doacao obj = repository.findById(id).orElse(null);
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
	
	public Doacao save(Doacao doacao) {		
		return repository.saveAndFlush(doacao);
	}
	
	
	
}
