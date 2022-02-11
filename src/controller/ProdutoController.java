package controller;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import dao.CategoriaDAO;
import dao.ProdutoDAO;
import factory.ConnectionFactory;
import modelo.Produto;

public class ProdutoController {

	private ProdutoDAO produtoDAO;

	public ProdutoController(){
		Connection connection = new ConnectionFactory().recuperaConexao();
		this.produtoDAO = new ProdutoDAO(connection);
	}


	public void deletar(Integer id) {
		produtoDAO.deletar(id);
	}

	public void salvar(Produto produto) {
		produtoDAO.salvar(produto);
	}

	public List<Produto> listar() {
		return produtoDAO.listar();
	}

	public void alterar(String nome, String descricao, Integer id){
		produtoDAO.alterar(nome,descricao,id);
	}
}
