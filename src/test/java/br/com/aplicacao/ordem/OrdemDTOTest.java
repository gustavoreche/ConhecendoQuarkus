package br.com.aplicacao.ordem;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import br.com.dominio.ordem.Ordem;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
class OrdemDTOTest {
	
	@Test
	void construtorComParametros_tudoValido_retornoOk() {
		String tipo = "COMPRA";
		
		Ordem ordem = Mockito.mock(Ordem.class);
		Mockito.when(ordem.getTipo()).thenReturn(tipo);
		OrdemDTO ordemDTO = new OrdemDTO(ordem);
		Assertions.assertSame(tipo, ordemDTO.getTipo());
	}

	@Test
	void converteParaAEntidade_tudoValido_retornoOk() {
		Double preco = 3.50; 

		OrdemDTO ordemDTO = new OrdemDTO();
		ordemDTO.setPreco(preco);
		ordemDTO.setTipo("VENDA");
		ordemDTO.setUserId(1L);
		
		Ordem ordem = ordemDTO.converteParaAEntidade();
		Assertions.assertSame(preco, ordem.getPreco());
	}
	
	@Test
	void converte_tudoValido_retornoOk() {
		String tipo = "COMPRA";
		
		Ordem ordem1 = Mockito.mock(Ordem.class);
		Mockito.when(ordem1.getTipo()).thenReturn(tipo);
		Ordem ordem2 = Mockito.mock(Ordem.class);
		
		List<Ordem> listaDeOrdem = new ArrayList<Ordem>();
		listaDeOrdem.add(ordem1);
		listaDeOrdem.add(ordem2);
		
		List<OrdemDTO> listaDeOrdemDTO = OrdemDTO.converte(listaDeOrdem);
		Assertions.assertSame(tipo, listaDeOrdemDTO.get(0).getTipo());
	}

}
