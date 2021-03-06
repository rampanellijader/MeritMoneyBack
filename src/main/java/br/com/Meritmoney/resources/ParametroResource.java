package br.com.Meritmoney.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.Meritmoney.entities.Parametro;
import br.com.Meritmoney.services.ParametroService;
import io.swagger.annotations.Api;

@CrossOrigin
@Api(tags="Parâmetro endpoint")
@RestController
@RequestMapping(value = "/parametro")
public class ParametroResource {

	@Autowired
	private ParametroService service;
	
	@CrossOrigin
	@GetMapping
	public ResponseEntity<List<Parametro>> findAll() {

		List<Parametro> parametro = service.findAll();
		return ResponseEntity.ok(parametro);
	}

	@CrossOrigin
	@GetMapping(value = "/{id}")
	public ResponseEntity<Parametro> findById(@PathVariable Integer id){
		Parametro obj = service.findByID(id);
		return ResponseEntity.ok(obj);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.deleteByID(id);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Parametro obj) {
		Parametro parametro = service.save(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(parametro.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	@RequestMapping(value = "/{id}",method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody @Valid Parametro parametro, @PathVariable Integer id) {
		Parametro obj = service.findByID(id);		
		parametro.setId(id);
		parametro.setNome(parametro.getNome() == null ? obj.getNome() : parametro.getNome());
		parametro.setValor(parametro.getValor() == null ? obj.getValor() : parametro.getValor());	
		
		parametro = service.save(parametro);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(parametro.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

}
