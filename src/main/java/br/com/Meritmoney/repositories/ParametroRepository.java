package br.com.Meritmoney.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.Meritmoney.entities.Parametro;


@Repository
public interface ParametroRepository extends JpaRepository<Parametro, Integer> {

}
