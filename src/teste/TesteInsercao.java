package teste;

import factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteInsercao {

    public static void main(String [] args) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();

        Connection connection = connectionFactory.recuperaConexao();
        Statement stm = connection.createStatement();
        stm.execute("insert into produto (nome, descricao) values ('Mouse', 'Maouse sem fio')", Statement.RETURN_GENERATED_KEYS);
        ResultSet rst = stm.getGeneratedKeys();

        while (rst.next()){
            int id = rst.getInt(1);
            System.out.println("ID - "+ id);
        }

        connection.close();
    }
}
