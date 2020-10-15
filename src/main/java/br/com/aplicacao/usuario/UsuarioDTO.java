package br.com.aplicacao.usuario;

import br.com.dominio.usuario.Usuario;

public class UsuarioDTO {

	private Long id;
	private String nome;
	private String cpf;
	private String username;
	private String password;
	
	public UsuarioDTO(Usuario usuario) {
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.cpf = usuario.getCpf();
		this.username = usuario.getUsername();
		this.password = usuario.getPassword();
	}
	
	public Usuario converteParaAEntidade() {
		return new Usuario(this);
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
