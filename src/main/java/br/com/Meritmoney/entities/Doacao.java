package br.com.Meritmoney.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Doacao implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String texto;
	private Integer qtdMoedas;
	private Boolean auditado;
	private String textoAuditado;
	private Boolean valido;
	private String  data;
	@ManyToOne
	@JoinColumn(name="usuario_doador_id")
	private Usuario usuarioDoador;
	
	@ManyToOne
	@JoinColumn(name="usuario_recebedor_id")
	private Usuario usuarioRecebedor;
	
	
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
	public String getTextoAuditado() {
		return textoAuditado;
	}
	public void setTextoAuditado(String textoAuditado) {
		this.textoAuditado = textoAuditado;
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

	
	public Usuario getUsuarioDoador() {
		return usuarioDoador;
	}

	public void setUsuarioDoador(Usuario usuarioDoador) {
		this.usuarioDoador = usuarioDoador;
	}
	
	public Usuario getusuarioRecebedor() {
		return usuarioRecebedor;
	}

	public void setusuarioRecebedor(Usuario usuarioRecebedor) {
		this.usuarioRecebedor = usuarioRecebedor;
	}
	

}
