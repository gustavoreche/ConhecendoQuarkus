package br.com.aplicacao.usuario;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import br.com.dominio.usuario.Usuario;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
class UsuarioDTOTest {

	@Test
	void construtorComParametros_tudoValido_retornoOk() {
		String nome = "GUSTAVO";
		
		Usuario usuario = Mockito.mock(Usuario.class);
		Mockito.when(usuario.getNome()).thenReturn(nome);
		UsuarioDTO usuarioDTO = new UsuarioDTO(usuario);
		Assertions.assertSame(nome, usuarioDTO.getNome());
	}

	@Test
	void converteParaAEntidade_tudoValido_retornoOk() {
		String nome = "GUSTAVO"; 

		UsuarioDTO usuarioDTO = new UsuarioDTO();
		usuarioDTO.setNome(nome);
		usuarioDTO.setCpf("123");
		usuarioDTO.setUsername("greche");
		usuarioDTO.setPassword("1234");
		
		Usuario usuario = usuarioDTO.converteParaAEntidade();
		Assertions.assertSame(nome, usuario.getNome());
	}
	
	@Test
	void converte_tudoValido_retornoOk() {
		String nome = "GUSTAVO"; 
		
		Usuario usuario1 = Mockito.mock(Usuario.class);
		Mockito.when(usuario1.getNome()).thenReturn(nome);
		Usuario usuario2 = Mockito.mock(Usuario.class);
		
		List<Usuario> listaDeUsuario = new ArrayList<Usuario>();
		listaDeUsuario.add(usuario1);
		listaDeUsuario.add(usuario2);
		
		List<UsuarioDTO> listaDeUsuarioDTO = UsuarioDTO.converte(listaDeUsuario);
		Assertions.assertSame(nome, listaDeUsuarioDTO.get(0).getNome());
	}

}
