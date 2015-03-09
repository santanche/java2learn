package pt.c07bd.s01basico.s03generico;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class App01CriaTabelaTaxonomia
{
    public static void main(String args[])
    {
        System.out.println("BD MySQL:");
        geraTabela("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/biblioteca", "root", "thelab");
        System.out.println();
        
        /*
        System.out.println("BD Cloudscape Derby:");
        geraTabela("org.apache.derby.jdbc.EmbeddedDriver", "jdbc:derby:db/derby/biblioteca;create=true", "", "");

        System.out.println("BD HSQLDB:");
        geraTabela("org.hsqldb.jdbc.JDBCDriver", "jdbc:hsqldb:file:db/hsqldb/biblioteca;shutdown=true", "SA", "");

        System.out.println("BD MS Access:");
        geraTabela("sun.jdbc.odbc.JdbcOdbcDriver", "jdbc:odbc:BancoDados", "", "");
        */

        System.out.println();
    }
    
    public static void geraTabela(String driver, String bd, String usuario, String senha)
    {

        try {
            // carrega classe com implementacao para o driver
            //   neste caso o driver MySQL
            Class.forName(driver);

            // estabelece conexao com a base de dados
            Connection conexao = DriverManager.getConnection(bd, usuario, senha);

            // cria um objeto de comandos SQL para a base
            Statement comando = conexao.createStatement();

            // aciona metodo que executa comando SQL (este metodo e especialmente usado para atualizacao)
            comando.executeUpdate(
                    "CREATE TABLE Taxonomia " +
                    "(Categoria VARCHAR(100) NOT NULL, Superior VARCHAR(100), " +
                    " PRIMARY KEY (Categoria))");

            // fecha comando
            comando.close();

            // fecha conexao
            conexao.close();

            System.out.println("Tabela criada com sucesso!");

        } catch (ClassNotFoundException erro) {
            System.out.println(erro.getMessage());
        } catch (SQLException erro) {
            System.out.println("Erro no SQL: " + erro.getMessage());
        }
    }

}