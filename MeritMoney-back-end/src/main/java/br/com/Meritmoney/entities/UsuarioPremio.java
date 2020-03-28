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

public UsuarioPremio(Integer id, String data, Usuario usuario, Premio premio, Integer idUsuario, Integer idPremio) {
	super();
	this.id = id;
	this.data = data;
	this.usuario = usuario;
	this.premio = premio;
	this.idUsuario = idUsuario;
	this.idPremio = idPremio;
}

private String data;



@ManyToOne
@JoinColumn(name = "id_usuario", referencedColumnName = "id")
private Usuario usuario;

@ManyToOne
@JoinColumn(name = "id_premio", referencedColumnName = "id")
private Premio premio;


@Column(name = "id_usuario", insertable = false, updatable = false)
private Integer idUsuario;

@Column(name = "id_premio", insertable = false, updatable = false)
private Integer idPremio;


public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public Integer getIdUsuario() {
    return usuario == null ? null : usuario.getId();
}

public Integer getIdPremio() {
    return premio == null ? null : premio.getId();
}

public String getData() {
	return data;
}

public void setData(String data) {
	this.data = data;
}


@Override
public String toString() {
	return "UsuarioPremio [id=" + id + ", data=" + data + ", usuario=" + usuario + ", premio=" + premio
			+ ", idUsuario=" + idUsuario + ", idPremio=" + idPremio + "]";
}

}
