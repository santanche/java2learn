package pt.c07bd.s10oorelacional;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App02ListaRelacionalTaxonomia
{
      public static void main(String argumentos[])
      {

        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");

            Connection conexao = DriverManager.getConnection(
                    "jdbc:hsqldb:file:db/hsqldb/biblioteca-oo;shutdown=true", "SA", "");

          Statement comando = conexao.createStatement();

          String stringComando = "SELECT Categoria, Superior FROM Taxonomia";
            
          System.out.println(stringComando);
         
          ResultSet resultado = comando.executeQuery(stringComando);

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
