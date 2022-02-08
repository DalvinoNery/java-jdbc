import java.sql.*;

public class TesteRemocao {

    public static void main(String [] args) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();

        Connection connection = connectionFactory.recuperaConexao();
        PreparedStatement pstm = connection.prepareStatement("DELETE FROM produto WHERE id > ? ");
        pstm.setInt(1, 13);
        pstm.execute();
        Integer linhasModificada = pstm.getUpdateCount();


        System.out.println("Quantidade de registros excluídos:  "+ linhasModificada);


        connection.close();
    }
}
