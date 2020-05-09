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

import br.com.Meritmoney.entities.Perfil;
import br.com.Meritmoney.services.PerfilService;
import io.swagger.annotations.Api;

@Api(tags="Perfil endpoint")
@RestController
@RequestMapping(value = "/perfil")
public class PerfilResource {

	@Autowired
	private PerfilService service;

	
	@GetMapping
	public ResponseEntity<List<Perfil>> findAll() {

		List<Perfil> perfis = service.findAll();
		return ResponseEntity.ok(perfis);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Perfil> findById(@PathVariable Integer id){
		Perfil obj = service.findByID(id);
		return ResponseEntity.ok(obj);
	}
		
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Perfil obj) {
		Perfil perfil = service.save(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(perfil.getId()).toUri();
		return ResponseEntity.created(uri).build();
		
	}
	
	
	
	
	
	
	
	@RequestMapping(value = "/{id}",method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody @Valid Perfil perfil, @PathVariable Integer id) {
		 
		    perfil.setId(id);
		    perfil = service.save(perfil);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(perfil.getId()).toUri();
			return ResponseEntity.created(uri).build();
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.deleteByID(id);
		return ResponseEntity.noContent().build();
	}
	
	//testando integração entre entidades
	/*@RequestMapping(value="/{id}", method= RequestMethod.POST)
	public String perfilUsuario(@PathVariable("id") Integer id, Usuario usuario){
		Perfil perfil = service.findByID(id);
		usuario.setPerfil(perfil);
		
	
		return "redict:/{id}"; 

	}
	*/


}
