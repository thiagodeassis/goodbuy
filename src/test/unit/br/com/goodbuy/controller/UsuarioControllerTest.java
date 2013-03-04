package br.com.goodbuy.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import br.com.caelum.vraptor.util.test.MockResult;
import br.com.goodbuy.model.Usuario;
import br.com.goodbuy.service.UsuarioService;

public class UsuarioControllerTest {
	
	private UsuarioController controller;
	@Mock
	private UsuarioService service;
	private MockResult result;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		result = new MockResult();
		controller = new UsuarioController(service, result);
	}
	
	@Test
	public void deveSerPossivelCadastrarUsuario() {
		
		controller.cadastra(any(Usuario.class));
		verify(service).cadastra(any(Usuario.class));
		assertEquals("Usuário cadastrado com sucesso!", result.included().get("sucesso"));
	}
	
	@Test
	public void quandoOcorrerErroNoServico_Entao_DeveExibirMensagemDeErro() {
		doThrow(new RuntimeException()).when(service).cadastra(any(Usuario.class));
		controller.cadastra(any(Usuario.class));
		assertEquals("Um erro ocorreu!", result.included().get("erro"));
	}
	
	private Usuario jose() {
		Usuario usuario = new Usuario();
		
		usuario.setId(1L);
		usuario.setNome("José");
		return usuario;
	}
	
}
