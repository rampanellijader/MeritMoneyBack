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

import br.com.Meritmoney.entities.UsuarioPremio;
import br.com.Meritmoney.services.UsuarioPremioService;
import io.swagger.annotations.Api;

@Api(tags="Usuário-Prêmio endpoint")
@RestController
@RequestMapping(value = "/usuario_premio")
public class UsuarioPremioResource {
	
	@Autowired
	private UsuarioPremioService service;
	
	@GetMapping
	public ResponseEntity<List<UsuarioPremio>> findAll() {

		List<UsuarioPremio> usuarios = service.findAll();
		return ResponseEntity.ok(usuarios);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<UsuarioPremio> findById(@PathVariable Integer id){
		UsuarioPremio obj = service.findByID(id);
		return ResponseEntity.ok(obj);
	}

	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.deleteByID(id);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody UsuarioPremio obj) {
		UsuarioPremio usuarioPremio = service.save(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usuarioPremio.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody @Valid UsuarioPremio usuarioPremio, @PathVariable Integer id) {
		
		usuarioPremio.setId(id);
		usuarioPremio = service.save(usuarioPremio);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usuarioPremio.getId()).toUri();
			return ResponseEntity.created(uri).build();
	}
}
