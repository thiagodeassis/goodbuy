package br.com.goodbuy.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import br.com.caelum.vraptor.ioc.Component;
import br.com.goodbuy.model.Produto;

@Component
public class ProdutoDAO {
	private SqlSessionFactory sqlSessionFactory;

	public ProdutoDAO() {
		sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
	}
	
	public List<Produto> listaDeProdutos() {
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			@SuppressWarnings("unchecked")
			List<Produto> lista = session.selectList("Produto.listarProdutos");
			return lista;
		} finally {
			session.close();
		}
	}
	
	public void salva(Produto produto){
		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.insert("Produto.salva", produto);
			session.commit();
		} finally {
			session.close();
		}
	}
	
	public void deletaPelo(int id){
		SqlSession session = sqlSessionFactory.openSession();
		try{
			session.delete("Produto.deleteById", id);
			session.commit();
		} finally {
			session.close();
		}
	}
	
	public void atualiza(Produto produto){
		SqlSession session = sqlSessionFactory.openSession();
		try{
			session.update("Produto.update", produto);
			session.commit();
		} finally {
			session.close();
		}
	}

}
