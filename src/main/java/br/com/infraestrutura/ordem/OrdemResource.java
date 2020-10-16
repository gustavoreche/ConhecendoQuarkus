package br.com.infraestrutura.ordem;

import java.util.List;
import java.util.Optional;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

import br.com.aplicacao.ordem.OrdemDTO;
import br.com.dominio.ordem.repositorio.OrdemRepository;
import br.com.dominio.usuario.Usuario;

@Path("/ordens")
public class OrdemResource {
	
	private static final String ERRO_DE_USUARIO = "O usuário logado é diferente do \"user_id\"";
	
	@Inject
	OrdemRepository ordemRepository;
	
	@POST
	@Transactional
	@RolesAllowed(Usuario.USER)
	@Consumes(MediaType.APPLICATION_JSON)
	public void insere(@Context SecurityContext security, OrdemDTO ordemDTO) {
		validaUsuario(security, ordemDTO);
		this.ordemRepository.persist(ordemDTO.converteParaAEntidade());
	}

	private void validaUsuario(SecurityContext security, OrdemDTO ordemDTO) {
		Optional<Usuario> existeUsuario = Usuario.findByIdOptional(ordemDTO.getUserId());
		Usuario usuario = existeUsuario.orElseThrow();
		if(!usuario.getUsername().equals(security.getUserPrincipal().getName()))
			throw new RuntimeException(ERRO_DE_USUARIO);
		
	}
	
	@GET
	@RolesAllowed(Usuario.ADMIN)
	@Produces(MediaType.APPLICATION_JSON)
	public List<OrdemDTO> lista() {
		return OrdemDTO.converte(this.ordemRepository.listAll());
	}

}
