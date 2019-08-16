package pt.c07bd.s01basico.s03generico;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App03ConsultaTaxonomia
{

    public static void main(String args[])
    {
        System.out.println("BD MySQL:");
        executaConsulta("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/biblioteca", "root", "thelab");
        System.out.println();
        
        System.out.println("BD HSQLDB:");
        executaConsulta("org.hsqldb.jdbc.JDBCDriver", "jdbc:hsqldb:file:db/hsqldb/biblioteca;shutdown=true", "SA", "");

        /*
        System.out.println("BD Cloudscape Derby:");
        executaConsulta("org.apache.derby.jdbc.EmbeddedDriver", "jdbc:derby:db/derby/biblioteca;create=true", "", "");

        System.out.println("BD MS Access:");
        executaConsulta("sun.jdbc.odbc.JdbcOdbcDriver", "jdbc:odbc:BancoDados", "", "");
        */

        System.out.println();
    }

    public static void executaConsulta(String driver, String bd, String usuario, String senha)
    {

        try {
            Class.forName(driver);

            Connection conexao = DriverManager.getConnection(bd, usuario, senha);

            Statement comando = conexao.createStatement();

            ResultSet resultado = comando.executeQuery("SELECT Categoria, Superior FROM Taxonomia");

            boolean temConteudo = resultado.next();
            while (temConteudo)
            {
              String categoria= resultado.getString("Categoria"),
                     superior = resultado.getString("Superior");
              System.out.println(categoria + "; " + superior);
              temConteudo = resultado.next();
            }

            comando.close();

            conexao.close();

        } catch (ClassNotFoundException erro) {
            System.out.println(erro.getMessage());
        } catch (SQLException erro) {
            System.out.println("Erro no SQL: " + erro.getMessage());
        }
    }

}
