package br.com.dominio.usuario;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.panache.mock.PanacheMock;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
class UsuarioTest {

	@Test
	void findByIdOptional_tudoValido_retornoOk() {
		PanacheMock.mock(Usuario.class);
		Usuario usuarioCriado = new Usuario();
		Optional<PanacheEntityBase> usuario = Optional.of(usuarioCriado);
		Mockito.when(Usuario.findByIdOptional(999)).thenReturn(usuario);
		Assertions.assertSame(usuarioCriado, Usuario.findByIdOptional(999).get());
	}

}
