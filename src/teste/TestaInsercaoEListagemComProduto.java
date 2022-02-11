package teste;

import dao.ProdutoDAO;
import factory.ConnectionFactory;
import modelo.Produto;

import java.sql.*;
import java.util.List;

public class TestaInsercaoEListagemComProduto {

    public static void main(String[] args) throws SQLException {
        Produto produto = new Produto("Geladeira Brastemp", "Branca 475L.");
        try (Connection connection = new ConnectionFactory().recuperaConexao()) {
            ProdutoDAO persistenciaProduto = new ProdutoDAO(connection);
            persistenciaProduto.salvar(produto);
            List<Produto> listaProdutos = persistenciaProduto.listar();

            listaProdutos.stream().forEach(produto1 -> System.out.println(produto1));

        }

    }
}
