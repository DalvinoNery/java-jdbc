import dao.CategoriaDAO;
import modelo.Categoria;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TestaListagemCategoria {

    public static void main(String[] args) throws SQLException {

        try (Connection connection = new ConnectionFactory().recuperaConexao()) {
            CategoriaDAO categoriaDAO = new CategoriaDAO(connection);
            List<Categoria> listaCateorgia = categoriaDAO.listar();
            listaCateorgia.stream().forEach(categoria -> System.out.println(categoria));;

        }
    }
}
