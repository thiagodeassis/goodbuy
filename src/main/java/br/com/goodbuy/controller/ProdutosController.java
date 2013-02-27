package br.com.goodbuy.controller;

import java.util.List;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.goodbuy.dao.ProdutoDAO;
import br.com.goodbuy.model.Produto;

@Resource
@Path("/produtos")
public class ProdutosController {
	private final ProdutoDAO dao;
	private final Result result;
	
	public ProdutosController(ProdutoDAO dao, Result result){
		this.dao = dao;
		this.result = result;
	}
	
	public void adiciona(Produto produto) {
		dao.salva(produto);
		result.redirectTo(this).lista();

	}

	
	public List<Produto> lista() {
		return dao.listaDeProdutos();
	}
	
	public void formulario() {
	}

	
}
