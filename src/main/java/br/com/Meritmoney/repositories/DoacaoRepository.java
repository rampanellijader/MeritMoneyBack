package br.com.Meritmoney.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.Meritmoney.entities.Doacao;

public interface DoacaoRepository extends JpaRepository<Doacao, Integer> {
	
}
