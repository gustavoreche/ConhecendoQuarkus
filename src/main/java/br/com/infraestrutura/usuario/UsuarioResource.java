package br.com.infraestrutura.usuario;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import br.com.aplicacao.usuario.UsuarioDTO;
import br.com.dominio.usuario.Usuario;

@Path("/usuarios")
public class UsuarioResource {
	
	@POST
	@Transactional
	@Consumes(MediaType.APPLICATION_JSON)
	public void insere(UsuarioDTO usuarioDTO) {
		Usuario.persist(usuarioDTO.converteParaAEntidade());
	}
}
