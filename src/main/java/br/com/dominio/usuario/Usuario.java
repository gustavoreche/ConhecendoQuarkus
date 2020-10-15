package br.com.dominio.usuario;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.aplicacao.usuario.UsuarioDTO;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String cpf;
	private String username;
	private String password;
	
	public Usuario(UsuarioDTO usuarioDTO) {
		this.id = usuarioDTO.getId();
		this.nome = usuarioDTO.getNome();
		this.cpf = usuarioDTO.getCpf();
		this.username = usuarioDTO.getUsername();
		this.password = usuarioDTO.getPassword();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

}
