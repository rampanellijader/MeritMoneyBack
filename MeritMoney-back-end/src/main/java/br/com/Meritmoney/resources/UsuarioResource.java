package br.com.Meritmoney.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.Meritmoney.entities.Usuario;
import br.com.Meritmoney.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioResource {

	@Autowired
	private UsuarioService service;

	@GetMapping
	public ResponseEntity<List<Usuario>> findAll() {

		List<Usuario> usuarios = service.findAll();
		return ResponseEntity.ok(usuarios);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable Integer id){
		Usuario obj = service.findByID(id);
		return ResponseEntity.ok(obj);
		
		
	}
	
	//buscar por nome
	@GetMapping(value = "/{nome}")
	public ResponseEntity<Usuario> findByNome(@PathVariable String nome){
		Usuario obj = service.findByNome(nome);
		return ResponseEntity.ok(obj);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.deleteByID(id);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Usuario obj) {
		Usuario usuario = service.save(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usuario.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody @Valid Usuario usuario, @PathVariable Integer id) {
		
			usuario.setId(id);
			usuario = service.save(usuario);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usuario.getId()).toUri();
			return ResponseEntity.created(uri).build();
	}
	
	
	
	
	

}
