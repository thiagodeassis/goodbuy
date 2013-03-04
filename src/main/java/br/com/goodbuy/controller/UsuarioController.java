package br.com.goodbuy.controller;

import br.com.caelum.vraptor.Result;
import br.com.goodbuy.model.Usuario;
import br.com.goodbuy.service.UsuarioService;

public class UsuarioController {
	
	private UsuarioService service;
	private Result result;
	
	public UsuarioController(UsuarioService service, Result result){
		this.service = service;
		this.result = result;
	}

	public void cadastra(Usuario usuario) {
		try {
			service.cadastra(usuario);
			result.include("sucesso", "Usuário cadastrado com sucesso!");
			
		} catch (RuntimeException e) {
			result.include("erro", "Um erro ocorreu!");
		}
	}

}
