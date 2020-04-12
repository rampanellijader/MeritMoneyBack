package br.com.Meritmoney.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.Meritmoney.entities.Premio;

@Repository
public interface PremioRepository extends JpaRepository<Premio, Integer> {
	
	Premio findByNome(String nome);
	


}
