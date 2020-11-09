package br.com.infraestrutura.ordem;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.aplicacao.ordem.OrdemDTO;
import br.com.aplicacao.ordem.OrdemRepositorio;
import br.com.dominio.ordem.Ordem;
import br.com.dominio.ordem.repositorio.OrdemRepository;

@Named("ordemComBancoDeDados")
@ApplicationScoped
public class OrdemComBancoDeDados implements OrdemRepositorio {
	
	@Inject
	OrdemRepository ordemRepository;

	@Override
	public void insere(Ordem ordem) {
		ordemRepository.persist(ordem);
	}

	@Override
	public List<OrdemDTO> listaTodos() {
		return OrdemDTO.converte(ordemRepository.listAll());
	}

}
