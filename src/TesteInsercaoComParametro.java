import java.sql.*;

public class TesteInsercaoComParametro {

    public static void main(String [] args) throws SQLException {

        ConnectionFactory connectionFactory = new ConnectionFactory();

        Connection connection = connectionFactory.recuperaConexao();
        PreparedStatement pstm = connection.prepareStatement("insert into produto (nome, descricao) values (?, ?)", Statement.RETURN_GENERATED_KEYS);

        adicionarVariavel("Monitor", "Acer 19'", pstm);
        adicionarVariavel("Suporte para Notebook", "15 polegadas", pstm);
    }

    private static void adicionarVariavel(String nome, String descricao, PreparedStatement pstm) throws SQLException {
        pstm.setString(1, nome);
        pstm.setString(2, descricao);
        pstm.execute();
        ResultSet rst = pstm.getGeneratedKeys();

        while (rst.next()){
            int id = rst.getInt(1);
            System.out.println("ID - "+ id);
        }

        rst.close();
    }
}
