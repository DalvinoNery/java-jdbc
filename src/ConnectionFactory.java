import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory {

    public DataSource dataSource;
    /*Configuração do pool de conexão*/
    public ConnectionFactory() {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UCT");
        comboPooledDataSource.setUser("root");
        comboPooledDataSource.setPassword("12345678");
        comboPooledDataSource.setMaxPoolSize(15);/*Quantidade máxima de conexões*/
        this.dataSource = comboPooledDataSource;
    }

    public Connection recuperaConexao() throws SQLException {
        return this.dataSource.getConnection();

    }
}
