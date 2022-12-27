package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static Connection conexao = null;
    private static String senha;

    private Conexao() {

    }

    public static Connection getConexao() throws ClassNotFoundException, SQLException {

        if (conexao == null) {
            String url = "jdbc:postgresql://localhost:5432/pessoas";
            String usuario = "postgres";

            Class.forName("org.postgresql.Driver");
            conexao = DriverManager.getConnection(url, usuario, senha);
        }

        return conexao;
    }

    public static void setSenha(String password) {
        senha = password;
    }

}