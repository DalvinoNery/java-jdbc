package teste;

import dao.CategoriaDAO;
import factory.ConnectionFactory;
import modelo.Categoria;
import modelo.Produto;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TestaListagemCategoria {

    public static void main(String[] args) throws SQLException {

        try (Connection connection = new ConnectionFactory().recuperaConexao()) {
            CategoriaDAO categoriaDAO = new CategoriaDAO(connection);
            List<Categoria> listaCateorgia = categoriaDAO.listarComProduto();
            listaCateorgia.stream().forEach(categoria -> {
                System.out.println(categoria);
                for (Produto produto : categoria.getListaProdutos()) {
                    System.out.println(categoria.getNome() + " - " + produto.getNome());
                }
            });

        }
    }
}
