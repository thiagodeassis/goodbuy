package br.com.goodbuy.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;
import static br.com.goodbuy.service.test.util.ResourceLoader.*;

import br.com.goodbuy.model.Usuario;
import br.com.goodbuy.service.test.dbunit.DbUnitManager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContextTest.xml",
                                  "file:./src/main/webapp/WEB-INF/config/applicationContext-persistence.xml"})
@Transactional
public class UsuarioServiceTest {
	
	private static final String USUARIO = "/datasets/Usuario.xml";
	
	@Autowired
	private UsuarioService service;
	
	@Autowired
	private DbUnitManager manager;
	
	@Before
	public void setUp() {
		manager.cleanAndInsert(filePath(USUARIO));
	}
	
	@Test
	public void deveSerPossivelCadastrarUsuario() {
		service.cadastra(jose());
		assertEquals(jose(), service.carregaPor(jose().getId()));
	}

	private Usuario jose() {
		Usuario usuario = new Usuario();
		usuario.setId(1L);
		usuario.setNome("Jose");
		return usuario;
	}
}
