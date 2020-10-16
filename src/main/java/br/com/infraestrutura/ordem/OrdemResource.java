package br.com.infraestrutura.ordem;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import br.com.aplicacao.ordem.OrdemDTO;
import br.com.dominio.ordem.repositorio.OrdemRepository;

@Path("/ordens")
public class OrdemResource {
	
	@Inject
	OrdemRepository ordemRepository;
	
	@POST
	@Transactional
	@Consumes(MediaType.APPLICATION_JSON)
	public void insere(OrdemDTO ordemDTO) {
		this.ordemRepository.persist(ordemDTO.converteParaAEntidade());
	}

}
