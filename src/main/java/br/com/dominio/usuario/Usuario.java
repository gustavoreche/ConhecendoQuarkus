package br.com.dominio.usuario;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.aplicacao.usuario.UsuarioDTO;
import io.quarkus.elytron.security.common.BcryptUtil;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.security.jpa.Password;
import io.quarkus.security.jpa.Roles;
import io.quarkus.security.jpa.UserDefinition;
import io.quarkus.security.jpa.Username;

@Entity
@UserDefinition
public class Usuario extends PanacheEntityBase {
	
	private static final String ALURA = "alura";
	public static final String ADMIN = "admin";
	public static final String USER = "user";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String cpf;
	@Username
	private String username;
	@Password
	private String password;
	@Roles
	private String role;
	
	public Usuario() {
		
	}
	
	public Usuario(UsuarioDTO usuarioDTO) {
		this.nome = usuarioDTO.getNome();
		this.cpf = usuarioDTO.getCpf();
		this.username = usuarioDTO.getUsername();
		this.password = BcryptUtil.bcryptHash(usuarioDTO.getPassword());
		this.role = definePermissaoDoUsuario(usuarioDTO.getUsername());
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
	
	private String definePermissaoDoUsuario(String username) {
		if(username.toLowerCase().equals(ALURA))
			return ADMIN;
		return USER;
	}
	
	public String getRole() {
		return role;
	}

}
