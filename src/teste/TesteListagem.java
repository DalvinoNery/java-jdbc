package teste;

import factory.ConnectionFactory;

import java.sql.*;

public class TesteListagem {

    public static void main(String [] args) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();

        Connection connection = connectionFactory.recuperaConexao();
        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM produto");
        pstm.execute();
        ResultSet rst = pstm.getResultSet();

        while (rst.next()){
            int id = rst.getInt("ID");
            System.out.println("ID - "+ id);
            String nome = rst.getString("nome");
            System.out.println("nome - "+ nome);
            String descricao = rst.getString("descricao");
            System.out.println("descrição - "+ descricao);
        }

        connection.close();
    }
}
