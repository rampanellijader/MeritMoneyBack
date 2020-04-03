package br.com.Meritmoney.entities;



import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class UsuarioPremio implements Serializable{
	
	

private static final long serialVersionUID = 1L;
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;

public UsuarioPremio() {
	
}



private String data;



@ManyToOne
@JoinColumn(name = "usuario_id", referencedColumnName = "id")
private Usuario usuario;

@ManyToOne
@JoinColumn(name = "premio_id", referencedColumnName = "id")
private Premio premio;



@Column(name = "usuario_id", insertable = false, updatable = false)
private Integer usuarioId;

@Column(name = "premio_id", insertable = false, updatable = false)
private Integer premioId;

public Integer getId() {
	return id;
}

public Integer getUsuarioId() {
	return usuarioId;
}

public void setUsuarioId(Integer usuarioId) {
	this.usuarioId = usuarioId;
}

public Integer getPremioId() {
	return premioId;
}

public void setPremioId(Integer premioId) {
	this.premioId = premioId;
}

public void setId(Integer id) {
	this.id = id;
}

public String getData() {
	return data;
}

public void setData(String data) {
	this.data = data;
}







}
