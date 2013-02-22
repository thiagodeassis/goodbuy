package br.com.goodbuy.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;

@Resource
@Path("/produto")
public class ProdutoController {

	@Get
	@Path("/")
	public void paginaDePesquisa(){
		
	}
	
}
