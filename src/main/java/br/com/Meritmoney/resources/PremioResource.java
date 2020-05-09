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

import br.com.Meritmoney.entities.Premio;
import br.com.Meritmoney.services.PremioService;
import io.swagger.annotations.Api;


@Api(tags="Prêmio endpoint")
@RestController
@RequestMapping(value = "/premio")
public class PremioResource {

	@Autowired
	private PremioService service;

	@GetMapping
	public ResponseEntity<List<Premio>> findAll() {

		List<Premio> premio = service.findAll();
		return ResponseEntity.ok(premio);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Premio> findById(@PathVariable Integer id){
		Premio obj = service.findByID(id);
		return ResponseEntity.ok(obj);
	}
	
	//buscar por nome
		@GetMapping(value = "/nome/{nome}")
		public ResponseEntity<Premio> findByNome(@PathVariable String nome){
			Premio obj = service.findByNome(nome);
			return ResponseEntity.ok(obj);
		}
	
	
	
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.deleteByID(id);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Premio obj) {
		Premio premio = service.save(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(premio.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody @Valid Premio premio, @PathVariable Integer id) {	
		Premio obj = service.findByID(id);		
		premio.setId(id);
		premio.setNome(premio.getNome() == null ? obj.getNome() : premio.getNome());
		premio.setValor(premio.getValor() == null ? obj.getValor() : premio.getValor());
		premio.setDescricao(premio.getDescricao() == null ? obj.getDescricao() : premio.getDescricao());
		
		premio = service.save(premio);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(premio.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

}