package br.com.aplicacao.usuario;

import java.util.List;
import java.util.stream.Collectors;

import javax.json.bind.annotation.JsonbTransient;

import br.com.dominio.usuario.Usuario;

public class UsuarioDTO {

	private String nome;
	private String cpf;
	private String username;
	private String password;

	public UsuarioDTO() {

	}

	public UsuarioDTO(Usuario usuario) {
		this.nome = usuario.getNome();
		this.cpf = usuario.getCpf();
		this.username = usuario.getUsername();
		this.password = usuario.getPassword();
	}

	public Usuario converteParaAEntidade() {
		return new Usuario(this);
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

	@JsonbTransient
	public String getPassword() {
		return password;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static List<UsuarioDTO> converte(List<Usuario> usuarios) {
		return usuarios.stream().map(UsuarioDTO::new).collect(Collectors.toList());
	}

}
