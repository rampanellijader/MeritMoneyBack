package br.com.Meritmoney.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Premio implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 50)
	private String nome;
	@Column(length = 15)
	private Integer valor;
	@Column(length = 150)
	private String descricao;
	@Column(length = 15)
	private String Imagem;
	@Column(length = 2000000)
	private String img;
	
	
	
	 @OneToMany(mappedBy = "premio", targetEntity= UsuarioPremio.class, fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	 private List<UsuarioPremio> UsuarioPremioList;
	
	public Premio() {

	}

	public Premio(Integer id, String nome, Integer valor, String descricao) {
		super();
		this.id = id;
		this.nome = nome;
		this.valor = valor;
		this.descricao = descricao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Premio [id=" + id + ", nome=" + nome + ", valor=" + valor + ", descricao=" + descricao + "]";
	}	
	
}
