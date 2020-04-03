package br.com.Meritmoney.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.Meritmoney.entities.UsuarioPremio;

@Repository
public interface UsuarioPremioRepository extends JpaRepository<UsuarioPremio, Integer>{

}
