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

import br.com.Meritmoney.entities.Doacao;
import br.com.Meritmoney.services.DoacaoService;
import io.swagger.annotations.Api;

@CrossOrigin
@Api(tags="Doação endpoint")
@RestController
@RequestMapping(value = "/doacao")
public class DoacaoResource {
	
	@Autowired
	private DoacaoService service;
	
	@CrossOrigin
	@GetMapping
	public ResponseEntity<List<Doacao>> findAll() {

		List<Doacao> doacao = service.findAll();
		return ResponseEntity.ok(doacao);
	}
	
	@CrossOrigin
	@GetMapping(value = "/{id}")
	public ResponseEntity<Doacao> findById(@PathVariable Integer id){
		Doacao obj = service.findByID(id);
		return ResponseEntity.ok(obj);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.deleteByID(id);
		return ResponseEntity.noContent().build();
	}
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Doacao obj) {
		Doacao doacao = service.save(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(doacao.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@CrossOrigin
	@RequestMapping(value = "/{id}",method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody @Valid Doacao doacao, @PathVariable Integer id) {	
		Doacao obj = service.findByID(id);		
		doacao.setId(id);
		doacao.setAuditado(doacao.getAuditado() ==null ? obj.getAuditado() : doacao.getAuditado());
		doacao.setData(doacao.getData() ==null? obj.getData() : doacao.getData());
		doacao.setTexto(doacao.getTexto() ==null ? obj.getTexto() : doacao.getTexto());
		doacao.setValido(doacao.getValido() ==null ? obj.getValido() : doacao.getValido());
		doacao.setQtdMoedas(doacao.getQtdMoedas() ==null ? obj.getQtdMoedas() : doacao.getQtdMoedas());
		
		doacao = service.save(doacao);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(doacao.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
