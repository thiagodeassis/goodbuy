package br.com.goodbuy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.goodbuy.mapper.UsuarioMapper;
import br.com.goodbuy.model.Usuario;

@Component
@Transactional
public class UsuarioService {
	@Autowired
	private UsuarioMapper mapper;

	public void cadastra(Usuario usuario) {
		mapper.cadastra(usuario);
	}

	public Usuario carregaPor(Long id) {
		return mapper.carregaPor(id);
	}

}
