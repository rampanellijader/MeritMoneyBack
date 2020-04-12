package br.com.Meritmoney.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.Meritmoney.entities.Perfil;
@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Integer> {

}
