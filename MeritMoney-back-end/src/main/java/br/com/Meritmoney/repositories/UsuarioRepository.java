package br.com.Meritmoney.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.Meritmoney.entities.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	@Query("select u from Usuario u where u.nome = ?1")
	Usuario findByNome(String nome);

}
