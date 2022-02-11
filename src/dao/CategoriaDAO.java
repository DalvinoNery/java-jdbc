package dao;

import modelo.Categoria;
import modelo.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {

    private Connection connection;

    public CategoriaDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Categoria> listar(){
        try {
            List<Categoria> listaCategoria = new ArrayList<>();
            String sql = "SELECT ID, NOME FROM CATEGORIA";
            try (PreparedStatement pstm = connection.prepareStatement(sql)) {
                pstm.execute();
                try (ResultSet rst = pstm.getResultSet()) {
                    while (rst.next()) {
                        Categoria categoria = new Categoria(rst.getInt(1), rst.getString(2));
                        listaCategoria.add(categoria);
                    }
                }
            }
            return listaCategoria;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Categoria> listarComProduto() throws SQLException {
        Categoria ultima = null;
        List<Categoria> listaCategoria = new ArrayList<>();
        String sql = "SELECT C.ID, C.NOME, P.ID, P.NOME, P.DESCRICAO FROM CATEGORIA C INNER JOIN PRODUTO P ON C.ID = P.CATEGORIA_ID";
        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.execute();
            try (ResultSet rst = pstm.getResultSet()) {
                while (rst.next()) {
                    if(ultima== null || !ultima.getNome().equals(rst.getString(2))){
                        Categoria categoria = new Categoria(rst.getInt(1), rst.getString(2));
                        ultima = categoria;
                        listaCategoria.add(categoria);
                    }
                    Produto produto = new Produto(rst.getInt(3), rst.getString(4), rst.getString(5));
                    ultima.adicionarProduto(produto);
                }
            }
        }
        return listaCategoria;
    }




}
