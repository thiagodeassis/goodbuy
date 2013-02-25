package br.com.goodbuy.controller;

import java.util.List;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.goodbuy.dao.ProdutoDAO;
import br.com.goodbuy.model.Produto;

@Resource
@Path("/produto")
public class ProdutosController {
	private ProdutoDAO dao;
	
	public ProdutosController(ProdutoDAO dao){
		this.dao = dao;
	}
	
	public List<Produto> lista() {
		return dao.listaDeProdutos();
	}
	
}
