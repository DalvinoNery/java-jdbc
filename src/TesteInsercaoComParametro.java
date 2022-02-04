import java.sql.*;

public class TesteInsercaoComParametro {

    public static void main(String[] args) throws SQLException {
        /*Ao utilizar o try-with-resource (try(...)) não é necessário fechar
        * a conexão, pois o recurso realiza essa ação após a conclusão do processo.
        * Isso pq as classes  Connection, PreparedStatement e ResultSet extendem
        * da classe AutoCloseable.*/
        ConnectionFactory connectionFactory = new ConnectionFactory();
       try(Connection connection = connectionFactory.recuperaConexao()) {
           connection.setAutoCommit(false);
           try (PreparedStatement pstm = connection.prepareStatement("insert into produto (nome, descricao) values (?, ?)", Statement.RETURN_GENERATED_KEYS);) {

               adicionarVariavel("Monitor", "Acer 19'", pstm);
               adicionarVariavel("Suporte para Notebook", "15 polegadas", pstm);
               connection.commit();

           } catch (Exception e) {
            /*Caso ocorra algum erro ao realizar as execuções das sql's, a exceção será lançada e um
            rollback da transação será executado.*/
               e.getStackTrace();
               connection.rollback();

           }
       }
    }

    private static void adicionarVariavel(String nome, String descricao, PreparedStatement pstm) throws SQLException {
        pstm.setString(1, nome);
        pstm.setString(2, descricao);
        pstm.execute();
        try(ResultSet rst = pstm.getGeneratedKeys()) {
            while (rst.next()) {
                int id = rst.getInt(1);
                System.out.println("ID - " + id);
            }
        }
    }
}
