package br.com.goodbuy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.goodbuy.mapper.ProdutoMapper;
import br.com.goodbuy.model.Produto;

@Component
public class ProdutoService {
	
	@Autowired
	private ProdutoMapper mapper;
	
	public Produto carrega(Long id){
		return mapper.carrega(id);
	}
	
	public List<Produto> lista() {
		return mapper.listar();
	}
	
	public void salva(Produto produto){
		mapper.salva(produto);
	}
	
	public void remove(Produto produto){
		mapper.remove(produto);
	}
	
	public void atualiza(Produto produto){
	}

}
