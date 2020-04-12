package br.com.Meritmoney.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Doacao implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String texto;
	private Integer qtdMoedas;
	private Boolean auditado;
	private Boolean valido;
	
	
	
	
	public Doacao() {
		
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public Integer getQtdMoedas() {
		return qtdMoedas;
	}
	public void setQtdMoedas(Integer qtdMoedas) {
		this.qtdMoedas = qtdMoedas;
	}
	public Boolean getAuditado() {
		return auditado;
	}
	public void setAuditado(Boolean auditado) {
		this.auditado = auditado;
	}
	public Boolean getValido() {
		return valido;
	}
	public void setValido(Boolean valido) {
		this.valido = valido;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	private String  data;
	
	
	
	

}
