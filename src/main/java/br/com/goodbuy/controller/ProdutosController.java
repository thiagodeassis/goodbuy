package br.com.goodbuy.controller;

import java.util.List;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.goodbuy.model.Produto;
import br.com.goodbuy.service.ProdutoService;

@Resource
@Path("/produtos")
public class ProdutosController {
	
	private ProdutoService produtoService;
	private final Result result;
	
	public ProdutosController(ProdutoService produtoService, Result result){
		this.produtoService = produtoService;
		this.result = result;
	}
	
	public void adiciona(Produto produto) {
		produtoService.salva(produto);
		result.redirectTo(this).lista();
	}
	
	public Produto edita(Long id) {
		return produtoService.carrega(id);
	}
	
	public void altera(Produto produto) {
		produtoService.atualiza(produto);
		result.redirectTo(this).lista();
	}

	public void remove(Long id) {
		Produto produto = produtoService.carrega(id);
		produtoService.remove(produto);
		result.redirectTo(this).lista();
	}
	@Get
	@Path("/lista")
	public List<Produto> lista() {
		return produtoService.lista();
	}
	
	public void formulario() {
	}
}
