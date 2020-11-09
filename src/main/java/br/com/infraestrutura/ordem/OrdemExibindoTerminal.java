package br.com.infraestrutura.ordem;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import br.com.aplicacao.ordem.OrdemDTO;
import br.com.aplicacao.ordem.OrdemRepositorio;
import br.com.dominio.ordem.Ordem;

@Named("ordemTerminal")
@ApplicationScoped
public class OrdemExibindoTerminal implements OrdemRepositorio {
	
	@Override
	public void insere(Ordem ordem) {
		System.out.println("TESTE");
	}

	@Override
	public List<OrdemDTO> listaTodos() {
		return null;
	}

}
