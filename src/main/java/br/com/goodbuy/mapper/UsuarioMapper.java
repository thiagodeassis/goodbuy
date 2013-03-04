package br.com.goodbuy.mapper;

import br.com.goodbuy.model.Usuario;

public interface UsuarioMapper {

	void cadastra(Usuario usuario);

	Usuario carregaPor(Long id);

}
