package br.com.dominio.ordem.repositorio;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import br.com.dominio.ordem.Ordem;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;

@QuarkusTest
class OrdemRepositoryTest {

	@InjectMock
	OrdemRepository ordemRepository;
	
	@Test
	void listAll_tudoValido_retornoOk() {
		Ordem ordem1 = new Ordem();
		Ordem ordem2 = new Ordem();
		List<Ordem> listaDeOrdens = new ArrayList<Ordem>();
		
		listaDeOrdens.add(ordem1);
		listaDeOrdens.add(ordem2);
		
		Mockito.when(ordemRepository.listAll()).thenReturn(listaDeOrdens);
		
		Assertions.assertSame(ordem2, ordemRepository.listAll().get(1));
	}

}
