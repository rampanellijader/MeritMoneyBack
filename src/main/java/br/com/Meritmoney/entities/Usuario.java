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
public class Usuario implements  Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 30)
	private String nome;
	@Column(length = 60)
	private String usuario;
	@Column(length = 60)
	private String senha;
	
	
	@Column(length = 15)
	private Integer CollaboratorCoin;
	@Column(length = 15)
	private Integer SkillCoin;
	
	
	@ManyToOne
	@JoinColumn(name="perfil_id")
	private Perfil perfil;
	


	public Usuario() {

	}

	public Usuario(Integer id, String nome, String usuario, String senha, Integer collaboratorCoin, Integer skillCoin
			) {
		this.id = id;
		this.nome = nome;
		this.usuario = usuario;
		this.senha = senha;
		CollaboratorCoin = collaboratorCoin;
		SkillCoin = skillCoin;
		
	}





	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}



	public Integer getCollaboratorCoin() {
		return CollaboratorCoin;
	}

	public void setCollaboratorCoin(Integer collaboratorCoin) {
		CollaboratorCoin = collaboratorCoin;
	}

	public Integer getSkillCoin() {
		return SkillCoin;
	}

	public void setSkillCoin(Integer skillCoin) {
		SkillCoin = skillCoin;
	}
	
	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
	
	
	

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", usuario=" + usuario + ", senha=" + senha + ", CollaboratorCoin="
				+ CollaboratorCoin + ", SkillCoin=" + SkillCoin + "]";  //", perfil=" + perfil_id + "]";
	}

	


}
