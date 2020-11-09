package br.com.aplicacao.ordem;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import br.com.dominio.ordem.Ordem;

@ApplicationScoped
public interface OrdemRepositorio {
	
	void insere(Ordem ordem);
	List<OrdemDTO> listaTodos();

}
