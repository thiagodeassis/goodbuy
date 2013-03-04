package br.com.goodbuy.mapper;

import java.util.List;

import br.com.goodbuy.model.Produto;

public interface ProdutoMapper {
	
	void salva(Produto produto);
	
	void remove(Produto produto);
	
	void atualiza(Produto produto);

	Produto carrega(Long id);

	List<Produto> listar();

}
