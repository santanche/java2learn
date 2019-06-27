package pt.c07bd.s01basico.s03generico;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App03ConsultaMarcadores
{

    public static void main(String args[])
    {
        /*
    	System.out.println("BD MySQL:");
        executaConsulta("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/biblioteca", "root", "thelab");
        System.out.println();
        */
        
        System.out.println("BD Cloudscape Derby:");
        executaConsulta("org.apache.derby.jdbc.EmbeddedDriver", "jdbc:derby:db/derby/biblioteca;create=true", "", "");

        /*
        System.out.println("BD HSQLDB:");
        executaConsulta("org.hsqldb.jdbc.JDBCDriver", "jdbc:hsqldb:file:db/hsqldb/biblioteca;shutdown=true", "SA", "");

        System.out.println("BD MS Access:");
        executaConsulta("sun.jdbc.odbc.JdbcOdbcDriver", "jdbc:odbc:BancoDados", "", "");
        */

        System.out.println();
    }

    public static void executaConsulta(String driver, String bd, String usuario, String senha)
    {

        try {
            // carrega classe com implementacao para o driver
            //   neste caso o driver MySQL
            Class.forName(driver);

            // estabelece conexao com a base de dados
            Connection conexao = DriverManager.getConnection(bd, usuario, senha);

            // cria um objeto de comandos SQL para a base
            Statement comando = conexao.createStatement();

            // aciona metodo que executa comando SQL (este metodo e especialmente usado para acesso)
            ResultSet resultado = comando.executeQuery("SELECT Titulo, Endereco, Acessos, Categoria FROM Marcadores");

            // lista o conteudo da tabela no console
            boolean temConteudo = resultado.next();
            while (temConteudo)
            {
                String titulo = resultado.getString("Titulo"),
                endereco = resultado.getString("Endereco");
                int acessos = resultado.getInt("Acessos");
                String categoria = resultado.getString("Categoria");
                System.out.println(titulo + "; " + endereco + "; " + acessos + "; " + categoria);
                temConteudo = resultado.next();
            }

            // fecha comando
            comando.close();

            // fecha conexao
            conexao.close();

        } catch (ClassNotFoundException erro) {
            System.out.println(erro.getMessage());
        } catch (SQLException erro) {
            System.out.println("Erro no SQL: " + erro.getMessage());
        }
    }

}
