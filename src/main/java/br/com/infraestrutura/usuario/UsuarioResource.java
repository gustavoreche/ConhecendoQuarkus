package br.com.infraestrutura.usuario;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.aplicacao.usuario.UsuarioDTO;
import br.com.dominio.usuario.Usuario;

@Path("/usuarios")
public class UsuarioResource {
	
	@POST
	@PermitAll
	@Transactional
	@Consumes(MediaType.APPLICATION_JSON)
	public void insere(UsuarioDTO usuarioDTO) {
		Usuario.persist(usuarioDTO.converteParaAEntidade());
	}
	
	@GET
	@RolesAllowed(Usuario.ADMIN)
	@Produces(MediaType.APPLICATION_JSON)
	public List<UsuarioDTO> lista(){
		return UsuarioDTO.converte(Usuario.listAll());
	}
}
